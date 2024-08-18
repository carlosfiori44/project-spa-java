package classes;

import interfaces.Atividades;

public class Estetica extends Paciente implements Atividades {
	public String tipoServico;


	public Estetica(String nome, int telefone, String genero, String tipoAtividade, String tipoTratamento, String tipoServico) {
		super(nome, telefone, genero, tipoAtividade, tipoTratamento);
		this.tipoServico = tipoServico;
	}

	@Override
	public String mostrarDadosCadastro() {//Mostra os dados do Paciente de Estética
		// TODO Auto-generated method stub
		return super.mostrarDadosCadastro()+"\nAtividade: "+tipoServico;
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

	//Setter
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	

}
