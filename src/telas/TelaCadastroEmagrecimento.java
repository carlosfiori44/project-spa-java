package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import arquivos.Arquivo;
import classes.Calculo;
import classes.Emagrecimento;
import classes.Paciente;

public class TelaCadastroEmagrecimento extends JFrame {
	//Criando os atributos
	private JLabel jlNome, jlTelefone, jlGenero, jlTipoAtividade, jlAltura, jlPeso, jlImage;
	private JTextField jtfNome, jtfTelefone, jtfAltura, jtfPeso;
	private JRadioButton jrbMasculino, jrbFeminino;
	private ButtonGroup botao;
	private JButton jbAlterar, jbRemover, jbCadastrar, jbAprensentar, jbEvolucao, jbPesquisar, jbGravar;
	private JTextArea jtaArea;
	private JList jlServicos;
	private JScrollPane jspLista;
	private ImageIcon image;
	private Color cor = new Color(0, 153, 76);
	private Color cor1 = new Color(150, 250, 150);
	private String[] liServicos = {"Caminhada no Bosque", "Nadar na Piscina", "Exercício na Academia"};
	List<Paciente> pacientes;

	public TelaCadastroEmagrecimento(String title, List<Paciente> paciente) {//Construtor
		super(title);
		this.pacientes = paciente;
		iniciarComponente();
		iniciarEventos();
		getContentPane().setBackground(cor);
	}

	private void iniciarComponente() {//Iniciando os componentes da tela
		setSize(700, 700);
		setLayout(null);

		image = new ImageIcon(getClass().getResource("/imagem/logo1.png"));
		jlImage = new JLabel(image);

		jlNome = new JLabel("Nome");
		jlTelefone = new JLabel("Telefone");
		jlGenero = new JLabel("Selecione um genêro");
		jlTipoAtividade = new JLabel("Seleciona a atividade");
		jlAltura = new JLabel("Altura");
		jlPeso = new JLabel("Peso");

		jtfNome = new JTextField();
		jtfTelefone = new JTextField();
		jtfAltura = new JTextField();
		jtfPeso= new JTextField();

		jbAlterar = new JButton("Alterar");
		jbRemover = new JButton("Remover");
		jbCadastrar = new JButton("Cadastrar");
		jbAprensentar = new JButton("Atualizar");
		jbEvolucao = new JButton("Porcentagem");
		jbPesquisar = new JButton("Pesquisar");
		jbGravar = new JButton("Gravar");

		jrbMasculino = new JRadioButton("Masculino");
		jrbFeminino = new JRadioButton("Feminino");

		jlServicos = new JList(liServicos);
		jlServicos.setBackground(cor1);
		jspLista = new JScrollPane(jlServicos);

		jtaArea = new JTextArea();

		botao = new ButtonGroup();

		/*Adicionando na tela*/
		add(jlImage);
		add(jlNome);
		add(jlTelefone);
		add(jlGenero);
		add(jlTipoAtividade);
		add(jlAltura);
		add(jlPeso);

		add(jtfNome);
		jtfNome.setBackground(cor1);
		add(jtfTelefone);
		jtfTelefone.setBackground(cor1);
		add(jtfAltura);
		jtfAltura.setBackground(cor1);
		add(jtfPeso);
		jtfPeso.setBackground(cor1);

		add(jbAlterar);
		add(jbRemover);
		add(jbCadastrar);
		add(jbAprensentar);
		add(jbEvolucao);
		add(jbPesquisar);
		add(jbGravar);

		add(jtaArea);
		jtaArea.setBackground(cor1);
		jtaArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		add(jrbMasculino);
		jrbMasculino.setBackground(cor1);
		add(jrbFeminino);
		jrbFeminino.setBackground(cor1);

		add(jspLista);

		botao.add(jrbMasculino);
		botao.add(jrbFeminino);

		/*Redimensionando os itens*/
		jlImage.setBounds(10, 10, 265, 100);

		jlNome.setBounds(10, 150, 50, 20);
		jtfNome.setBounds(10, 170, 150, 20);

		jlAltura.setBounds(160, 150, 50, 20);
		jtfAltura.setBounds(160, 170, 50, 20);

		jlPeso.setBounds(210, 150, 50, 20);
		jtfPeso.setBounds(210, 170, 50, 20);

		jlTelefone.setBounds(10, 200, 50, 20);
		jtfTelefone.setBounds(10, 220, 220, 20);

		jlTipoAtividade.setBounds(10, 250, 150, 20);
		jspLista.setBounds(10, 270, 225, 150);

		jlGenero.setBounds(10, 440, 150, 15);
		jrbMasculino.setBounds(15, 460, 100, 20);
		jrbFeminino.setBounds(15, 480, 100, 20);

		jbAlterar.setBounds(415, 125, 110, 25);
		jbRemover.setBounds(560, 125, 110, 25);
		jbCadastrar.setBounds(270, 125, 110, 25);

		jbPesquisar.setBounds(405, 55, 110, 25);
		jbAprensentar.setBounds(475, 90, 120, 25);
		jbEvolucao.setBounds(340, 90, 120, 25);
		jbGravar.setBounds(10, 620, 150, 25);

		jtaArea.setBounds(270, 150, 400, 500);  
	}

	private void iniciarEventos() { //Criando os eventos dos Botões

		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = null;
				if(jrbMasculino.isSelected())genero = jrbMasculino.getText();
				if(jrbFeminino.isSelected())genero = jrbFeminino.getText();

				String tipoAtividade = null;
				if(jlServicos.getSelectedIndex() == 0)tipoAtividade = "Caminhada no Bosque";
				if(jlServicos.getSelectedIndex() == 1)tipoAtividade = "Nadar na Piscina";
				if(jlServicos.getSelectedIndex() == 2)tipoAtividade = "Exercício na Academia";

				if(!jtfPeso.getText().isEmpty() && !jtfNome.getText().isEmpty() && !jtfTelefone.getText().isEmpty() && !jtfPeso.getText().isEmpty()
						&& !jlServicos.isSelectionEmpty() && !(genero==null)) {
					try {
						try {
							jtaArea.setText("");

							pacientes.add(new Emagrecimento(jtfNome.getText(), Integer.parseInt(jtfTelefone.getText()), genero, tipoAtividade, "Emagrecimento",
									Float.parseFloat(jtfAltura.getText()), Float.parseFloat(jtfPeso.getText())));

							jtfAltura.setText("");
							jtfNome.setText("");
							jtfPeso.setText("");
							jtfTelefone.setText("");	
							jlServicos.clearSelection();
							botao.clearSelection();

						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Entre somente com número na Altura, Peso e Telefone!",null, JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os Campos!");
				}
			}
		});

		jbAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tipoAtividade = null;
				if(jlServicos.getSelectedIndex() == 0)tipoAtividade = "Caminhada no Bosque";
				if(jlServicos.getSelectedIndex() == 1)tipoAtividade = "Nadar na Piscina";
				if(jlServicos.getSelectedIndex() == 2)tipoAtividade = "Exercício na Academia";

				try {
					if(!pacientes.isEmpty()) {	
						for (Paciente paciente2 : pacientes) {
							if(paciente2 instanceof Emagrecimento) {
								if(!jlServicos.isSelectionEmpty() && !(jtfPeso.getText()==null)) {//Validando
									if(paciente2.getNome().equals(jtfNome.getText())) { //Apaga somente o nome escrito no jtfNome
										((Emagrecimento) paciente2).setPeso(Float.parseFloat(jtfPeso.getText()));
										paciente2.setTipoAtividade(tipoAtividade);//Setando a mudança da Atividade
										jtaArea.setText("");
										jtfNome.setText("");//Apagando os campos utilizados anteriormente
										jtfTelefone.setText("");
										jlServicos.clearSelection();
										botao.clearSelection();
										jtfPeso.setText("");
										int indice = 1;
										jtaArea.append("\n*************************\n"+indice+"° Paciente"+paciente2.mostrarDadosCadastro());
										indice++;
									}
								} else {
									JOptionPane.showMessageDialog(null, "Selecione todos os campos do Peso e Serviço!");
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Não tem pacientes!", null, JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Mudanças feitas!");
				}
			}
		});

		jbAprensentar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {//Mostra todos os pacientes cadastrados
				//if(!pacientes.isEmpty()) {//Se a lista estiver vazia
				jtaArea.setText("");
				int indice = 1;
				for (Paciente paciente2 : pacientes) {
					if(paciente2 instanceof Emagrecimento) {
						jtaArea.append("\n*************************\n"+indice+"° Paciente"+paciente2.mostrarDadosCadastro());
						indice++;
						jtfAltura.setText("");
						jtfNome.setText("");
						jtfPeso.setText("");
						jtfTelefone.setText("");	
						jlServicos.clearSelection();
						botao.clearSelection();
						jtfPeso.setText("");
					} 
				}
				//}else {
				//	JOptionPane.showMessageDialog(null, "Não tem pacientes!", null, JOptionPane.ERROR_MESSAGE);
				//}
			}
		});

		jbEvolucao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pacientes.isEmpty()) {//Validação
					try {
						for (Paciente paciente2 : pacientes) {
							if(paciente2 instanceof Emagrecimento) {
								if(paciente2.getNome().equals(jtfNome.getText())) { //Vai calcular a porcentagem do peso ideal
									jtaArea.setText("");
									jtaArea.append("Porcentagem do Peso Ideal: "+Float.toString(Calculo.porcentagemDoPesoIdeal(
											((Emagrecimento) paciente2).getPesoIdeal(), 
											((Emagrecimento) paciente2).getPeso()))+"%");
								}
							}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Paciente Inexistente!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não tem pacientes!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		jbRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!pacientes.isEmpty()) {  //Validação dos Campos
						for (Paciente paciente2 : pacientes) {
							if(paciente2 instanceof Emagrecimento) {
								if(paciente2.getNome().equals(jtfNome.getText())) { //Apaga somente o nome escrito no jtfNome
									pacientes.remove(paciente2);
									jtaArea.setText("");
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Não tem pacientes!",
								null, JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Paciente Removido!");
				}
			}
		});

		jbPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtaArea.setText("");
				if(!pacientes.isEmpty()) {
					for (Paciente paciente2 : pacientes) {
						if(paciente2 instanceof Emagrecimento) {
							if(paciente2.getNome().equals(jtfNome.getText())) {
								jtaArea.append("\n*************************\n"+paciente2.mostrarDadosCadastro());

							}
						}
					}
				} else {

					JOptionPane.showMessageDialog(null, "Não tem pacientes!",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		jbGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Arquivo arquivo = new Arquivo("Spa.bin");
				arquivo.escreverArquivo(pacientes);
			}
		});
	}
}
