package test;

import java.io.RandomAccessFile;

import objetos.Tema;
import utils.Serializar;


public class TestTema {

	public static void main(String[] args) {
		try{

			RandomAccessFile file = new RandomAccessFile("./C/temas.txt", "rw");
			int n = Serializar.objectToBytes(new Tema()).length;
			for(int i=0;i<20;i++){

				Tema tema = new Tema();
				tema.titulo.setTexto("Nombre tema "+i);
				tema.num=i;
				byte[] data = Serializar.objectToBytes(tema);
				file.seek(file.length());
				file.write(data);
			}

			file.close();
			int c=0;
			file = new RandomAccessFile("./C/temas.txt", "r");
			while(true){
				byte[] bytes = new byte[n];
				file.seek(n*c);
				//lee un objeto del archivo 
				int x=file.read(bytes);
				c++;					
				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					Tema tema = (Tema)Serializar.bytesToObject(bytes);
					System.out.println("tema: "+tema.titulo.getTexto());
				}else
					break;
			}
			file.close();
		}catch (Exception e) {e.printStackTrace();}
	}

}
