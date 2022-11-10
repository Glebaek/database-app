package DatabaseWindows;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader; 
import java.io.IOException; 
import java.io.PrintWriter; 

public class FileWork { 
 
	public static void write(String fileName, String text) { 
		File file = new File(fileName); 

		try { 
			PrintWriter out = new PrintWriter(file.getAbsoluteFile()); 

			try { 
				out.print(text); 
			} finally { 
				out.close(); 
			} 
		} catch(IOException e) { 
			throw new RuntimeException(e); 
		}
	} 

	public static String read(String fileName) { 

		StringBuilder sb = new StringBuilder(); 
		File file = new File(fileName); 
		try { 
			BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile())); 
			try { 
				String s; 
				while ((s = in.readLine()) != null) { 
					sb.append(s); 
					sb.append("\n"); 
				} 
			} finally { 
				in.close(); 
			} 
		} catch(IOException e) { 
			throw new RuntimeException(e); 
		} 

	return sb.toString(); 
	} 



	public static void update(String nameFile, String newText) { 
		StringBuilder sb = new StringBuilder(); 
		String oldFile = read(nameFile); 
		sb.append(oldFile); 
		sb.append(newText); 
		write(nameFile, sb.toString()); 
		String textFromFile = FileWork.read("database.txt"); 
		System.out.println(textFromFile); 
	} 
	

	
}