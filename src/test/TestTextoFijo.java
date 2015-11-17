package test;

import utils.Serializar;
import objetos.Usuario;

public class TestTextoFijo {

	
	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.nombreUser.setTexto("Rossss");
		byte[] data= Serializar.objectToBytes(u);
		System.out.println(data.length);

	}

}
