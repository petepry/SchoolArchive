/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Finder {
	
	private String content;
	
	public Finder(String fPath){
		try {
			StringBuffer zawartosc = new StringBuffer("");
			BufferedReader r = new BufferedReader(new FileReader(fPath));
			String line = r.readLine();
			while (line != null){
				zawartosc.append(line);
				zawartosc.append("\n");
				line = r.readLine();
			}
			content = zawartosc.toString();
			r.close();
		} catch (IOException e) {
			System.out.println("File not found!!111 either error reading the file.");
			e.printStackTrace();
		}
	}
	

	public int getIfCount() {
		

//		System.out.println(content);	//instrukcja pomocnicza
//		System.out.println();
		String cleanContent = content.replaceAll("\".*\"", ""); // das ist correct removes ""sth sth""
//		System.out.println(cleanContent1);	//instrukcja pomocnicza
		cleanContent = cleanContent.replaceAll("//.*", ""); // das ist correct removes "// sth sth" 
//		System.out.println(cleanContent);
		cleanContent = cleanContent.replaceAll("/\\*.*\\*/", ""); // removes "/* sth sth */"
//		System.out.println(cleanContent);
		cleanContent = cleanContent.replaceAll("(/\\*((\n*.*)(\n*)(.*))\\*/)", ""); // removes multiline /* sth */
//		System.out.println(cleanContent);
		Pattern yf = Pattern.compile("if(\\s*)\\(");
		Matcher mYf= yf.matcher(cleanContent);

		int i = 0;
		while (mYf.find()){
			i++;
//			System.out.println(mYf.group());
		}
		return i;
	}

	public int getStringCount(String string) {
		int i = 0;
		Pattern wariant = Pattern.compile("wariant");
		Matcher mWariant = wariant.matcher(content);
//		System.out.println(content);
		while (mWariant.find()){
			i++;
//			System.out.println(mWariant.group());
		}
		return i;
	}
}    
