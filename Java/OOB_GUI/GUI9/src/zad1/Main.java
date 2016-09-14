/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


public class Main {
	public static void main(String[] args) {
		Author autor = new Author(args);
		new Thread(autor).start();
		new Thread(new Writer(autor)).start();
	}
}
