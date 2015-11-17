package maganer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import objetos.Administrador;
import objetos.Usuario;
import utils.Serializar;

public class ManagerAdministrador {

	public Administrador ClienteIdentificar(Administrador admin){

		int esta=0;
		Administrador a = new Administrador();

		try{
			RandomAccessFile file = new RandomAccessFile("administradores.txt", "r");
			int n= Serializar.objectToBytes(a).length;
			while(true){
				//lee un abjeto del archivo 
				byte[] bytes = new byte[n];
				int x=file.read(bytes);
				//des-serializa el objeto y lo convierte a tipo usuario
				if(x!=-1){
					a = (Administrador)Serializar.bytesToObject(bytes);
					if(a.nombreAdmin.getTexto().equals(admin.nombreAdmin.getTexto()) && a.passAdmin.getTexto().equals(admin.passAdmin.getTexto())){
						esta=1;
						break;
					}
				}else
					break;
			}
			file.close();
		}catch (Exception e1) {e1.printStackTrace();}
		if(esta==1)
			return a;
		else
			return null;
	}


	public void ClienteCrear(Administrador admin){


		try{

			ByteArrayOutputStream bos= new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream (bos);
			os.writeObject(admin);
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
					Administrador a = (Administrador)is.readObject();
					is.close();
					System.out.println(a.nombreAdmin.getTexto()+" "+a.passAdmin.getTexto());
				}else
					break;
			}
			file.close();

		}catch (Exception e) {e.printStackTrace();}
	}
}