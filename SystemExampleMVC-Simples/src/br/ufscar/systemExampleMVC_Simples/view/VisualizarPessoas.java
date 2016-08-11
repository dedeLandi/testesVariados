package br.ufscar.systemExampleMVC_Simples.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import br.ufscar.systemExampleMVC_Simples.controller.ControllerPessoa;

import java.awt.BorderLayout;

public class VisualizarPessoas extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarPessoas frame = new VisualizarPessoas();
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
	public VisualizarPessoas() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getTextArea(), BorderLayout.CENTER);
		preencherDados();
	}

	private void preencherDados() {
		textArea.setText(ControllerPessoa.visualizaPessoas());
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setEditable(false);
		}
		return textArea;
	}
}
