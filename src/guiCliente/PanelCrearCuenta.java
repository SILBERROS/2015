package guiCliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import cliente.ClientePrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCrearCuenta extends JPanel {

	private JTextField txtNombreCuenta;
	private JTextField txtPassCuenta;
	private JButton btnCrearCuenta;
	private JLabel lblCrearCuenta;
	private JLabel lblNombreCuenta;
	private JLabel lblPassCuenta;
	private ClientePrincipal cp;

	public PanelCrearCuenta() {
		setLayout(null);

		lblCrearCuenta = new JLabel("Cuenta Nueva");
		lblCrearCuenta.setBounds(10, 11, 164, 20);
		lblCrearCuenta.setForeground(new Color(0, 100, 0));
		lblCrearCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblCrearCuenta);

		txtNombreCuenta = new JTextField();
		txtNombreCuenta.setColumns(10);
		txtNombreCuenta.setBounds(42, 87, 132, 20);
		add(txtNombreCuenta);

		txtPassCuenta = new JTextField();
		txtPassCuenta.setColumns(10);
		txtPassCuenta.setBounds(42, 155, 132, 20);
		add(txtPassCuenta);

		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {






			}
		});
		btnCrearCuenta.setBounds(42, 196, 123, 20);
		add(btnCrearCuenta);

		lblNombreCuenta = new JLabel("Nombre:");
		lblNombreCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreCuenta.setBounds(42, 62, 60, 14);
		add(lblNombreCuenta);

		lblPassCuenta = new JLabel("Contrase\u00F1a:");
		lblPassCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassCuenta.setBounds(42, 130, 77, 14);
		add(lblPassCuenta);

	}


	public PanelCrearCuenta(ClientePrincipal cp){
		this();
		this.cp=cp;
	}
}
