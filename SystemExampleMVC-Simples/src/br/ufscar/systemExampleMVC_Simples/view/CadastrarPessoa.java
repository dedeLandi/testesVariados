package br.ufscar.systemExampleMVC_Simples.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufscar.systemExampleMVC_Simples.controller.ControllerPessoa;

public class CadastrarPessoa extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNome;
	private JTextField textField;
	private JLabel lblIdade;
	private JTextField textField_1;
	private JLabel lblProfisso;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPessoa frame = new CadastrarPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarPessoa() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getBtnNewButton(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);

	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cadastrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cadastrar();
				}
			});
		}
		return btnNewButton;
	}
	protected void cadastrar() {

		ControllerPessoa.cadastrarUmaPessoa(textField.getText(), textField_1.getText(),textField_2.getText());
		JOptionPane.showMessageDialog(this, "Cadastro Realizado");
		
	}

	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.anchor = GridBagConstraints.EAST;
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 0;
			panel.add(getLblNome(), gbc_lblNome);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			panel.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_lblIdade = new GridBagConstraints();
			gbc_lblIdade.anchor = GridBagConstraints.EAST;
			gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
			gbc_lblIdade.gridx = 0;
			gbc_lblIdade.gridy = 1;
			panel.add(getLblIdade(), gbc_lblIdade);
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			panel.add(getTextField_1(), gbc_textField_1);
			GridBagConstraints gbc_lblProfisso = new GridBagConstraints();
			gbc_lblProfisso.anchor = GridBagConstraints.EAST;
			gbc_lblProfisso.insets = new Insets(0, 0, 0, 5);
			gbc_lblProfisso.gridx = 0;
			gbc_lblProfisso.gridy = 2;
			panel.add(getLblProfisso(), gbc_lblProfisso);
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			panel.add(getTextField_2(), gbc_textField_2);
		}
		return panel;
	}
	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
		}
		return lblNome;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblIdade() {
		if (lblIdade == null) {
			lblIdade = new JLabel("Idade");
		}
		return lblIdade;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblProfisso() {
		if (lblProfisso == null) {
			lblProfisso = new JLabel("Profiss\u00E3o");
		}
		return lblProfisso;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
}
