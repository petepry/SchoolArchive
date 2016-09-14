/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;



public class Author implements Runnable {

//	private String[] txt;
	private ArrayBlockingQueue<String> queueueue;
	private ArrayList<String> haha;

	public Author(String[] args) {
		queueueue = new ArrayBlockingQueue<>(1);
		haha = new ArrayList<>();
		boolean wasntNull = true;
		for (int i = 0; i < args.length; i++){
			if (args[i] == null){
				if (wasntNull){
					haha.add(args[i]);
					wasntNull = false;
				}
			}
			else
				haha.add(args[i]);
		}
	}

//	protected BlockingQueue queue = null;
	@Override
	public void run() {
		try {
			for (String s : haha){
				if (s == null)
					break;
				queueueue.put(s);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			return;
		}
	}

	public ArrayBlockingQueue<String> getQueueueue() {
		return queueueue;
	}

	public int getCount() {
		return haha.size()-1;
	}

}  
