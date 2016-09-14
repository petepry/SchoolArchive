package zad2florist;

import java.util.HashMap;

public class PriceList {
	
	private static final HashMap<String, Double> PL = new HashMap<>();
	private static final PriceList priceList = new PriceList();
	
	public static final PriceList getInstance() {
		return priceList;
	}
	
	private PriceList(){
		
	}
	public static double getPrice(String nazwa){
		return PL.get(nazwa);
	}
	public static HashMap<String, Double> getMap(){
		return PL;
	}
	
	public void put (String name, double price){
		if (PL.containsKey(name))
			System.out.println("W cenniku znajduje się już ten produkt.");
		else
			PL.put(name, price);
	}

}
