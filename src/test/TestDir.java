package test;

import java.io.File;

public class TestDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String dir="./carpetaPru/";
			File file = new File(dir);
			if(!file.exists())
				file.mkdir();
			for(int i=0;i<3;i++){
				File f = new File(dir+i+".txt");
				if(!f.exists())
					f.createNewFile();
			}
			
			deleteDir(dir);
		}catch (Exception e) {e.printStackTrace();}

	}
	public static boolean deleteDir(String path){
		File file = new File(path);
		if(!file.isDirectory())
			return false;
		else{
			File files[]= file.listFiles();
			for(int i=0;i<files.length;i++)
				if(files[i].isFile())
					files[i].delete();
				else
					return false;
			file.delete();
		}
		return true;
	}

}
