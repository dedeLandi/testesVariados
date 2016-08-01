package br.ufscar.systemExample_Enquete.controller;

/*
 * Historico:
 *    24/03/2003: rodrigor - Cria��o da classe
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufscar.systemExample_Enquete.model.EnqueteSimples;

/**
 * Controlador da Interface "TelaVotacao". Esta classe recebe os
 * eventos gerados pela interface e repassa para o modelo do neg�cio,
 * alterando o estado da enquete.
 *
 * @see enquete.view.TelaVotacao
 *
 * @author <a href="mailto:rodrigor@dsc.ufcg.edu.br">Rodrigo Rebou�as de Almeida</a>
 * @since 24/03/2003
 **/
public class TelaVotacaoCtrl implements ActionListener{

	private EnqueteSimples enquete;

	public TelaVotacaoCtrl(EnqueteSimples enquete){
		this.enquete = enquete;
	}

	/**
	 * Evento lan�ado pelo clique nos botoes da TelaVotacao
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		enquete.votar(event.getActionCommand());
	}

}
