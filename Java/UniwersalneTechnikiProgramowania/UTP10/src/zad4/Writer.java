/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad4;



public class Writer implements Runnable {

	
	int autorCounter;
	Author srcAutor;
	
	
    public Writer(Author autor) {
    	srcAutor = autor;
    	if (srcAutor.isAutorEmpty())
    		return;
        autorCounter = autor.getCount();
    }
    
    @Override
    public void run() {
        try {
        	if (srcAutor.isAutorEmpty())
        		return;
        	else {
	        	for (int i = 0; i < autorCounter; i++)
	        		System.out.println("-> " + srcAutor.getQueueueue().take());
        	}
        } catch (InterruptedException e) {
            return;
        }
    }
}
