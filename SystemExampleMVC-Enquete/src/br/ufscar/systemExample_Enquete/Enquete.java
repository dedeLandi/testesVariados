package br.ufscar.systemExample_Enquete;

/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 */

import java.applet.Applet;

import br.ufscar.systemExample_Enquete.controller.TelaVotacaoCtrl;
import br.ufscar.systemExample_Enquete.model.EnqueteSimples;
import br.ufscar.systemExample_Enquete.view.TelaResultado;
import br.ufscar.systemExample_Enquete.view.TelaResultadoPercentual;
import br.ufscar.systemExample_Enquete.view.TelaVotacao;

/**
 * Este � um exemplo de sistema que usa o padr�o arquitetural
 * Model-View-Controller (MVC). Esta classe simula o sistema
 * que faz o binding entre os componentes da arquitetura, ou seja,
 * ao executar esta classe, os componentes s�o "plugados" de modo
 * a permitir a execu��o do sistema.<p>
 * Para executar, digite "java enquete.Enquete", ou abra o arquivo
 * "enquete.htm" em seu browser.
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public class Enquete extends Applet{

	public static void main(String[] args) {
		Enquete e = new Enquete();
		e.start();
	}


	/**
	 * Inicia o Applet.
	 *
	 * @see java.applet.Applet#start()
	 */
	public void start() {
		super.start();

		// Modelo
		EnqueteSimples enquete= new EnqueteSimples();

		// Controlador da Interface "TelaVotacao"
		TelaVotacaoCtrl ctrl = new TelaVotacaoCtrl(enquete);

		// Interface que altera o estado do modelo
		TelaVotacao votacao = new TelaVotacao(ctrl);
		votacao.setLocation(5,5);

		// Interface que exibe o resultado absoluto da votacao
		TelaResultado resultado = new TelaResultado(votacao);
		resultado.setLocation(120,5);

		// Interface que exibe o resultado percentual da votacao
		TelaResultadoPercentual resultadoPerc = new TelaResultadoPercentual(votacao);
		resultadoPerc.setLocation(250,5);

		// Adicionando as interfaces interessadas na mudan�a do estado do modelo
		enquete.addEnqueteListener(votacao);
		enquete.addEnqueteListener(resultado);
		enquete.addEnqueteListener(resultadoPerc);

		// Povoando o modelo
		enquete.addOpcao("Op��o 1");
		enquete.addOpcao("Op��o 2");
		enquete.addOpcao("Op��o 3");
		enquete.addOpcao("Op��o 4");


		// Exibindo as interfaces
		votacao.show();
		resultado.show();
		resultadoPerc.show();
	}

}
