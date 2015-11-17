package objetos;

import java.io.Serializable;

import utils.TextoFijo;

public class Administrador implements Serializable{
	
	
	public TextoFijo nombreAdmin = new TextoFijo(10);
	public TextoFijo passAdmin = new TextoFijo(8);
	

}
