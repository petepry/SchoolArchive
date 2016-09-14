/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CountWords {

	
	private List<String> listaPrzebojow;
	private HashMap<String, Integer> WHY_NOT_ZOIDBERG;
	private List<String> uncounted;
	
	public CountWords(String fname) {
		uncounted = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
//			Scanner sc = new Scanner (new File(fname)).useDelimiter("((\\p{Punct}*)(\\s+)(\\p{Punct}*))");
			Scanner sc = new Scanner (new File(fname)).useDelimiter("((\\p{Punct}+(\\s*(\\p{Punct}*)))|(\\s+(\\p{Punct}*(\\s*))))");
			while(sc.hasNext()){
				String tmpWord = sc.next();
				if (!(tmpWord.isEmpty()))
					uncounted.add(tmpWord);
			}
			sc.close();
		} 
		catch (IOException e) {
			System.out.println("File not found/error reading it. cmon.");
			System.exit(1);
		}
		

	}  

	public List<String> getResult() {
		WHY_NOT_ZOIDBERG = new HashMap<>();
	    for (String w : uncounted) {
	    	if (WHY_NOT_ZOIDBERG.containsKey(w))
	    		WHY_NOT_ZOIDBERG.put(w, WHY_NOT_ZOIDBERG.get(w)+1);
	    	else
	    		WHY_NOT_ZOIDBERG.put(w, 1);
	    }
//	    System.out.println(WHY_NOT_ZOIDBERG);	//check what keys and values are added to d map
	    listaPrzebojow = new ArrayList<>();
	    Set<String> tmpSetList = new TreeSet<>(uncounted);
	    for (String w : tmpSetList) {
	    	listaPrzebojow.add(w + " " + WHY_NOT_ZOIDBERG.get(w));
	    }
		return listaPrzebojow;
	}
}  
