package br.ufscar.testes.wizard;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

/**
 * This class displays an address book, using a wizard to add a new entry
 */
public class AddressBook extends ApplicationWindow {
  // The running instance of the application
  private static AddressBook APP;

  // The action that launches the wizard
  AddEntryAction addEntryAction;

  // The entries in the address book
  java.util.List entries;

  // The view
  private TableViewer viewer;

  /**
   * AddressBook constructor
   */
  public AddressBook() {
    super(null);

    // Store a reference to the running app
    APP = this;

    // Create the action and the entries collection
    addEntryAction = new AddEntryAction();
    entries = new LinkedList();

    // Create the toolbar
    addToolBar(SWT.NONE);
  }

  /**
   * Gets a reference to the running application
   * 
   * @return AddressBook
   */
  public static AddressBook getApp() {
    return APP;
  }

  /**
   * Runs the application
   */
  public void run() {
    // Don't return from open() until window closes
    setBlockOnOpen(true);

    // Open the main window
    open();

    // Dispose the display
    Display.getCurrent().dispose();
  }

  /**
   * Adds an entry
   * 
   * @param entry
   *            the entry
   */
  public void add(AddressEntry entry) {
    entries.add(entry);
    refresh();
  }

  /**
   * Configures the shell
   * 
   * @param shell
   *            the shell
   */
  protected void configureShell(Shell shell) {
    super.configureShell(shell);

    // Set the title bar text
    shell.setText("Address Book");
    shell.setSize(600, 400);
  }

  /**
   * Creates the main window's contents
   * 
   * @param parent
   *            the main window
   * @return Control
   */
  protected Control createContents(Composite parent) {
    // Create the table viewer
    viewer = new TableViewer(parent);
    viewer.setContentProvider(new AddressBookContentProvider());
    viewer.setLabelProvider(new AddressBookLabelProvider());
    viewer.setInput(entries);

    // Set up the table
    Table table = viewer.getTable();
    new TableColumn(table, SWT.LEFT).setText("First Name");
    new TableColumn(table, SWT.LEFT).setText("Last Name");
    new TableColumn(table, SWT.LEFT).setText("E-mail Address");
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    // Update the column widths
    refresh();

    return table;
  }

  /**
   * Creates the toolbar
   * 
   * @param style
   *            the toolbar style
   * @return ToolBarManager
   */
  protected ToolBarManager createToolBarManager(int style) {
    ToolBarManager tbm = new ToolBarManager(style);

    // Add the action to launch the wizard
    tbm.add(addEntryAction);

    return tbm;
  }

  /**
   * Updates the column widths
   */
  private void refresh() {
    viewer.refresh();

    // Pack the columns
    Table table = viewer.getTable();
    for (int i = 0, n = table.getColumnCount(); i < n; i++) {
      table.getColumn(i).pack();
    }
  }

  /**
   * The application entry point
   * 
   * @param args
   *            the command line arguments
   */
  public static void main(String[] args) {
    new AddressBook().run();
  }
}

/**
 * This class contains an entry in the Address Book
 */

class AddressEntry {
  private String lastName;

  private String firstName;

  private String email;

  /**
   * Gets the e-mail
   * 
   * @return String
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the e-mail
   * 
   * @param email
   *            The email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the first name
   * 
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name
   * 
   * @param firstName
   *            The firstName to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name
   * 
   * @return String
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name
   * 
   * @param lastName
   *            The lastName to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}

/**
 * This class launches the add entry wizard
 */

class AddEntryAction extends Action {
  /**
   * AddEntryAction constructor
   */
  public AddEntryAction() {
    super("Add Entry", ImageDescriptor.createFromFile(AddEntryAction.class,
        "/images/addEntry.gif"));
    setToolTipText("Add Entry");
  }

  /**
   * Runs the action
   */
  public void run() {
    WizardDialog dlg = new WizardDialog(AddressBook.getApp().getShell(),
        new AddEntryWizard());
    dlg.open();
  }
}

/**
 * This class represents the wizard for adding entries to the address book
 */

class AddEntryWizard extends Wizard {
  // The pages in the wizard
  private WelcomePage welcomePage;

  private NamePage namePage;

  private EmailPage emailPage;

  /**
   * AddEntryWizard constructor
   */
  public AddEntryWizard() {
    // Create the pages
    welcomePage = new WelcomePage();
    namePage = new NamePage();
    emailPage = new EmailPage();

    // Add the pages to the wizard
    addPage(welcomePage);
    addPage(namePage);
    addPage(emailPage);

    // Set the dialog window title
    setWindowTitle("Address Book Entry Wizard");
  }

  /**
   * Called when user clicks Finish Creates the entry in the address book
   */
  public boolean performFinish() {
    // Create the entry based on the inputs
    AddressEntry entry = new AddressEntry();
    entry.setFirstName(namePage.getFirstName());
    entry.setLastName(namePage.getLastName());
    entry.setEmail(emailPage.getEmail());

    AddressBook.getApp().add(entry);

    // Return true to exit wizard
    return true;
  }
}

/**
 * This page collects the e-mail address
 */

class EmailPage extends WizardPage {
  // The e-mail address
  private String email = "";

  /**
   * EmailPage constructor
   */
  public EmailPage() {
    super("E-mail", "E-mail Address", ImageDescriptor.createFromFile(
        EmailPage.class, "/images/email.gif"));
    setDescription("Enter the e-mail address");

    // Page isn't complete until an e-mail address has been added
    setPageComplete(false);
  }

  /**
   * Creates the contents of the page
   * 
   * @param parent
   *            the parent composite
   */
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(2, false));

    // Create the label and text box to hold email address
    new Label(composite, SWT.LEFT).setText("E-mail Address:");
    final Text ea = new Text(composite, SWT.BORDER);
    ea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Add handler to update e-mail based on input
    ea.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent event) {
        email = ea.getText();
        setPageComplete(email.length() > 0);
      }
    });

    setControl(composite);
  }

  /**
   * Gets the e-mail
   * 
   * @return String
   */
  public String getEmail() {
    return email;
  }
}

/**
 * This page displays a welcome message
 */

class WelcomePage extends WizardPage {
  /**
   * WelcomePage constructor
   */
  protected WelcomePage() {
    super("Welcome", "Welcome", ImageDescriptor.createFromFile(
        WelcomePage.class, "/images/welcome.gif"));
    setDescription("Welcome to the Address Book Entry Wizard");
  }

  /**
   * Creates the page contents
   * 
   * @param parent
   *            the parent composite
   */
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new FillLayout(SWT.VERTICAL));
    new Label(composite, SWT.CENTER)
        .setText("Welcome to the Address Book Entry Wizard!");
    new Label(composite, SWT.LEFT)
        .setText("This wizard guides you through creating an Address Book entry.");
    new Label(composite, SWT.LEFT).setText("Click Next to continue.");
    setControl(composite);
  }
}

/**
 * This page collects the first and last names
 */

class NamePage extends WizardPage {
  // The first and last names
  private String firstName = "";

  private String lastName = "";

  /**
   * NamePage constructor
   */
  public NamePage() {
    super("Name", "Name", ImageDescriptor.createFromFile(NamePage.class,
        "/images/name.gif"));
    setDescription("Enter the first and last names");
    setPageComplete(false);
  }

  /**
   * Creates the page contents
   * 
   * @param parent
   *            the parent composite
   */
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(2, false));

    // Create the label and text field for first name
    new Label(composite, SWT.LEFT).setText("First Name:");
    final Text first = new Text(composite, SWT.BORDER);
    first.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Create the label and text field for last name
    new Label(composite, SWT.LEFT).setText("Last Name:");
    final Text last = new Text(composite, SWT.BORDER);
    last.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    // Add the handler to update the first name based on input
    first.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent event) {
        firstName = first.getText();
        setPageComplete(firstName.length() > 0 && lastName.length() > 0);
      }
    });

    // Add the handler to update the last name based on input
    last.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent event) {
        lastName = last.getText();
        setPageComplete(firstName.length() > 0 && lastName.length() > 0);
      }
    });

    setControl(composite);
  }

  /**
   * Gets the first name
   * 
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name
   * 
   * @return String
   */
  public String getLastName() {
    return lastName;
  }
}

/**
 * This class provides the content for the AddressBook application
 */

class AddressBookContentProvider implements IStructuredContentProvider {
  /**
   * Gets the elements
   * 
   * @param inputElement
   *            the List of elements
   * @return Object[]
   */
  public Object[] getElements(Object inputElement) {
    return ((List) inputElement).toArray();
  }

  /**
   * Disposes any resources
   */
  public void dispose() {
    // Do nothing
  }

  /**
   * Called when the input changes
   * 
   * @param viewer
   *            the viewer
   * @param oldInput
   *            the old input
   * @param newInput
   *            the new input
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    // Do nothing
  }
}

/**
 * This class provides the labels for the Address Book application
 */

class AddressBookLabelProvider implements ITableLabelProvider {
  /**
   * Gets the image for the column
   * 
   * @param element
   *            the element
   * @param columnIndex
   *            the column index
   */
  public Image getColumnImage(Object element, int columnIndex) {
    return null;
  }

  /**
   * Gets the text for the column
   * 
   * @param element
   *            the element
   * @param columnIndex
   *            the column index
   */
  public String getColumnText(Object element, int columnIndex) {
    AddressEntry ae = (AddressEntry) element;
    switch (columnIndex) {
    case 0:
      return ae.getFirstName();
    case 1:
      return ae.getLastName();
    case 2:
      return ae.getEmail();
    }
    return "";
  }

  /**
   * Adds a listener
   * 
   * @param listener
   *            the listener
   */
  public void addListener(ILabelProviderListener listener) {
    // Do nothing
  }

  /**
   * Disposes any resources
   */
  public void dispose() {
    // Do nothing
  }

  /**
   * Returns true if changing the property for the element would change the
   * label
   * 
   * @param element
   *            the element
   * @param property
   *            the property
   */
  public boolean isLabelProperty(Object element, String property) {
    return false;
  }

  /**
   * Removes a listener
   * 
   * @param listener
   *            the listener
   */
  public void removeListener(ILabelProviderListener listener) {
    // Do nothing
  }
}