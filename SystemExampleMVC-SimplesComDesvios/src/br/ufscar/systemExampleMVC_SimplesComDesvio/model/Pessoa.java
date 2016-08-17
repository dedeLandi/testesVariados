package br.ufscar.systemExampleMVC_SimplesComDesvio.model;

public class Pessoa {

	private static int id;
	private String nome;
	private String idade;
	private String profissao;
	
	
	public Pessoa() {
	}


	public Pessoa(String nome, String idade, String profissao) {
		super();
		Pessoa.id++;
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
	}

	
	public void cadastrarDesvio() {
		System.out.println("Cadastrou um desvio aqui.");
		System.out.println(toString());
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getProfissao() {
		return profissao;
	}


	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@Override
	public String toString() {
		String toString = "";
		
		toString = toString.concat("\nID: " + id);
		toString = toString.concat("\nNome: " + nome);
		toString = toString.concat("\nIdade: " + idade);
		toString = toString.concat("\nProfissão: " + profissao);
		toString = toString.concat("\n");
		
		
		return toString;
	}
	
}
