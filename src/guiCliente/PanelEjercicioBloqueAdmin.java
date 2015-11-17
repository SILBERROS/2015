package guiCliente;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import objetos.Ejercicio;

import cliente.ClientePrincipal;

public class PanelEjercicioBloqueAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ClientePrincipal cp;
	private JLabel lblNombreDelEjercicio;
	private JTextArea textAreaEjercicio;
	private JLabel lblCantidadEjercicio;
	private JButton btnVerEjercicio;
	private JButton btnBorrarEjercicio;
	private JLabel lblDescripcion;

	
	public PanelEjercicioBloqueAdmin(Ejercicio ejercicio) {
		
		setLayout(null);
		setSize(315, 135);
		lblNombreDelEjercicio = new JLabel(ejercicio.titulo.getTexto());
		lblNombreDelEjercicio.setBounds(15, 5, 200, 15);
		add(lblNombreDelEjercicio);

		JLabel label = new JLabel("-");
		label.setBounds(5, 5, 10, 15);
		add(label);

		lblCantidadEjercicio = new JLabel("("+ejercicio.num+")");
		lblCantidadEjercicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadEjercicio.setBounds(215, 5, 40, 15);
		add(lblCantidadEjercicio);

		btnVerEjercicio = new JButton("Ver");
		btnVerEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				
		

			}
		});
		btnVerEjercicio.setMargin(new Insets(2, 2, 2, 2));
		btnVerEjercicio.setBounds(255, 5, 30, 15);
		add(btnVerEjercicio);

		btnBorrarEjercicio = new JButton("-");
		btnBorrarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



			}
		});
		btnBorrarEjercicio.setMargin(new Insets(2, 2, 2, 2));
		btnBorrarEjercicio.setBounds(293, 5, 15, 15);
		add(btnBorrarEjercicio);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 47, 305, 80);
		add(scrollPane);

		textAreaEjercicio = new JTextArea();
		textAreaEjercicio.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(textAreaEjercicio);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(5, 31, 74, 14);
		add(lblDescripcion);

	}
	public String getText(){
		return lblNombreDelEjercicio.getText();
	}
}
