package servidor;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Administrador;
import objetos.Usuario;

import maganer.ManagerAdministrador;
import maganer.ManagerUsuario;

import solicitudes.IniciarSesion;

public class ServerPrincipal extends JFrame {

	private JPanel contentPane;
	private static String ip = "127.0.0.1";
	private static int port = 5000;


	public static void main(String[] args) {

		ServerPrincipal frame = new ServerPrincipal();
		frame.setVisible(true);
		frame.escucha();

	}

	public ServerPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}


	public void escucha(){


		System.out.println("Esta iniciado el servidor....");

		try {
			ServerSocket sersock = new ServerSocket(port);

			while(true)
			{
				Socket sock = sersock.accept();

				ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
				Object objeto = ois.readObject();

				if (objeto instanceof IniciarSesion){

					IniciarSesion iniciar = (IniciarSesion)objeto;	

					Usuario u=new Usuario();	
					u.nombreUser=iniciar.cliente.nombreUser;
					u.passUser=iniciar.cliente.passUser;			
					ManagerUsuario manager = new ManagerUsuario();
					u=manager.ClienteIdentificar(u);

					if(u!=null){
						RespuestaConexion rc= new RespuestaConexion();
						rc.opcion=1;
						ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream());
						oos.writeObject(rc);
						
					}else{
						Administrador admin= new Administrador();
						admin.nombreAdmin=iniciar.cliente.nombreUser;
						admin.passAdmin=iniciar.cliente.passUser;
						ManagerAdministrador ma= new ManagerAdministrador();
						admin=ma.ClienteIdentificar(admin);
						if(admin!=null){
							RespuestaConexion rc= new RespuestaConexion();
							rc.opcion=2;
							ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream());
							oos.writeObject(rc);
						}
						else{
							RespuestaConexion rc= new RespuestaConexion();
							rc.opcion=3;
							ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream());
							oos.writeObject(rc);
							
						}
					}

					/*ManagerUsuario mu = new ManagerUsuario();
					sc.usuario=mu.ServerIdentificar(sc.usuario);
					ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream());
					oos.writeObject(sc);*/
					
				
	
				}
				
				
				
				


				/*		if(obj instanceof SolicitudTemaNuevo){


					SolicitudTemaNuevo stn=(SolicitudTemaNuevo)obj;
					ManagerTema mt=new ManagerTema();
					//mt.agregarTema(stn.carpeta, stn.titulo);

				}*/

			}		


		} catch (Exception e) {e.printStackTrace();}
	}


	




}
