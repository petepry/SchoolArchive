/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Main {

  public static void main(String[] args) {
	  
	  String dane = JOptionPane.showInputDialog("Podaj daty od/do");
//	  String dane = "2010-12-17 2011-01-03";
	  if (dane == null || dane.equals("")){
		  System.out.println("Nie podano danych. Dobranoc.Lateah.Bye.Cya.nn.");
		  System.exit(1);
	  }
	  SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	  date.setLenient(false);
	  Scanner sc = new Scanner (dane);
	  String d = "";
	  Date dD1 = null;
	  Date dD2 = null;
	  try{
		  d = sc.next();
		  dD1 = date.parse(d);
	  }catch (Exception e){
		  System.out.println("Wprowadzona data: " + d + " jest niepoprawna. Dobranoc.Lateah.Bye.Cya.nn." );
		  System.exit(1);
	  }
	  try{
		  d = sc.next();
		  dD2 = date.parse(d);
	  }catch (Exception e){
		  System.out.println("Wprowadzona data: " + d + " jest niepoprawna. Dobranoc.Lateah.Bye.Cya.nn." );
		  System.exit(1);
	  }
	  sc.close();
	  
//	  System.out.println(dD1);
//	  System.out.println(dD2);
	  
	  Calendar dC1 = Calendar.getInstance();
	  Calendar dC2 = Calendar.getInstance();
	  
	  
	  dC1.setTime(dD1);
	  dC2.setTime(dD2);
	  dC2.add(Calendar.DATE, 1);
	  
	
	  
	  String day = null;
	  Date tmpDate = null;
	  SimpleDateFormat properDate = new SimpleDateFormat("dd.MM.yyyy");
	  
	  while (!dC1.equals(dC2)){
		  
		  switch (dC1.get(Calendar.DAY_OF_WEEK)) {
			  case 1: {day = "N"; break;}
			  case 2: {day = "Pn"; break;}
			  case 3: {day = "Wt"; break;}
			  case 4: {day = "Œr"; break;}
			  case 5: {day = "Cz"; break;}
			  case 6: {day = "Pt"; break;}
			  case 7: {day = "So"; break;}
			  default: {break;}
		  }
		  tmpDate = dC1.getTime();
		  System.out.println(properDate.format(tmpDate) + " " + day);
		  dC1.add(Calendar.DATE, 1);
	  }
	  
	  
	  
//	  int i = instance.get(Calendar.DAY_OF_WEEK);
//	  System.out.println(instance);
//	  System.out.println(i);
//	  instance.add(Calendar.DATE,  1); // dodaje jeden dzien do przodu
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
