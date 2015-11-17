package guiCliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import maganer.ManagerEjercicio;
import maganer.ManagerUsuario;

import objetos.Administrador;
import objetos.Cliente;
import objetos.Usuario;
import servidor.RespuestaConexion;
import solicitudes.IniciarSesion;
import cliente.ClientePrincipal;

public class PanelLogin extends JPanel {

	private JTextField txtNameLogin;
	private JTextField txtPassLogin;
	private JLabel lblNombreLogin;
	private JLabel lblPassLogin;
	private JButton btnIniciarSesion;
	private JLabel lblBienvenidoACodebok;

	private JButton btnUsuarioNuevo;
	private ClientePrincipal cp;
	private static String ip = "127.0.0.1";
	private static int port = 5000;
	private JLabel lblError;


	public PanelLogin() {
		setLayout(null);

		lblNombreLogin = new JLabel("Nombre:");
		lblNombreLogin.setBounds(109, 61, 60, 14);
		lblNombreLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblNombreLogin);

		txtNameLogin = new JTextField();
		txtNameLogin.setBounds(109, 76, 148, 23);
		add(txtNameLogin);
		txtNameLogin.setColumns(10);

		lblPassLogin = new JLabel("Contrase\u00F1a:");
		lblPassLogin.setBounds(109, 110, 77, 14);
		lblPassLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPassLogin);

		txtPassLogin = new JTextField();
		txtPassLogin.setBounds(110, 126, 148, 23);
		add(txtPassLogin);
		txtPassLogin.setColumns(10);


		lblBienvenidoACodebok = new JLabel("Bienvenido a Code Book");
		lblBienvenidoACodebok.setBounds(10, 0, 259, 35);
		lblBienvenidoACodebok.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidoACodebok.setForeground(new Color(0, 100, 0));
		add(lblBienvenidoACodebok);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(20, 46, 46, 14);
		add(lblLogin);

		lblError = new JLabel("");
		lblError.setVisible(false);
		lblError.setBounds(10, 247, 351, 29);
		add(lblError);


		btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.setBounds(109, 171, 148, 23);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Socket sock = new Socket(ip,port);
					ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());					
					IniciarSesion is = new IniciarSesion();

					Cliente cli=new Cliente();					
					cli.nombreUser.setTexto(txtNameLogin.getText());
					cli.passUser.setTexto(txtPassLogin.getText());
					is.cliente=cli;
					oos.writeObject(is);

					ObjectInputStream ois=new ObjectInputStream(sock.getInputStream());
					Object objeto=ois.readObject();
					if(objeto instanceof RespuestaConexion){
						RespuestaConexion respuesta=(RespuestaConexion)objeto;
						if(respuesta.opcion==1){
							Usuario u= new Usuario();
							u.nombreUser=cli.nombreUser;
							u.passUser=cli.passUser;							
							cp.logIn(u);
						}
						if(respuesta.opcion==2){
							Administrador admin =new Administrador();
							admin.nombreAdmin=cli.nombreUser;
							admin.passAdmin=cli.passUser;
							cp.logInAdmin(admin);

						}
						if(respuesta.opcion==3){
							txtNameLogin.setText("");
							txtPassLogin.setText("");
							lblError.setVisible(true);
							lblError.setText("Error, vuelva a loguarse,los datos ingresados no existen");

						}


					}


					/*
					 * 
					 * 
					 * 
					 * 
					 * *//*
					ObjectInputStream ois=new ObjectInputStream(sock.getInputStream());
					Object objeto=ois.readObject();
					is=(IniciarSesion)objeto;

					Usuario u=new Usuario();					
					u.nombreUser.setTexto(txtNameLogin.getText());
					u.passUser.setTexto(txtPassLogin.getText());

					ManagerUsuario manager = new ManagerUsuario();
					u=manager.ClienteIdentificar(u);

					if(u!=null){
						cp.logIn(u);
					}else{
						cp.logOut();
						lblInfo.setText("Incorrecto!!");
					}

					  */

					/*	Administrador a=new Administrador();					
					a.nombreAdmin.setTexto(txtNameLogin.getText());
					a.passAdmin.setTexto(txtPassLogin.getText());

					ManagerAdministrador ma = new ManagerAdministrador();
					a=ma.ClienteIdentificar(a);

					if(a!=null){
						cp.logInAdmin(a);
					}else{

						cp.logOut();
						lblInfo.setText("Incorrecto!!");
					}*/










					//		*****
					oos.close();
					sock.close();





				}catch (Exception e1){e1.printStackTrace();}








			}
		});
		add(btnIniciarSesion);

		btnUsuarioNuevo = new JButton("Usuario Nuevo");
		btnUsuarioNuevo.setBounds(109, 199, 148, 23);
		btnUsuarioNuevo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				/*Pendiente!
				 * 
				ManagerUsuario mu= new 	ManagerUsuario();

				try {

					Socket sock = new Socket(ip,port);
					ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());					
					IniciarSesion is = new IniciarSesion();

					Cliente cli=new Cliente();					
					cli.nombreUser.setTexto(txtNameLogin.getText());
					cli.passUser.setTexto(txtPassLogin.getText());
					is.cliente=cli;
					oos.writeObject(is);

					ObjectInputStream ois=new ObjectInputStream(sock.getInputStream());
					Object objeto=ois.readObject();
					if(objeto instanceof RespuestaConexion){
						RespuestaConexion respuesta=(RespuestaConexion)objeto;
						if(respuesta.opcion==1){
							Usuario u= new Usuario();
							u.nombreUser=cli.nombreUser;
							u.passUser=cli.passUser;							
							cp.logIn(u);
						}
						if(respuesta.opcion==2){
							Administrador admin =new Administrador();
							admin.nombreAdmin=cli.nombreUser;
							admin.passAdmin=cli.passUser;
							cp.logInAdmin(admin);

						}
						if(respuesta.opcion==3){
							txtNameLogin.setText("");
							txtPassLogin.setText("");
							lblError.setVisible(true);
							lblError.setText("Error, vuelva a loguarse,los datos ingresados no existen");

						}
					}
				}catch (Exception e1){e1.printStackTrace();}*/

			}



		});
		add(btnUsuarioNuevo);

	}

	public PanelLogin(ClientePrincipal cp){
		this();
		this.cp=cp;
	}
}
