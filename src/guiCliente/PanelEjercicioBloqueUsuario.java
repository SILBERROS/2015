package guiCliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEjercicioBloqueUsuario extends JPanel {
	private JLabel lblNombreDelTema;
	private JButton btnVer;
	private JLabel lblRespuestas;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public PanelEjercicioBloqueUsuario() {
		setLayout(null);
		setSize(315, 110);
		lblNombreDelTema = new JLabel("Nombre del Ejercicio");
		lblNombreDelTema.setBounds(15, 5, 200, 15);
		add(lblNombreDelTema);
		
		JLabel label = new JLabel("-");
		label.setBounds(5, 5, 10, 15);
		add(label);
		
		lblRespuestas = new JLabel("(#)");
		lblRespuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuestas.setBounds(215, 5, 40, 15);
		add(lblRespuestas);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVer.setMargin(new Insets(2, 2, 2, 2));
		btnVer.setBounds(280, 5, 30, 15);
		add(btnVer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 25, 305, 80);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(212, 208, 200));
		scrollPane.setViewportView(textArea);

	}
}
