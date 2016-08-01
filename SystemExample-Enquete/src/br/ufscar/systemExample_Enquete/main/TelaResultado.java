package br.ufscar.systemExample_Enquete.main;

import java.awt.*;
import java.util.*;


/**
 * Janela que exibe o resultado da votação on-line. Esta tela é
 * atualizada a cada novo voto a uma opção da enquete.
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebouças de Almeida</a>
 * @since 24/03/2003
 **/
public class TelaResultado extends Window{

	private Map labels = new HashMap();

	public TelaResultado(Frame parent){
		super(parent);
		this.setSize(110,120);
		this.setLayout(new GridLayout(0,2)); // Grid com qualquer numero
											  // de linhas e uma coluna
		this.add(new Label("Votos"));
		this.add(new Label());

	}


	/**
	 * Recebe a lista de opcoes inicial
	 */
	public void inicializar(Iterator opcoes) {
		String opcao;

		Label label;
		Label votos;
		while(opcoes.hasNext()){
			opcao = (String)opcoes.next();
			if(!labels.containsKey(opcao)){
				label = new Label(opcao+" - ");
				votos = new Label(""+0);
				labels.put(opcao,votos);
				this.add(label);
				this.add(votos);
			}
		}
	}

	public void novoVoto(String opcao, int nvotos) {
		Label votos;
		votos = (Label)labels.get(opcao);
		votos.setText(""+nvotos);
	}

}
