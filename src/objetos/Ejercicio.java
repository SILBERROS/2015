package objetos;

import java.io.Serializable;

import utils.TextoFijo;

public class Ejercicio implements Serializable{

	private static final long serialVersionUID = 1L;
	public TextoFijo titulo = new TextoFijo(50);
	public TextoFijo descripcion = new TextoFijo(200);
	public int num;
	//public TextoFijo respuesta= new TextoFijo(200);
}