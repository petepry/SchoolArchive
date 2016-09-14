/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

  public static void main(String[] args) {
	  
	    String fname = System.getProperty("user.home") + "/test/daty.txt";
	    String content = "";
	    
	    try {
			StringBuffer zawartosc = new StringBuffer("");
			Scanner sc = new Scanner(new File(fname));
			while (sc.hasNext()){
				zawartosc.append(sc.next());
				zawartosc.append(" ");
			}
			content = zawartosc.toString();
			sc.close();
		}
	    catch (Exception ex){
	    	System.out.println("File not found / error reading the file. " + ex);
	    }
	    
	    content = content.replaceAll(("((\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d(\\d)))"), "DOUGH!");
	    content = content.replaceAll(("(((\\d)\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d))"), "DOUGH!");
//	    System.out.println(content);
	    
	    String tmp = "";
	    SimpleDateFormat yaya = new SimpleDateFormat("yyyy-MM-dd");
	    yaya.setLenient(false);
	    Pattern datePattern = Pattern.compile("((\\d\\d\\d\\d-\\d\\d-\\d\\d))");
	    Matcher dateMatcher = datePattern.matcher(content);
	    List<String> listaPrzebojow = new ArrayList<>();
	    while(dateMatcher.find()){
	    	tmp = dateMatcher.group();
	    	try{
	    		yaya.parse(tmp);
	    		listaPrzebojow.add(tmp);
	    	} catch (ParseException e) {
	    		;	// if u catch thiz it meanz ur date is bad. SO bad. so do nothing.
	    	}
	    }

	    for (String d : listaPrzebojow)
	    	System.out.print(d + " ");
  }
}