/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.util.ArrayList;
import java.util.List;


public class Main {

  public static void main(String[] args) {
    String fname = System.getProperty("user.home") + "/tab.txt";
    Integer[] tabLiczb = Reader.givMeIntz(fname);


    for (int i : tabLiczb)
    	System.out.print(i + " ");
    int max = Integer.MIN_VALUE;
    List<Integer> indexez = new ArrayList<Integer>();
    
    for (int x = 0; x < tabLiczb.length; x++){
    	if (tabLiczb[x] > max)
    		max = tabLiczb[x];
    }
    for (int y = 0; y < tabLiczb.length; y++){
    	if (max == tabLiczb[y])
    		indexez.add(y);
    }
    
    System.out.println("\n" + max);
    for (int z : indexez)
    	System.out.print(z + " ");
  }
}
