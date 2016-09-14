package zad2florist;

public abstract class Flower { // UWAGA ABSTRACT! why?
	
	private String nazwa;
	private String color;
	private int ilosc;
	
	public Flower(String nazwa, String color, int ilosc){
		this.nazwa = nazwa;
		this.color = color;
		this.ilosc = ilosc;
	}
	
	public String getNazwa() { return nazwa; }
	public String getColor() { return color; }
	public int getIlosc() { return ilosc; }
	public void minusIlosc(int i) { ilosc -= i; }
	
	public String toString(){
		return "\nNazwa: " + nazwa + ", kolor: " + color + ", ilość: " + ilosc;
	}
}
