package guiCliente;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import maganer.ManagerEjercicio;
import maganer.ManagerTema;
import objetos.Ejercicio;
import objetos.Tema;

public class PanelEjercicioCargarEjercicioAdmin extends JPanel {

	//pendiente
	private static final long serialVersionUID = 1L;
	private String carpeta;

	public PanelEjercicioCargarEjercicioAdmin(String carpeta) {
		setLayout(null);
		this.carpeta=carpeta;

		/*	PanelEjercicioBloqueAdmin panelEjercicioBloqueAdmin= new PanelEjercicioBloqueAdmin();
		panelEjercicioBloqueAdmin.setBounds(10, 11, 380, 25);
		add(panelEjercicioBloqueAdmin);*/
	}

	public String getCarpeta() {
		return carpeta;
	}
	public void cargarEjercicios(){

		ManagerEjercicio me = new ManagerEjercicio ();
		List<Ejercicio> ejercicios= me.listar(carpeta);
		PanelEjercicioBloqueAdmin[] eb = new PanelEjercicioBloqueAdmin[ejercicios.size()];
		int i=0;
		for(i=0;i<ejercicios.size();i++){
			eb[i]= new PanelEjercicioBloqueAdmin(ejercicios.get(i));
			eb[i].setBounds(5, i*eb[i].getHeight()+30, eb[i].getWidth(), eb[i].getHeight());
			this.add(eb[i]);
		}
		if(ejercicios.size()>0){
			this.setPreferredSize(new Dimension( PanelEjercicioBloqueAdmin.WIDTH,i*eb[0].getHeight()+30));
			this.getParent().getParent().getParent().repaint();
		}
	}
}
