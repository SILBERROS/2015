package guiCliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import test.TestLogin;
import utils.Serializar;
import maganer.ManagerTema;
import objetos.Tema;
import objetos.Usuario;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import cliente.ClientePrincipal;
import java.awt.Font;

public class PanelLenguajesUsuario extends JPanel {

	private ClientePrincipal cp;
	private PanelLenguajeCargaTemaAdmin tbpC;
	private PanelLenguajeCargaTemaAdmin tbpJava;
	private JTabbedPane tbpPanel;

	public PanelLenguajesUsuario() {

		setLayout(null);
		setSize(405, 305);

		tbpPanel = new JTabbedPane(JTabbedPane.TOP);
		tbpPanel.setBounds(0, 48, 400, 250);
		add(tbpPanel);

		JScrollPane scrollPane = new JScrollPane(); 
		tbpPanel.addTab("C/C++", null, scrollPane, null); 
		tbpC = new PanelLenguajeCargaTemaAdmin("C"); 
		tbpC.setLayout(null);
		scrollPane.setViewportView(tbpC);

		JScrollPane scrollPane1 = new JScrollPane(); 
		tbpPanel.addTab("Java", null, scrollPane1, null); 
		tbpJava = new PanelLenguajeCargaTemaAdmin("Java"); 
		tbpJava.setLayout(null);
		scrollPane1.setViewportView(tbpJava);

		tbpPanel.addChangeListener(new ChangeListener() {  
			public void stateChanged(ChangeEvent e) {

				switch (tbpPanel.getSelectedIndex()) { 
				case 0: // pestaña C/C++
					tbpC.cargarTemas(); 
					break;
				case 1: // pestaña Java
					tbpJava.cargarTemas();

					break;
				}
			}
		});


		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.logOutUsuario();
			}
		});
		btnSalir.setBounds(295, 14, 91, 23);
		add(btnSalir);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(155, 0, 55, 23);
		add(lblUsuario);
		tbpC.cargarTemas();


	}
	public PanelLenguajesUsuario(ClientePrincipal cp) {
		this();
		this.cp=cp;
	}
}
