package guiCliente;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import maganer.ManagerTema;

public class PanelBloqueAgregarEjercicio extends JPanel {

	private static final long serialVersionUID = 6233160365652513444L;
	private JTextField txtTema;
	private JButton btnAgregar;
	private JLabel lblNuevoTema;


	public PanelBloqueAgregarEjercicio() { //tema nuevo , no tiene argumentos

		setPreferredSize(new Dimension(380, 25));
		setSize(380, 25);
		setLayout(null);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManagerTema mt = new ManagerTema();
				mt.agregarTema(getCarpeta(),txtTema.getText());
				txtTema.setText("");
				cargarTemas();
			}
		});
		btnAgregar.setMargin(new Insets(2, 2, 2, 2));
		btnAgregar.setBounds(305, 5, 64, 15);
		add(btnAgregar);

		txtTema = new JTextField();
		txtTema.setBounds(87, 2, 213, 20);
		add(txtTema);
		txtTema.setColumns(10);

		lblNuevoTema = new JLabel("Nuevo Tema:");
		lblNuevoTema.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevoTema.setBounds(5, 5, 82, 14);
		add(lblNuevoTema);
	}


	private void cargarTemas(){
		PanelLenguajeCargaTemaAdmin panel =(PanelLenguajeCargaTemaAdmin)(this.getParent());
		panel.cargarTemas();
	}
	private String getCarpeta(){
		PanelLenguajeCargaTemaAdmin panel =(PanelLenguajeCargaTemaAdmin)(this.getParent());
		return panel.getCarpeta();
	}
}
