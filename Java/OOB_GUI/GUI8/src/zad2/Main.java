/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		
		List<Towar> towaryList = new ArrayList<>();
		Magazyn towary = new Magazyn(towaryList);
		A threadA = new A(towary);
		B threadB = new B(towary);
		threadA.start();
		threadB.start();
		
		
		
		/*try {
			int licznik = 0;
			Scanner sc = new Scanner(cake);
			while (sc.hasNext()) {
				String ajdi = sc.next();
				int waga = sc.nextInt();
				synchronized (towary) {
					towary.add(new Towar(ajdi, waga));
					towary.notify();
				}
				licznik++;
				if ((licznik % 200) == 0){
					System.out.println ("utworzono "+ licznik +" obiektów");
					break;
				}
				
			}
			System.out.println("Skonczylem na dwustu. Oto magazyn:");
			System.out.print(towary);
		} catch (Exception ex) {
			System.out.println(ex);
		}*/

	}
}
