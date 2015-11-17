package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import objetos.Usuario;
import objetos.Administrador;
import utils.RandomFile;
import utils.Serializar;


public class TestFile {

	public static void main(String[] args) {
		try{
			//crea objeto y lo llena

			/*	Usuario u = new Usuario();
			u.nombreUser.setTexto("ros");
			u.passUser.setTexto("1234");*/

			Administrador a = new Administrador();
			a.nombreAdmin.setTexto("rosmarie");
			a.passAdmin.setTexto("1234");


			//serializa objeto		

			/*	ByteArrayOutputStream bos= new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream (bos);
			os.writeObject(u);
			os.close();
			byte[] data = bos.toByteArray();
			//calcula peso del obeto serializado
			int n = data.length;
			System.out.println("Peso objeto: "+n);
			//escribe objeto en archivo
			RandomAccessFile file = new RandomAccessFile("usuarios.txt", "rw");
			file.seek(file.length()); //se posiciona al final del archivo
			file.write(data);
			file.close();

			file = new RandomAccessFile("usuarios.txt", "r");
			while(true){
				//lee un abjeto del archivo 
				byte[] bytes = new byte[n];
				int x=file.read(bytes);

				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					ByteArrayInputStream bis= new ByteArrayInputStream(bytes);
					ObjectInputStream is = new ObjectInputStream(bis);
					Usuario user = (Usuario)is.readObject();
					is.close();
					System.out.println(user.nombreUser.getTexto()+" "+user.passUser.getTexto());
				}else
					break;
			}
			file.close();*/


			//		admin:

			ByteArrayOutputStream bos= new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream (bos);
			os.writeObject(a);
			os.close();
			byte[] data = bos.toByteArray();
			//calcula peso del obeto serializado
			int n = data.length;
			System.out.println("Peso objeto: "+n);
			//escribe objeto en archivo
			RandomAccessFile file = new RandomAccessFile("administradores.txt", "rw");
			file.seek(file.length()); //se posiciona al final del archivo
			file.write(data);
			file.close();

			file = new RandomAccessFile("administradores.txt", "r");
			while(true){
				//lee un abjeto del archivo 
				byte[] bytes = new byte[n];
				int x=file.read(bytes);

				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					ByteArrayInputStream bis= new ByteArrayInputStream(bytes);
					ObjectInputStream is = new ObjectInputStream(bis);
					Administrador ad = (Administrador)is.readObject();
					is.close();
					System.out.println(ad.nombreAdmin.getTexto()+" "+ad.passAdmin.getTexto());
				}else
					break;
			}
			file.close();



















		}catch (Exception e) {e.printStackTrace();}
	}

}
