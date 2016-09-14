/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Reader {
	
	public static Integer[] givMeIntz (String string){
		
	List<Integer> listaPrzebojow = new ArrayList<Integer>();
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner (new File(string));
			while(sc.hasNext())
				listaPrzebojow.add(sc.nextInt());
			sc.close();
		} 
		catch (Exception e) {
			System.out.println("***");
			System.exit(1);
		}

		Integer[] tab = listaPrzebojow.toArray(new Integer[]{});
		return tab;
	}
}    
