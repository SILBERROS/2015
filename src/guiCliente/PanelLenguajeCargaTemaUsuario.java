package guiCliente;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import maganer.ManagerTema;
import objetos.Tema;

public class PanelLenguajeCargaTemaUsuario extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private String carpeta;
	
	public PanelLenguajeCargaTemaUsuario(String carpeta) {
		setLayout(null);
		this.carpeta=carpeta;
		
		PanelBloqueAgregarTema panelAgregarTema = new PanelBloqueAgregarTema();
		panelAgregarTema.setBounds(10, 11, 380, 25);
		add(panelAgregarTema);
	}

	public String getCarpeta() {
		return carpeta;
	}
	public void cargarTemas(){
		
		ManagerTema mt = new ManagerTema();
		List<Tema> temas = mt.listar(carpeta);
		PanelTemaBloqueUsuario[] tp = new PanelTemaBloqueUsuario[temas.size()];
		int i=0;
		for(i=0;i<temas.size();i++){
			tp[i]= new PanelTemaBloqueUsuario(temas.get(i));
			tp[i].setBounds(5, i*tp[i].getHeight()+30, tp[i].getWidth(), tp[i].getHeight());
			this.add(tp[i]);
		}
		if(temas.size()>0){
			this.setPreferredSize(new Dimension( PanelTemaBloqueUsuario.WIDTH,i*tp[0].getHeight()+30));
			this.getParent().getParent().getParent().repaint();
		}
	}
}
