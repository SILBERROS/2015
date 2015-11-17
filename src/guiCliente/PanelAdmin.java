package guiCliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JTextField txtNameAdmin;
	private JTextField txtPassAdmin;
	private JTextField txtUsuario;
	private JButton btnBorrarUsuario;
	private JButton btnBorrarAdmin;
	private JButton btnCrearAdmin;

	
	public PanelAdmin() {
		setLayout(null);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdministrador.setBounds(104, 11, 108, 14);
		add(lblAdministrador);
		
		JLabel lblUsuarioAdmin = new JLabel("Editar Usuarios tipo Administrador");
		lblUsuarioAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUsuarioAdmin.setBounds(20, 45, 205, 14);
		add(lblUsuarioAdmin);
		
		lblUsuario = new JLabel("Editar Usuarios");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblUsuario.setBounds(20, 135, 205, 14);
		add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 73, 46, 14);
		add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(41, 96, 67, 14);
		add(lblContrasea);
		
		txtNameAdmin = new JTextField();
		txtNameAdmin.setBounds(115, 70, 86, 20);
		add(txtNameAdmin);
		txtNameAdmin.setColumns(10);
		
		txtPassAdmin = new JTextField();
		txtPassAdmin.setBounds(115, 93, 86, 20);
		add(txtPassAdmin);
		txtPassAdmin.setColumns(10);
		
		btnCrearAdmin = new JButton("Crear");
		btnCrearAdmin.setBounds(225, 69, 89, 23);
		add(btnCrearAdmin);
		
		btnBorrarAdmin = new JButton("Borrar");
		btnBorrarAdmin.setBounds(225, 92, 89, 23);
		add(btnBorrarAdmin);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(41, 163, 46, 14);
		add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(115, 160, 86, 20);
		add(txtUsuario);
		
		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(225, 160, 89, 23);
		add(btnBorrarUsuario);

	}
}
