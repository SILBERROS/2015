package test;


import guiCliente.PanelLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

public class TestLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Usuario usuario=null;

	public static void main(String[] args) {

		TestLogin frame = new TestLogin();
		frame.setVisible(true);

	}

	public TestLogin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelLogin panelLogin = new PanelLogin();
		panelLogin.setBounds(0, 0, 442, 273);
		contentPane.add(panelLogin);

		

	}
	public static Usuario getUsuario() {
		return usuario;
	}
	public static void setUsuario(Usuario usuario) {
		TestLogin.usuario = usuario;
	}
}
