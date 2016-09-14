package zad1;

import static java.nio.file.FileVisitResult.*;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Futil implements FileVisitor<Path> {
	
	
	static StringBuilder content;
	static Charset inCharset;
	static Charset outCharset;
	static List<ByteBuffer> buffList;

	public static void processDir(String dirName, String resultFileName) {
		content = new StringBuilder("");
		buffList = new ArrayList<>();
		inCharset  = Charset.forName("Cp1250");
		outCharset = Charset.forName("UTF-8");
		
		
		Path path = Paths.get(dirName);
		Futil yaya = new Futil();
		try {
			Files.walkFileTree(path, yaya);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("I/O EXCEPTION.");
			return;
		}
		
//		System.out.println(content);
		
		

		
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(
			        new FileOutputStream("." + "/" + resultFileName), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		try {
			bufferedWriter.write("");
//			bufferedWriter.write(content.toString());
//			bufferedWriter.close();
		} catch (IOException e) {
		e.printStackTrace();
		}

		try {
			
			
			FileOutputStream fileOutputStream = new FileOutputStream("." + "/" + resultFileName);
			FileChannel fcout = fileOutputStream.getChannel();
			
			
			for (ByteBuffer b : buffList){
				fcout.write(b);
			}
			
			fileOutputStream.close();
			fcout.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
//		BufferedReader reader = null; //poprzednia versja
		if (attr.isRegularFile()) {
			if (file.getFileName().toString().endsWith(".txt")){
//				System.out.println("TXT FILE: " + file.getFileName());
//			else
//	            System.out.println("NOT A TXT FILE: " + file.getFileName());
				
				FileInputStream fileInputStream = new FileInputStream(file.toString());
				FileChannel fcin = fileInputStream.getChannel();

				ByteBuffer buf = ByteBuffer.allocate((int)fcin.size());

			       // czytanie z kanału
				fcin.read(buf);
				
				// dekodowanie bufora bajtowego
				buf.flip();
				CharBuffer cbuf = inCharset.decode(buf);

			    // enkodowanie bufora znakowego
			    // i zapis do pliku poprzez kanał

				buf = outCharset.encode(cbuf);
//				fcout.write(buf);

				fcin.close();
//				fcout.close();
				
				
				buffList.add(buf);
				fileInputStream.close();
				
				
				
				
				// poprzednia versja
//				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "Cp1250"));
//				String line = "";
//	
//				while((line = reader.readLine()) != null ) {
//					content.append(line);
//					content.append("\n");
//				}
//				reader.close();
			}
        } 
		
        return CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return CONTINUE;
	}

	
	
	
	
	
	
	

}
