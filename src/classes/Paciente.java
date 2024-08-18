package classes;

import java.io.Serializable;

public abstract class Paciente implements Serializable {
	protected String nome, genero, tipoAtividade, tipoTratamento;
	protected int telefone;

	public Paciente(String nome, int telefone, String genero, String tipoAtividade, String tipoTratamento) {//Construtor
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.genero = genero;
		this.tipoAtividade = tipoAtividade;
		this.tipoTratamento = tipoTratamento;
	}
	//Mostra os dados do Paciente
	public String mostrarDadosCadastro() {
		return "\t"+tipoTratamento+" - "+tipoAtividade+"\nNome: "+nome+"\nGênero: "+genero+"\nTelefone: "+telefone;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public float getTelefone() {
		return telefone;
	}

	public String getGenero() {
		return genero;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public String getTipoTratamento() {
		return tipoTratamento;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

}
