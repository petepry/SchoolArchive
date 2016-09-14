package zad2;

import java.util.List;

public class Magazyn {
	
	private List<Towar> towary;
	private boolean newTowarAdded;
	
	
	public Magazyn(List<Towar> towary){
		this.towary = towary;
	}
	
	synchronized public void add(Towar towar){
		while (newTowarAdded){
			try{
				wait();
			} catch (InterruptedException ex){
				System.out.println("Add() interrupted. tehfck?");
				return;
			}
		}
		towary.add(towar);
		newTowarAdded = true;
		notifyAll();
	}
	
	synchronized public Towar getTowar(){
		int licznikWHILEOWFFS = 0;
		while (!newTowarAdded)
			try {
				licznikWHILEOWFFS++;
				wait(5);
				if (licznikWHILEOWFFS > 10)
					break;
			} catch (InterruptedException ex){
				System.out.println("getTowar() interrupted. tehfck?");
				return null;
			}
		newTowarAdded = false;
		notifyAll();
		return towary.get(towary.size()-1);
		
	}

}
