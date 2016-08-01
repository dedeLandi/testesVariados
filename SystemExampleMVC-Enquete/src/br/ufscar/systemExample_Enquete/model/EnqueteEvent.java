package br.ufscar.systemExample_Enquete.model;

/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 *    26/03/2003: rodrigor - Cria��o do construtor que recebe uma opcao e um source
 *                           Cria��o do m�todo getEnqueteSimples()
 *                           Cria��o do m�todo getOpcao();
 *    31/03/2003: rodrigor - Criado o m�todo getVotos();
 * 							 Excluido o m�todo getEnqueteSimples();
 */


import java.util.EventObject;


/**
 * Evento gerado pelo modelo da aplica��o (classe EnqueteSimples).
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public class EnqueteEvent extends EventObject {

	private String opcao = null;
	private int votos = 0;

	public EnqueteEvent(EnqueteSimples source){
		super(source);
	}
	public EnqueteEvent(EnqueteSimples source,String opcao){
		this(source);
		this.opcao = opcao;
	}

	/**
	 * Retorna a op��o associada ao evento gerado.
	 * A op��o pode ser uma nova op��o adicionada � EnqueteSimples
	 * ou a op��o escolhida para adicionar um novo voto.
	 * @return String op��o
	 */
	public String getOpcao() {
		return opcao;
	}

	/**
	 * Retorna o numero de votos da opcao
	 * @return int votos
	 */
	public int getVotos() {
		return ((EnqueteSimples)this.source).getVotos(opcao);
	}

	/**
	 * Retorna o total de votos da enquete
	 * @return int
	 */
	public int getTotalVotos() {
		return ((EnqueteSimples)this.source).getTotalVotos();
	}

}
