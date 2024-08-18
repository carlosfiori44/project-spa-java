package classes;

import interfaces.Atividades;

public class Emagrecimento extends Paciente implements Atividades{
	private float pesoIdeal, porcentagemPeso, altura, peso;

	public Emagrecimento(String nome, int telefone, String genero, String tipoAtividade, String tipoTratamento,
			float altura, float peso) {
		super(nome, telefone, genero, tipoAtividade, tipoTratamento);
		this.altura = altura;
		this.peso = peso;
		this.pesoIdeal = Calculo.pesoIdeal(this.altura, this.genero);
	}


	@Override
	public String mostrarDadosCadastro() {//Mostra os dados do Paciente de Emagrecimento
		// TODO Auto-generated method stub
		return super.mostrarDadosCadastro()+"\nPeso Atual: "+peso+"\nPeso Ideal: "+pesoIdeal;
	}

	@Override
	public String passearBosque() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exercitarNaAcademia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nadarPiscina() {
		// TODO Auto-generated method stub
		return null;
	}
	//Getters e Setters
	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public float getPesoIdeal() {
		return pesoIdeal;
	}
}
