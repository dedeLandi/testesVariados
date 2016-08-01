package br.ufscar.systemExample_Enquete.model;

/*
 * Historico:
 *    24/03/2003: rodrigor - Criação da classe
 *    26/03/2003: rodrigor - Criação do construtor que recebe uma opcao e um source
 *                           Criação do método getEnqueteSimples()
 *                           Criação do método getOpcao();
 *    31/03/2003: rodrigor - Criado o método getVotos();
 * 							 Excluido o método getEnqueteSimples();
 */


import java.util.EventObject;


/**
 * Evento gerado pelo modelo da aplicação (classe EnqueteSimples).
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebouças de Almeida</a>
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
	 * Retorna a opção associada ao evento gerado.
	 * A opção pode ser uma nova opção adicionada à EnqueteSimples
	 * ou a opção escolhida para adicionar um novo voto.
	 * @return String opção
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
