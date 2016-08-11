package br.ufscar.systemExampleMVC_Simples;

import java.awt.EventQueue;

import br.ufscar.systemExampleMVC_Simples.view.SystemExampleMVC;

public class ExecuteSystem {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemExampleMVC frame = new SystemExampleMVC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
