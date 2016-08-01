package br.ufscar.systemExample_Enquete.model;

/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 *    26/03/2003: rodrigor - Alterado o m�todo disparaNovoVoto() para receber uma op��o
 *                           Alterado o m�todo disparaNovaOpcao() para receber uma op��o
 *    23/03/2006: renata - Alterado c�dico para adicionar Generics do Java 5.0
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Armazena op��es a serem votadas,
 * incrementa votos e retorna os totais da vota��o. Esta classe
 * representa o modelo de neg�cio no exemplo sobre Model-View-Controller
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public class EnqueteSimples {

	private Map <String, Integer> opcoes;
	private List <EnqueteListener>enqueteListeners = new LinkedList();

	public EnqueteSimples(){
		opcoes = new HashMap<String, Integer>();
	}

	/**
	 * Adiciona uma op��o para ser votada na enquete
	 * @param opcao nome da op��o
	 */
	public void addOpcao(String opcao){
		opcoes.put(opcao,new Integer(0));
		this.disparaNovaOpcao(opcao);
	}

	/**
	 * Retorna um iterador de op��es dispon�veis na enquete
	 * @return Iterator op��es disponiveis na enquete
	 */
	public Set <String> getOpcoes(){
		return opcoes.keySet();
	}

	/**
	 * Incrementa um voto para op��o
	 * @param opcao op��o que receber� voto
	 */
	public void votar(String opcao){
		int votoAtual = (opcoes.get(opcao)).intValue();
		opcoes.put(opcao,new Integer(++votoAtual));
		this.disparaNovoVoto(opcao);
	}

	/**
	 * Retorna a soma dos votos de todas as op��es da enquete
	 * @return int soma dos votos de todas as op��es da enquete
	 */
	public int getTotalVotos(){
		int total = 0;
		for(Integer votos : opcoes.values()){
			total+= votos.intValue();
		}
		return total;
	}

	/**
	 * Retorna a quantidade de votos de uma op��o individual
	 * @param opcao op��o que se quer o voto
	 * @return int quantidade de votos da op��o
	 */
	public int getVotos(String opcao){
		return (opcoes.get(opcao)).intValue();
	}


	/**
	 * Adiciona um EnqueteListener, um objeto interessado em
	 * receber eventos lan�ados pela Enquete
	 * @see EnqueteListener
	 * @param listener objeto interessado em receber eventos
	 */
	public synchronized void addEnqueteListener(EnqueteListener listener){
		if(enqueteListeners.contains(listener)){ return; }
		this.enqueteListeners.add(listener);
	}

	/**
	 * Informa aos objetos interessados nos eventos lan�ados
	 * pela Enquete que um novo voto foi contabilizado.
	 */
	private synchronized void disparaNovoVoto(String opcao){		
		for(EnqueteListener listeners : this.enqueteListeners){
			listeners.novoVoto(new EnqueteEvent(this,opcao));
		}
	}

	/**
	 * Informa aos objetos interessados nos enventos lan�ados
	 * pela Enquete que uma nova op��o foi adicionada.
	 */
	private synchronized void disparaNovaOpcao(String opcao){		
		for(EnqueteListener listeners : this.enqueteListeners){
			listeners.novaOpcao(new EnqueteEvent(this,opcao));
		}
	}

}
