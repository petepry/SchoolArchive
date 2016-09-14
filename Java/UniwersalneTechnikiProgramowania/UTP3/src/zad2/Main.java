/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

//import java.util.*;

import java.util.Arrays;
import java.util.List;


import static java.util.stream.Collectors.toList;

/*<-- niezbędne importy */

public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest.stream()
    		.filter((String rem) -> rem.startsWith("WAW"))
    		.map((String rem) -> { 

                    	   String PiotrekJestSuper = rem.substring(4,7);
                    	   Double PiotrekJestSuperMotznoEkstraWooohohohoho = Double.parseDouble(rem.substring(8,rem.length()));
                    	   
                    	   return "to " + PiotrekJestSuper + " - price in PLN:	" 
                    	   			+ ((int)(PiotrekJestSuperMotznoEkstraWooohohohoho*ratePLNvsEUR));
                       }).collect(toList());
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     */

    for (String r : result) System.out.println(r);
  }
}