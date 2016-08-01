package br.ufscar.systemExample_Enquete.model;
/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 */

import java.util.EventListener;

/**
 * Interface Listener para receber eventos da EnqueteSimples.
 * Toda classe interessada em processar os eventos lan�ados pela Enquete
 * deve implementar esta interface e se cadastrar no objeto EnqueteSimples
 * usando o m�todo addEnqueteListener().<br>
 * O metodo novoVoto() sera chamado quando um novo voto for contabilizado na Enquete.
 * O m�todo novaOpcao() ser� chamado quando uma nova op��o for adicionada na Enquete.
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public interface EnqueteListener extends EventListener {


	/**
	 * Infocado quando um novo voto � contabilizado na Enquete.
	 * @param event Evento gerado pela Enquete.
	 */
	public void novoVoto(EnqueteEvent event);

	/**
	 * Invocado quando uma nova op��o � adicionada � Enquete.
	 * @param event Evento gerado pela Enquete.
	 */
	public void novaOpcao(EnqueteEvent event);
}
