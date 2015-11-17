package guiCliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import objetos.Tema;


import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class PanelTemaBloqueAdmin extends JPanel {
	private static final long serialVersionUID = 6233160365652513444L;
	private JLabel lblNombreDelTema;
	private JLabel lblNum;
	private JButton buttonBorrar;
	private JButton btnVer;


	public PanelTemaBloqueAdmin(Tema tema) {

		setPreferredSize(new Dimension(315, 25));
		setSize(315, 25);
		setLayout(null);
		lblNombreDelTema = new JLabel(tema.titulo.getTexto());
		lblNombreDelTema.setBounds(5, 5, 205, 15);
		add(lblNombreDelTema);

		lblNum = new JLabel("("+tema.num+")");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setBounds(215, 5, 40, 15);
		add(lblNum);

		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				File ejercicios=new File("./"+getCarpeta()+"/"+lblNombreDelTema.getText()+"/");
				String nombres[]=ejercicios.list();
				for(int i=0; i<nombres.length;i++)
					System.out.println(nombres);
				System.out.println(lblNombreDelTema.getText()+" "+lblNum.getText());

			}
		});
		btnVer.setMargin(new Insets(2, 2, 2, 2));
		btnVer.setBounds(255, 5, 30, 15);
		add(btnVer);

		buttonBorrar = new JButton("-");
		buttonBorrar.setMargin(new Insets(2, 2, 2, 2));
		buttonBorrar.setBounds(293, 5, 15, 15);
		add(buttonBorrar);

	}

	public String getText(){

		return lblNombreDelTema.getText();
	}
	private String getCarpeta(){ //obtiene la carpeta si es C o Java
		PanelLenguajeCargaTemaAdmin panel =(PanelLenguajeCargaTemaAdmin)(this.getParent());
		return panel.getCarpeta();
	}
}
