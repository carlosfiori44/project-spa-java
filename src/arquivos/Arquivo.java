package arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Paciente;

public class Arquivo {
	private String nomeArquivo;

	public Arquivo(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	public void escreverArquivo(List<Paciente> pacientes) {
		FileOutputStream fluxo;

		try {
			fluxo = new FileOutputStream(nomeArquivo);
			ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
			objeto.writeObject(pacientes);
			objeto.close();
			JOptionPane.showMessageDialog(null,"Arquivo Gravado com sucesso!");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Arquivo Inexistente !");
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Arquivo Corrompido !");
		}

	}

	public List<Paciente> lerArquivo(List<Paciente> paciente){

		try {
			FileInputStream fluxo = new FileInputStream(nomeArquivo);
			ObjectInputStream objeto = new ObjectInputStream(fluxo);
			paciente = (List<Paciente>) objeto.readObject();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Arquivo Inexistente !");
			JOptionPane.showMessageDialog(null,"Criando Arquivo....");
			escreverArquivo(paciente);// CRIA O ARQUIVO

		}catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Arquivo Corrompido !");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Classe Inexistente !");
		}


		return paciente;

	}
}
