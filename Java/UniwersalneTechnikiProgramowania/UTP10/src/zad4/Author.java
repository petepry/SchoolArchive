/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad4;

import java.util.concurrent.ArrayBlockingQueue;



public class Author implements Runnable {

	String[] txt;
	ArrayBlockingQueue<String> queueueue;
	boolean argsIsEmpty = false;

	public Author(String[] args) {

		if (args.length == 0)
			argsIsEmpty = true;
		else {
			queueueue = new ArrayBlockingQueue<>(args.length);
			txt = args.clone();
		}
	}

	@Override
	public void run() {
		try {
			if (argsIsEmpty)
				return;
			else {
				for (String element : txt){
					queueueue.put(element);
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	public boolean isAutorEmpty() {
		return argsIsEmpty;
	}

	public int getCount() {
		return txt.length;
	}
	
	public ArrayBlockingQueue<String> getQueueueue() {
		return queueueue;
	}
	

	


}  
