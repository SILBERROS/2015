package maganer;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import objetos.Ejercicio;
import objetos.Tema;

import solicitudes.IniciarSesion;
import utils.Serializar;

public class ManagerEjercicio {

	public List<Ejercicio> listar(String carpeta){
		List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		int c=0;
		int n = Serializar.objectToBytes(new Ejercicio()).length;
		try{
			RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/ejercicio.txt", "r");
			while(true){
				byte[] bytes = new byte[n];
				file.seek(n*c);
				//lee un objeto del archivo 
				int x=file.read(bytes);
				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					Ejercicio ejercicio = (Ejercicio)Serializar.bytesToObject(bytes);
					ejercicios.add(ejercicio);
				}else
					break;
				c++;
			}
			file.close();
		}catch (Exception e) {e.printStackTrace();}
		return ejercicios;
	}


	public boolean agregarEjercicio(String carpeta,String titulo,String descripcion){ 
		try{

			File f=new File("./"+carpeta+"/"+titulo+"/"); //descriptor de carpetas
			if(!f.exists()){
				//si no existe crea la carpeta
				f.mkdir();

				RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/ejercicio.txt", "rw");
				Ejercicio ejercicio = new Ejercicio();
				ejercicio.titulo.setTexto(titulo);
				ejercicio.descripcion.setTexto(descripcion);
				byte[] data = Serializar.objectToBytes(ejercicio);
				file.seek(file.length()); //se mueve hasta el final el archivo
				file.write(data);
				file.close();
				return true;
			}else{
				return false;
			}
		}catch (Exception e1) {e1.printStackTrace();}
		return true;

	}


	//Si se crean estas dos funciones se estaria replicando la pega en el cliente y servidor
	//la logica es que el servidor haga todo el trabajo y el cliente solo envia solicitudes para crear tema.
	//Aplicando estas dos funciones el cliente tambien estaria haciendo el mismo trabajo del servidor.

	/*	public boolean ServerAgregarTema(String carpeta,String titulo){ //

		try{

			File f=new File("./"+carpeta+"/"+titulo+"/"); //descriptor de carpetas
			if(!f.exists()){//pregunta si existe
				//si no existe crea la carpeta
				f.mkdir();

				RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/temas.txt", "rw");
				Tema tema = new Tema();//se crea objeto tema
				tema.titulo.setTexto(titulo);
				tema.num=0;
				byte[] data = Serializar.objectToBytes(tema); //se serializa
				file.seek(file.length()); //se mueve hasta el final el archivo
				file.write(data);//se escribe
				file.close();
				return true; //retorna verdadero pq se creo bien
			}else{
				return false;
			}
		}catch (Exception e1) {e1.printStackTrace();}
		return true;
	}


	public boolean ClienteAgregarTema(String carpeta,String titulo){ //

		try{

			File f=new File("./"+carpeta+"/"+titulo+"/"); //descriptor de carpetas
			if(!f.exists()){//pregunta si existe
				//si no existe crea la carpeta
				f.mkdir();

				RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/temas.txt", "rw");
				Tema tema = new Tema();//se crea objeto tema
				tema.titulo.setTexto(titulo);
				tema.num=0;
				byte[] data = Serializar.objectToBytes(tema); //se serializa
				file.seek(file.length()); //se mueve hasta el final el archivo
				file.write(data);//se escribe
				file.close();
				return true; //retorna verdadero pq se creo bien
			}else{
				return false;
			}
		}catch (Exception e1) {e1.printStackTrace();}
		return true;
	}*/

	/*	public boolean ServerAgregarTema(String carpeta,String titulo){ //

	try{

		File f=new File("./"+carpeta+"/"+titulo+"/"); //descriptor de carpetas
		if(!f.exists()){//pregunta si existe
			//si no existe crea la carpeta
			f.mkdir();

			RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/temas.txt", "rw");
			Tema tema = new Tema();//se crea objeto tema
			tema.titulo.setTexto(titulo);
			tema.num=0;
			byte[] data = Serializar.objectToBytes(tema); //se serializa
			file.seek(file.length()); //se mueve hasta el final el archivo
			file.write(data);//se escribe
			file.close();
			return true; //retorna verdadero pq se creo bien
		}else{
			return false;
		}
	}catch (Exception e1) {e1.printStackTrace();}
	return true;
}


public boolean ClienteAgregarTema(String carpeta,String titulo){ //

	try{

		File f=new File("./"+carpeta+"/"+titulo+"/"); //descriptor de carpetas
		if(!f.exists()){//pregunta si existe
			//si no existe crea la carpeta
			f.mkdir();

			RandomAccessFile file = new RandomAccessFile("./"+carpeta+"/temas.txt", "rw");
			Tema tema = new Tema();//se crea objeto tema
			tema.titulo.setTexto(titulo);
			tema.num=0;
			byte[] data = Serializar.objectToBytes(tema); //se serializa
			file.seek(file.length()); //se mueve hasta el final el archivo
			file.write(data);//se escribe
			file.close();
			return true; //retorna verdadero pq se creo bien
		}else{
			return false;
		}
	}catch (Exception e1) {e1.printStackTrace();}
	return true;
}*/
}
