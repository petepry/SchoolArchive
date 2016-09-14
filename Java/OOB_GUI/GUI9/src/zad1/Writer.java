/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;



public class Writer implements Runnable {

	private Author autor;
	private int trololo;
	
    public Writer(Author autor) {
        this.autor = autor;
        trololo = autor.getCount();
    }
    
    @Override
    public void run() {
        try {
        	for (int i = 0; i < trololo; i++)
        		System.out.println("-> " + autor.getQueueueue().take());
        } catch (InterruptedException e) {
            return;
        }
    }
}
