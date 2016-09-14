/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CustomersPurchaseSortFind {
	
	List<Purchase> listaPrzebojow;
	

	public void readFile(String fname) {
		File plikTxt = new File(fname);
		Scanner sc;
		List<String> listaTemp = new ArrayList<>();
		try {
			sc = new Scanner(plikTxt).useDelimiter(";");
			while(sc.hasNextLine())
				listaTemp.add(sc.nextLine());
//				listaPrzebojow.add(new Purchase(sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.nextDouble()));
//				System.out.println((sc.next() + " " + sc.next() + " " + sc.next() + " " + sc.next() + " " + sc.next()));
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku.");
			e.printStackTrace();
		}
		
//		System.out.println(listaTemp);
		Scanner scn;
		listaPrzebojow = new ArrayList<>();
		for (String e : listaTemp){
			scn = new Scanner(e).useDelimiter(";");
			listaPrzebojow.add(new Purchase(scn.next(),scn.next(),scn.next(),scn.nextDouble(),scn.nextDouble()));
//			System.out.println("ID: " + scn.next() + " NazwImie: " + scn.next() + " Towar: " + scn.next() + " Cena: " 
//								+ scn.nextDouble() + " Ilosc: " + scn.nextDouble());
			
		}
//		System.out.println(listaPrzebojow);
		
		
		
		
	}

	public void showSortedBy(String string) {
		
		switch (string){
			case "Nazwiska"	:
							List<Purchase> byNazwiska = new ArrayList<>();
							byNazwiska.addAll(listaPrzebojow);
							Collections.sort(byNazwiska, new Comparator<Purchase>(){
								@Override
								public int compare (Purchase p1, Purchase p2){
									int ffs = p1.getNazwiskoImie().compareTo(p2.getNazwiskoImie());
									if (ffs == 0)
										return p1.getId().compareTo(p2.getId());
									return ffs;
								}
								
							});
							System.out.println("Nazwiska");
							for (Purchase p : byNazwiska)
								System.out.println(p);
							break;
			case "Koszty"	:
							List<Purchase> byKoszty = new ArrayList<>();
							byKoszty.addAll(listaPrzebojow);
							Collections.sort(byKoszty, new Comparator<Purchase>(){
								@Override
								public int compare (Purchase p1, Purchase p2){
									int ffs = (int)((p2.getCena()*p2.getIlosc())- (p1.getCena()*p1.getIlosc()));
									if (ffs == 0)
										return p1.getId().compareTo(p2.getId());
									return ffs;
								}
								
							});
							System.out.println("\nKoszty");
							for (Purchase p : byKoszty)
								System.out.println(p + " (koszt: " + p.getCena()*p.getIlosc() + ")");
							break;
			default: System.out.println("OJEEEEEEEEEEEJNFUu2");
		}			
		
	}

	public void showPurchaseFor(String id) {
		System.out.println("\nKlient " + id);
		for (Purchase p : listaPrzebojow){
			if(id.equals(p.getId()))
				System.out.println(p);
		}
		
	}
}
