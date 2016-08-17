package br.ufscar.systemExampleMVC_SimplesComDesvio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SystemExampleMVC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastrarPessoa;
	private JMenuItem mntmCadastrar;
	private static JDesktopPane desktopPane;
	private JMenuItem mntmVisualizar;

	/**
	 * Create the frame.
	 */
	public SystemExampleMVC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getDesktopPane(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnCadastrarPessoa());
		}
		return menuBar;
	}
	private JMenu getMnCadastrarPessoa() {
		if (mnCadastrarPessoa == null) {
			mnCadastrarPessoa = new JMenu("Cadastrar Pessoa");
			mnCadastrarPessoa.add(getMntmCadastrar());
			mnCadastrarPessoa.add(getMntmVisualizar());
		}
		return mnCadastrarPessoa;
	}
	private JMenuItem getMntmCadastrar() {
		if (mntmCadastrar == null) {
			mntmCadastrar = new JMenuItem("Cadastrar");
			mntmCadastrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CadastrarPessoa cadastrar = new CadastrarPessoa();
					SystemExampleMVC.desktopPane.add(cadastrar);
					cadastrar.show();
				}
			});
		}
		return mntmCadastrar;
	}
	private JDesktopPane getDesktopPane() {
		if (desktopPane == null) {
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(Color.WHITE);
		}
		return desktopPane;
	}
	private JMenuItem getMntmVisualizar() {
		if (mntmVisualizar == null) {
			mntmVisualizar = new JMenuItem("Visualizar");
			mntmVisualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualizarPessoas visualizar = new VisualizarPessoas();
					SystemExampleMVC.desktopPane.add(visualizar);
					visualizar.show();
				}
			});
		}
		return mntmVisualizar;
	}
}
