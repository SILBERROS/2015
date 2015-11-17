package objetos;

import java.io.Serializable;

import utils.TextoFijo;



public class Cliente implements Serializable{
	
	public TextoFijo nombreUser = new TextoFijo(10);
	public TextoFijo passUser = new TextoFijo(8);

	
}
