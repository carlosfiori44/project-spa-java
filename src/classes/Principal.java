package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import telas.TelaPrincipal;


public class Principal extends JFrame{
	private JTextField jtfLogin;
	private JLabel jlLogin, jlSenha, jlImage;
	private static Principal frame;
	private JPasswordField jpfSenha;
	private JButton jbLogar, jbCancelar;
	private ImageIcon image;
	private Color cor = new Color(0, 153, 76);
	Font font = new Font("Unispace", Font.BOLD, 13);

	public Principal() {
		iniciarComponentes();
		iniciarEventos();
	}

	private void iniciarComponentes() {
		setTitle("Login de Sistema");
		setSize(450, 220);
		setLayout(null);
		getContentPane().setBackground(cor);

		image = new ImageIcon(getClass().getResource("/imagem/logo.png"));
		jlImage = new JLabel(image);

		jlLogin = new JLabel("Login");
		jlLogin.setFont(font);
		jtfLogin = new JTextField(5);

		jlSenha = new JLabel("Senha");
		jlSenha.setFont(font);
		jpfSenha = new JPasswordField(5);

		jbLogar = new JButton("Iniciar sessão");
		jbCancelar = new JButton("Sair");

		add(jlImage);

		add(jlLogin);
		add(jtfLogin);

		add(jlSenha);
		add(jpfSenha);

		add(jbLogar);
		add(jbCancelar);

		jlImage.setBounds(250, 20, 190, 100);

		jlLogin.setBounds(20, 10, 80, 25);
		jtfLogin.setBounds(20, 30, 200, 25);

		jlSenha.setBounds(20, 65, 80, 20);
		jpfSenha.setBounds(20, 85, 200, 25);

		jbLogar.setBounds(20, 130, 115, 25);
		jbCancelar.setBounds(145, 130, 75, 25);
	}

	private void iniciarEventos() {
		// TODO Auto-generated method stub
		jbLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(jpfSenha.getPassword());
				if (jtfLogin.getText().equals("") && senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Logado!");
					frame.setVisible(false);
					TelaPrincipal.abrir();
				}else JOptionPane.showMessageDialog(null, "Senha ou Login Errado!");
			}
		});

		jbCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame = new Principal();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation((tela.width - (frame).getSize().width)/2,
						(tela.height - frame.getSize().height)/2); 
				frame.setVisible(true);
			}
		});
	}
}
