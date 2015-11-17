package objetos;

import java.io.Serializable;

import utils.TextoFijo;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public TextoFijo nombreUser = new TextoFijo(10);
	public TextoFijo passUser = new TextoFijo(8);
	

}
