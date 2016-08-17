package br.ufscar.systemExampleMVC_SimplesComDesvio.controller;

import br.ufscar.systemExampleMVC_SimplesComDesvio.model.BancoDeDadosPessoa;
import br.ufscar.systemExampleMVC_SimplesComDesvio.model.Pessoa;

public class ControllerPessoa {

	public static void cadastrarUmaPessoa(String nome, String idade, String profissao) {
		Pessoa pessoaPraCadastrar = new Pessoa(nome, idade, profissao);
		
		BancoDeDadosPessoa.cadastrarPessoa(pessoaPraCadastrar);
		
	}

	public static String visualizaPessoas() {
		String pessoasVisualizadas = "";
		
		for (Pessoa pessoa : BancoDeDadosPessoa.getPessoas()) {
			pessoasVisualizadas = pessoasVisualizadas.concat(pessoa.toString());
		}
		
		
		return pessoasVisualizadas;
	}

	
	
}
