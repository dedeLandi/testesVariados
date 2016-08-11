package br.ufscar.systemExampleMVC_Simples.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosPessoa {

	private static List<Pessoa> pessoasCadastradas = new ArrayList<Pessoa>();
	
	public static void cadastrarPessoa(Pessoa pessoa){
		pessoasCadastradas.add(pessoa);
	}
	
	public static List<Pessoa> getPessoas(){
		return pessoasCadastradas;
	}
	
}
