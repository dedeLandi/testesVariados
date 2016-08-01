package br.ufscar.systemExample_Enquete.view;

/*
 * Historico:
 *    24/03/2003: rodrigor - Criação da classe
 *    26/03/2003: rodrigor - Alterados os métodos novoVoto() e novaOpcao().
 *                           Estes métodos foram adaptados às alterações no objeto
 *                           EnqueteEvent.
 *    23/03/2006: renata - Alterado códico para adicionar Generics do Java 5.0
 */
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import br.ufscar.systemExample_Enquete.model.EnqueteEvent;
import br.ufscar.systemExample_Enquete.model.EnqueteListener;

/**
 * Janela que exibe o resultado percentual da votação on-line.
 * Esta tela é atualizada a cada novo voto a uma opção da enquete.
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebouças de Almeida</a>
 * @since 24/03/2003
 */
public class TelaResultadoPercentual extends Window implements EnqueteListener{

	private Map <String,Label>labels = new HashMap();

	public TelaResultadoPercentual(Frame parent){
		super(parent);
		this.setSize(180,120);
		this.setLayout(new GridLayout(0,2)); // Grid com qualquer numero
											  // de linhas e uma coluna
		this.add(new Label("Percentual"));
		this.add(new Label());
	}



	/**
	 * @see enquete.model.EnqueteListener#novaOpcao(EnqueteEvent)
	 */
	public void novaOpcao(EnqueteEvent event) {
		String opcao = event.getOpcao();

		Label label;
		Label votos;
		if(!labels.containsKey(opcao)){
			label = new Label(opcao+" - ");
			votos = new Label(""+event.getVotos()+" %");
			labels.put(opcao,votos);
			this.add(label);
			this.add(votos);
		}
	}

	/**
	 * @see enquete.model.EnqueteListener#novoVoto(EnqueteEvent)
	 */
	public void novoVoto(EnqueteEvent event) {
		String opcao = event.getOpcao();

		Label votos;
		votos = labels.get(opcao);
		votos.setText(""+(event.getVotos()*100/event.getTotalVotos())+" %");
	}


}
