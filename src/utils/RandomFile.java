package utils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {
	public static void writeData(String filePath, byte[] data, int seek) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(seek);
		file.write(data);
		file.close();
	}

	public static byte[] readData(String filePath, int seek, int length) throws IOException {
		RandomAccessFile file = new RandomAccessFile (filePath, "r");
		file.seek(seek);
		byte[] bytes = new byte[length];
		file.read(bytes);
		file.close();
		return bytes;
	}
}
