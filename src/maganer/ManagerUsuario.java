package maganer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import objetos.Usuario;

import utils.Serializar;

public class ManagerUsuario {

	public Usuario ClienteIdentificar(Usuario user){

		int esta=0;
		Usuario u = new Usuario();
		try{
			RandomAccessFile file = new RandomAccessFile("usuarios.txt", "r");
			int n= Serializar.objectToBytes(u).length;
			while(true){
				//lee un abjeto del archivo 
				byte[] bytes = new byte[n];
				int x=file.read(bytes);
				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					u = (Usuario)Serializar.bytesToObject(bytes);
					if(u.nombreUser.getTexto().equals(user.nombreUser.getTexto()) && u.passUser.getTexto().equals(user.passUser.getTexto())){
						esta=1;
						break;
					}
				}else
					break;
			}
			file.close();
		}catch (Exception e1) {e1.printStackTrace();}
		if(esta==1)
			return u;
		else
			return null;
	}


	public void ClienteCrear(Usuario u){


		try{

			ByteArrayOutputStream bos= new ByteArrayOutputStream();
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
			file.close();

		}catch (Exception e) {e.printStackTrace();}
	}

	public boolean crearUsuario(String nombre, String pass)
	{
		if (buscarAdministrador(nombre, pass) == false && buscarUsuario(nombre, pass) == false)
		{
			BufferedWriter out = null;   
			try {   
				out = new BufferedWriter(new FileWriter("usuario.txt", true));   
				out.write("\n"+nombre+";"+pass);
				out.close();
				return true;
			} catch (Exception e) {   

			} finally {   
				if (out != null) {   
					try {
						out.close();
					} catch (Exception e) {

						e.printStackTrace();
					}   
				}   
			} 

			return true;			
		}

		else
		{
			return false;
		}
	}

	public void leerArchivo(String path)
	{
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File (path);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}


	//PRIMERO BUSCAR en el Adiministrador.txt - LUEGO en EL Usuario.txt y se ingresa a la respectiva interfaz
	public boolean buscarAdministrador(String nombre, String pass)
	{
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File ("administrador.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)
			{
				String aux = nombre+";"+pass;
				if (aux.equals(linea))
				{
					fr.close();
					return true;

				}
			}
			return false;

		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}

		return false;
	}

	public boolean buscarUsuario(String nombre, String pass)
	{
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File ("usuario.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)
			{
				String aux = nombre+";"+pass;
				if (aux.equals(linea))
				{
					fr.close();
					return true;
				}
			}
			return false;

		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}

		return false;
	}



}


