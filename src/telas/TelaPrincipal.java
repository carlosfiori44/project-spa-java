package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import arquivos.Arquivo;
import classes.Paciente;

public class TelaPrincipal extends JFrame {
	private static TelaPrincipal frame;
	private JLabel jlImage;
	private JButton jbSair, jbGravar, jbCadastrarEstetica, jbCadastrarEmagrecimento;
	private ImageIcon image;
	private Color cor = new Color(0, 153, 76);
	List<Paciente> paciente = new ArrayList<Paciente>();
	Arquivo arquivo = new Arquivo("Spa.bin");

	public TelaPrincipal(String title) {
		super(title);
		paciente = arquivo.lerArquivo(paciente);
		iniciarComponente();
		iniciarEventos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(cor);
	}

	private void iniciarComponente() {
		// TODO Auto-generated method stub
		setSize(537, 300);
		setLayout(null);

		/**Criar objeto**/		
		image = new ImageIcon(getClass().getResource("/imagem/logo1.png"));
		jlImage = new JLabel(image);

		jbSair = new JButton("Sair");
		jbGravar = new JButton("Gravar");
		jbCadastrarEmagrecimento = new JButton("Cadastrar Emagrecimento");
		jbCadastrarEstetica = new JButton("Cadastrar Estetica");

		/**adicionar o componete na tela**/
		add(jbSair);
		add(jbGravar);
		add(jbCadastrarEmagrecimento);
		add(jbCadastrarEstetica);

		add(jlImage);

		/**dimensionamento do componete**/
		jbSair.setBounds(40, 200, 150, 30);
		jbGravar.setBounds(320, 200, 150, 30);
		jbCadastrarEmagrecimento.setBounds(20, 120, 200, 50);
		jbCadastrarEstetica.setBounds(300, 120, 200, 50);

		jlImage.setBounds(55, -30, 400, 200);
	}

	private void iniciarEventos() {

		jbGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Arquivo arquivo = new Arquivo("Spa.bin");
				arquivo.escreverArquivo(paciente);
			}
		});

		jbSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});

		jbCadastrarEmagrecimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEmagrecimento frameEmagrecimento = new TelaCadastroEmagrecimento("SPA", paciente);
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				frameEmagrecimento.setLocation((tela.width - frameEmagrecimento.getSize().width)/2,
						(tela.height - frameEmagrecimento.getSize().height)/2);
				frameEmagrecimento.setVisible(true);
			}
		});

		jbCadastrarEstetica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEstetica frameEstetica = new TelaCadastroEstetica("SPA", paciente);
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				frameEstetica.setLocation((tela.width - frameEstetica.getSize().width)/2,
						(tela.height - frameEstetica.getSize().height)/2);
				frameEstetica.setVisible(true);
			}
		});
	}

	public static void abrir() {
		frame = new TelaPrincipal("SPA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,
				(tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
	}

}
