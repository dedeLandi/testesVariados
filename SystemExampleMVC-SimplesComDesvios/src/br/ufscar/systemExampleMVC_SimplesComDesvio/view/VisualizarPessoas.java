package br.ufscar.systemExampleMVC_SimplesComDesvio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import br.ufscar.systemExampleMVC_SimplesComDesvio.controller.ControllerPessoa;
import br.ufscar.systemExampleMVC_SimplesComDesvio.model.Pessoa;

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
		//DESVIO
		Pessoa novaPessoa = new Pessoa("DESVIO","DESVIO","DESVIO");
		System.out.println(novaPessoa.toString());
		
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
