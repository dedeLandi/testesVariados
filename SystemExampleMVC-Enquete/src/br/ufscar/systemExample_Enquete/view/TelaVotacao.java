package br.ufscar.systemExample_Enquete.view;

/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 *    25/03/2003: rodrigor - Altera��o do construtor: Agora recebe o controller
 *    26/03/2003: rodrigor - Alterado o m�todo novaOpcao()
 *                           Este m�todo foi adaptado �s altera��es no objeto
 *                           EnqueteEvent.
 *    31/03/2003: rodrigor - Alterei o construtor para receber um ActionListener
 *    23/03/2006: renata - Alterado c�dico para adicionar Generics do Java 5.0
 */
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

import br.ufscar.systemExample_Enquete.model.EnqueteEvent;
import br.ufscar.systemExample_Enquete.model.EnqueteListener;

/**
 * Esta janela � usada para efetivar o voto em alguma das op��es dispon�veis
 * na enquete.
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public class TelaVotacao extends Frame implements EnqueteListener{


	private Collection <String>botoes = new ArrayList();

	private ActionListener controller;

	public TelaVotacao(ActionListener controller){
		super("Tela de Vota��o - Enquete");
		this.setSize(100,120);
		this.setLayout(new GridLayout(0,1)); // Grid com qualquer numero
											  // de linhas e uma coluna
		this.controller = controller;
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	e.getWindow().hide();
	        	System.exit(0);
	        }
	    });
	}

	/**
	 * @see enquete.model.EnqueteListener#novaOpcao(EnqueteEvent)
	 */
	public void novaOpcao(EnqueteEvent event) {
		String opcao = event.getOpcao();
		Button botao;

		if(!botoes.contains(opcao)){
			botoes.add(opcao);
			botao = new Button(opcao);
			botao.setActionCommand(opcao);
			botao.addActionListener(controller);
			this.add(botao);
		}
	}

	/**
	 * @see enquete.model.EnqueteListener#novoVoto(EnqueteEvent)
	 */
	public void novoVoto(EnqueteEvent event) {
		// Nothing to do
	}

}
