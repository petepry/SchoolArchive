package zad2;

import java.io.File;
import java.util.Scanner;



public class A extends Thread{
	
	private final File cake = new File("../Towary.txt");
	private Magazyn towary;
	private volatile static boolean BisDone;
	
	public A (Magazyn towary){
		this.towary = towary;
		this.setName("Les Grandes Marches");
	}
	
	public void run(){
		try {
			int licznik = 0;
			Scanner sc = new Scanner(cake);
			while (sc.hasNext()) {
				String ajdi = sc.next();
				int waga = sc.nextInt();
				towary.add(new Towar(ajdi, waga));;
				licznik++;
				if ((licznik % 200) == 0){
					System.out.println ("utworzono "+ licznik +" obiektów");
				}
				
			}
			sc.close();
			B.AisDone();
			while (!BisDone){
				;
			}
//			Thread.sleep(100);
//			System.out.println("Skonczylem petle w watku A hmmmmmmmmmmm");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public static void BisDone(){
		BisDone = true;
	}
	
}
