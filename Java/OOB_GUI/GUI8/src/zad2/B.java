package zad2;



public class B extends Thread{
	//NOSAJ thing - ECLIPSE BLUe
	
	private Magazyn towary;
	private volatile static boolean AisDone;
	
//	@SuppressWarnings("unused")
	private int sum;
	
	public B (Magazyn towary){
		this.towary = towary;
		this.setName("SIERRA LEONE");
	}
	
	public static void AisDone(){
		AisDone = true;
	}
	
	
	public void run(){
		int licznik = 0;
		try{
			while(!AisDone) {
				int waga = 0;
				try{
					waga = towary.getTowar().getWaga();
				} catch (ArrayIndexOutOfBoundsException ex){
					continue;
				}
				sum += waga;
				licznik++;
				if ((licznik % 100) == 0){
					System.out.println ("policzono wage "+ licznik +" towarów");
				}
			}
			A.BisDone();
			
			System.out.println("Sumaryczna waga towarów: " + sum);
		} catch (NullPointerException ex){
			System.out.println("getTowar() DAL NULLLLLLLLLLA. CEBULLLLLLA.");
		}
			
		
	}
	

}
