package zad1;

import java.util.ArrayList;
import java.util.List;

public class Letters implements Runnable {	// tsdjyjghugytfrdefghujkl

	private List<Thread> threadz;
	private final String[] charz;
	private final int sLength;
	private static int INDEX = 0;


	public Letters(String string) {
		sLength = string.length();
		threadz = new ArrayList<>();
		charz = new String[sLength];
		for (int i = 0; i < sLength; i++){
			charz[i] = string.charAt(i)+"";
			threadz.add(new Thread(this, "Thread " + string.charAt(i)));
		}
	}

	public List<Thread> getThreads() {
		return threadz;
	}

	@Override
	public void run() {
		try{
			while (true){
//				for (int i = 0; i < sLength; i++){
//					System.out.print(charz[i]);
//					Thread.sleep(1000);
//				}
				System.out.print(charz[INDEX]);
				if (INDEX == sLength-1)
					INDEX = 0;
				else
					INDEX++;
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			return;
		}
	}

}
