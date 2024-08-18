package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import arquivos.Arquivo;
import classes.Estetica;
import classes.Paciente;

public class TelaCadastroEstetica extends JFrame{
	private JLabel jlNome, jlTelefone, jlGenero, jlTipoServico, jlTipoAtividade, jlImage;
	private JTextField jtfNome, jtfTelefone;
	private JRadioButton jrbMasculino, jrbFeminino, jrbCaminhada, jrbNadar, jrbAcademia;
	private ButtonGroup botao, botao1;
	private JButton jbAlterar, jbRemover, jbCadastrar, jbAprensentar, jbPesquisar, jbGravar;
	private JTextArea jtaArea;
	private JList jlServicos;
	private JScrollPane jspLista;
	private ImageIcon image;
	private Color cor = new Color(0, 153, 76);	
	private Color cor1 = new Color(150, 250, 150);
	private Font font = new Font("Unispace", Font.BOLD, 15);
	String[] liServicos = {"Drenagem Linfática", "Hidratação de Pés e Mãos", "Limpeza de Pele", "Banho de Lua", "Peeling",
			"Cuidados para o Cabelo", "Massagem Esfoliante Facial e Corporal"};
	List<Paciente> pacientes;

	public TelaCadastroEstetica(String title, List<Paciente> paciente) {
		super(title);
		this.pacientes = paciente;
		iniciarComponente();
		iniciarEventos();
		getContentPane().setBackground(cor);
	}

	private void iniciarComponente() {
		setSize(700, 700);
		setLayout(null);

		image = new ImageIcon(getClass().getResource("/imagem/logo1.png"));
		jlImage = new JLabel(image);

		jlNome = new JLabel("Nome");
		jlTelefone = new JLabel("Telefone");
		jlGenero = new JLabel("Selecione um genêro");
		jlTipoServico = new JLabel("Seleciona o Serviço");
		jlTipoAtividade = new JLabel("Selecione a Atividade");

		jtfNome = new JTextField();
		jtfTelefone = new JTextField();

		jbAlterar = new JButton("Alterar");
		jbRemover = new JButton("Remover");
		jbCadastrar = new JButton("Cadastrar");
		jbAprensentar = new JButton("Atualizar");
		jbPesquisar = new JButton("Pesquisar");
		jbGravar = new JButton("Gravar");

		jrbMasculino = new JRadioButton("Masculino");
		jrbFeminino = new JRadioButton("Feminino");
		jrbCaminhada = new JRadioButton("Caminhar no Bosque");
		jrbNadar = new JRadioButton("Nadar na Piscina");
		jrbAcademia = new JRadioButton("Exercício na Academia");

		jlServicos = new JList(liServicos);
		jlServicos.setBackground(cor1);
		jspLista = new JScrollPane(jlServicos);

		jtaArea = new JTextArea();

		botao = new ButtonGroup();
		botao1 = new ButtonGroup();

		/*Adicionando*/
		add(jlImage);
		add(jlNome);
		add(jlTelefone);
		add(jlGenero);
		add(jlTipoServico);
		add(jlTipoAtividade);

		add(jtfNome);
		jtfNome.setBackground(cor1);
		add(jtfTelefone);
		jtfTelefone.setBackground(cor1);

		add(jbAlterar);
		add(jbRemover);
		add(jbCadastrar);
		add(jbAprensentar);
		add(jbPesquisar);
		add(jbGravar);

		add(jtaArea);		
		jtaArea.setBackground(cor1);
		jtaArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		add(jrbMasculino);
		jrbMasculino.setBackground(cor1);
		add(jrbFeminino);
		jrbFeminino.setBackground(cor1);
		add(jrbCaminhada);
		jrbCaminhada.setBackground(cor1);
		add(jrbNadar);
		jrbNadar.setBackground(cor1);
		add(jrbAcademia);
		jrbAcademia.setBackground(cor1);

		add(jspLista);

		botao.add(jrbMasculino);
		botao.add(jrbFeminino);

		botao1.add(jrbCaminhada);
		botao1.add(jrbNadar);
		botao1.add(jrbAcademia);

		/*Redimensionar*/
		jlImage.setBounds(10, 10, 265, 100);

		jlNome.setBounds(10, 120, 50, 20);
		jtfNome.setBounds(10, 140, 220, 20);

		jlTelefone.setBounds(10, 190, 50, 20);
		jtfTelefone.setBounds(10, 210, 220, 20);

		jlTipoServico.setBounds(10, 250, 150, 20);
		jspLista.setBounds(10, 270, 225, 150);

		jlGenero.setBounds(10, 440, 150, 15);
		jrbMasculino.setBounds(15, 460, 100, 20);
		jrbFeminino.setBounds(15, 480, 100, 20);

		jlTipoAtividade.setBounds(10, 520, 150, 20);
		jrbCaminhada.setBounds(15, 540, 150, 20);
		jrbNadar.setBounds(15, 560, 150, 20);
		jrbAcademia.setBounds(15, 580, 180, 20);

		jbAlterar.setBounds(415, 125, 110, 25);
		jbRemover.setBounds(560, 125, 110, 25);
		jbCadastrar.setBounds(270, 125, 110, 25);
		jbGravar.setBounds(10, 620, 150, 25);

		jbPesquisar.setBounds(340, 90, 110, 25);
		jbAprensentar.setBounds(475, 90, 110, 25);

		jtaArea.setBounds(270, 150, 400, 500);  
	}

	private void iniciarEventos() {

		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String genero = null;
				if(jrbMasculino.isSelected())genero = jrbMasculino.getText();
				if(jrbFeminino.isSelected())genero = jrbFeminino.getText();

				String atividade = null;
				if(jrbCaminhada.isSelected())atividade = jrbCaminhada.getText();
				if(jrbNadar.isSelected())atividade = jrbNadar.getText();
				if(jrbAcademia.isSelected())atividade = jrbAcademia.getText();

				String tipoServico = null;
				if(jlServicos.getSelectedIndex() == 0)tipoServico = "Drenagem Linfática";
				if(jlServicos.getSelectedIndex() == 1)tipoServico = "Hidratação de Pés e Mãos";
				if(jlServicos.getSelectedIndex() == 2)tipoServico = "Limpeza de Pele";
				if(jlServicos.getSelectedIndex() == 3)tipoServico = "Banho de Lua";
				if(jlServicos.getSelectedIndex() == 4)tipoServico = "Peeling";
				if(jlServicos.getSelectedIndex() == 5)tipoServico = "Cuidados para o Cabelo";
				if(jlServicos.getSelectedIndex() == 6)tipoServico = "Massagem Esfoliante Facial e Corporal";

				if(!jtfNome.getText().isEmpty() && !jtfTelefone.getText().isEmpty() && !jlServicos.isSelectionEmpty() && !(genero==null)) {
					try {
						try {
							jtaArea.setText("");

							pacientes.add(new Estetica(jtfNome.getText(), Integer.parseInt(jtfTelefone.getText()), genero, 
									tipoServico, "Estetica", atividade));//Criando novo Cliente

							jtfNome.setText("");//Apagando os campos utilizados anteriormente
							jtfTelefone.setText("");
							jlServicos.clearSelection();
							botao.clearSelection();
							botao1.clearSelection();

						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Entre somente com número no Telefone!",null, JOptionPane.ERROR_MESSAGE);
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
				String atividade = null;
				if(jrbCaminhada.isSelected())atividade = jrbCaminhada.getText();
				if(jrbNadar.isSelected())atividade = jrbNadar.getText();
				if(jrbAcademia.isSelected())atividade = jrbAcademia.getText();

				String tipoServico = null;
				if(jlServicos.getSelectedIndex() == 0)tipoServico = "Drenagem Linfática";
				if(jlServicos.getSelectedIndex() == 1)tipoServico = "Hidratação de Pés e Mãos";
				if(jlServicos.getSelectedIndex() == 2)tipoServico = "Limpeza de Pele";
				if(jlServicos.getSelectedIndex() == 3)tipoServico = "Banho de Lua";
				if(jlServicos.getSelectedIndex() == 4)tipoServico = "Peeling";
				if(jlServicos.getSelectedIndex() == 5)tipoServico = "Cuidados para o Cabelo";
				if(jlServicos.getSelectedIndex() == 6)tipoServico = "Massagem Esfoliante Facial e Corporal";

				try {
					if(!pacientes.isEmpty()) {	
						for (Paciente paciente2 : pacientes) {
							if(paciente2 instanceof Estetica) {
								if(!(atividade == null) && !jlServicos.isSelectionEmpty()) {//Validando
									if(paciente2.getNome().equals(jtfNome.getText())) { //Apaga somente o nome escrito no jtfNome
										((Estetica) paciente2).setTipoServico(atividade);//Setando a mudança do Serviço
										paciente2.setTipoAtividade(tipoServico);//Setando a mudança da Atividade
										jtaArea.setText("");
										jtfNome.setText("");//Apagando os campos utilizados anteriormente
										jtfTelefone.setText("");
										jlServicos.clearSelection();
										botao.clearSelection();
										botao1.clearSelection();
										int indice = 1;
										jtaArea.append("\n*************************\n"+indice+"° Paciente"+paciente2.mostrarDadosCadastro());
										indice++;
									}
								}else {
									JOptionPane.showMessageDialog(null, "Selecione todos os campos da Atividade e Serviço!");
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

		jbRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!pacientes.isEmpty()) {  //Validação dos Campos
						for (Paciente paciente2 : pacientes) {
							if(paciente2 instanceof Estetica) {
								if(paciente2.getNome().equals(jtfNome.getText())) { //Apaga somente o nome escrito no jtfNome
									pacientes.remove((paciente2));
									jtaArea.setText("");
								}
							}
							for (Paciente paciente1 : pacientes) {
								int indice = 1;
								jtaArea.append("\n*************************\n"+indice+"° Paciente"+paciente1.mostrarDadosCadastro());
								indice++;
							}
						}
					} else {

						JOptionPane.showMessageDialog(null, "Não tem pacientes!",
								null, JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Paciente Removido!");
				}
			}
		});

		jbAprensentar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pacientes.isEmpty()) {
					jtaArea.setText("");
					int indice = 1;
					for (Paciente paciente2 : pacientes) {
						if(paciente2 instanceof Estetica) {
							jtaArea.append("\n*************************\n"+indice+"° Paciente"+paciente2.mostrarDadosCadastro());
							indice++;
							jtfNome.setText("");//Apagando os campos utilizados anteriormente
							jtfTelefone.setText("");
							jlServicos.clearSelection();
							botao.clearSelection();
							botao1.clearSelection();
						}
					}
				} else {

					JOptionPane.showMessageDialog(null, "Não tem pacientes!",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		jbPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtaArea.setText("");
				if(!pacientes.isEmpty()) {
					for (Paciente paciente2 : pacientes) {
						if(paciente2 instanceof Estetica) {
							if(paciente2.getNome().equals(jtfNome.getText())) {//Aqui ele pesquisa o Paciente que estiver descrito no jtfNome
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

