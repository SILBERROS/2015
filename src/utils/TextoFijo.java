package utils;

import java.io.Serializable;

public class TextoFijo implements Serializable{
	private char[] texto;

	public TextoFijo(int n){
		texto=new char[n];
	}
	public String getTexto(){
		String aux = String.valueOf(texto);
		int i;
		for(i=0;i<aux.length();i++)
			if(aux.charAt(i)=='\0')
				break;
		return aux.substring(0, i);
	}
	public void setTexto(String texto){
		int i;
		for(i=0;i<texto.length();i++)
			this.texto[i]=texto.charAt(i);
		if(texto.length()<this.texto.length)
			this.texto[i]='\0';
	}
}
