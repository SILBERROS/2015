package cliente;

//import guiCliente.PanelCrearCuenta;
import guiCliente.PanelAdmin;
import guiCliente.PanelCrearCuenta;
import guiCliente.PanelLenguajesAdmin;
import guiCliente.PanelLenguajesUsuario;
import guiCliente.PanelLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Administrador;
import objetos.Usuario;

public class ClientePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelCrearCuenta panelCrearCuenta;
	private Usuario usuario=null;
	private Administrador admin=null;
	private JPanel tbpJava;
	private JPanel tbp;
	private static String ip = "127.0.0.1";
	private static int port = 5000;
	private PanelLenguajesAdmin panelLenguajesAdmin;
	private PanelLogin panelLogin;
	private PanelLenguajesUsuario panelLenguajesUsuario;
	

	public static void main(String[] args) {

		ClientePrincipal frame = new ClientePrincipal();
		frame.setVisible(true);

	}

	public ClientePrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 534);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelLogin = new PanelLogin(this);
		panelLogin.setBounds(10, 11, 448, 472);
		contentPane.add(panelLogin);

		panelLenguajesAdmin = new PanelLenguajesAdmin(this);
		panelLenguajesAdmin.setBounds(10, 11, 439, 458);
		contentPane.add(panelLenguajesAdmin);

		panelLenguajesUsuario = new PanelLenguajesUsuario(this);
		panelLenguajesUsuario.setBounds(10, 11, 414, 303);
		contentPane.add(panelLenguajesUsuario);

		 panelCrearCuenta= new PanelCrearCuenta(this);
		 panelCrearCuenta.setBounds(10, 11, 414, 303);
		contentPane.add( panelCrearCuenta);

		logOutUsuario();
		logOutAdmin();
	}


	//usuario

	public Usuario getUsuario() {
		return usuario;

	}
	public void logIn(Usuario u){

		panelLogin.setVisible(false);
		panelLenguajesAdmin.setVisible(false);
		panelLenguajesUsuario.setVisible(true);

		usuario=u;
	}

	public void logOutUsuario(){

		panelLenguajesAdmin.setVisible(false);
		panelLenguajesUsuario.setVisible(false);
		panelLogin.setVisible(true);

		this.usuario=null;
	}



	//admin

	public Administrador getAdministrador() {
		return admin;
	}
	public void logInAdmin(Administrador a){

		panelLogin.setVisible(false);	
		panelLenguajesUsuario.setVisible(false);
		panelLenguajesAdmin.setVisible(true);

		admin=a;
	}

	public void logOutAdmin(){

		panelLenguajesAdmin.setVisible(false);
		panelLenguajesUsuario.setVisible(false);
		panelLogin.setVisible(true);

		this.admin=null;
	}
}


