package zad2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

//public class Futil implements FileVisitor<Path> {
public class Futil {	
	
//	static StringBuilder content;

	public static void processDir(String dirName, String resultFileName) {
//		content = new StringBuilder("");
		
		Predicate<Path> isFile = Files::isRegularFile;
		Predicate<Path> isTxt = p -> p.toString().endsWith(".txt");
		StringBuilder content = new StringBuilder("");
		
		try {
			Files.walk(Paths.get(dirName))
				.filter(isFile.and(isTxt))
				.forEach((e) -> {
//					System.out.println(e);
					BufferedReader reader = null;
					
					try {
						reader = new BufferedReader(new InputStreamReader(new FileInputStream(e.toString()), "Cp1250"));

						String line = "";

						while((line = reader.readLine()) != null ) {
							content.append(line);
							content.append("\n");
						}
						reader.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					OutputStreamWriter writer = null;
					try {
						writer = new OutputStreamWriter(
						        new FileOutputStream("." + "/" + resultFileName), "UTF-8");
					} catch (UnsupportedEncodingException ex) {

						ex.printStackTrace();
					} catch (FileNotFoundException ex) {

						ex.printStackTrace();
					}
					BufferedWriter bufferedWriter = new BufferedWriter(writer);


					try {
//						System.out.println("WPISUJE: " + content);
						bufferedWriter.write(content.toString());
						bufferedWriter.close();
					} catch (IOException ex) {
					ex.printStackTrace();
					}
					
				});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
		


	
	
	
	
	
	
	

}
