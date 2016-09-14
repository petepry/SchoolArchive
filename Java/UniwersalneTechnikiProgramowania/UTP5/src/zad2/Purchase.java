/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

public class Purchase {


	private String id;
	private String nazwiskoImie;
//	private String imie;
	private String towar;
	private double cena;
	private double ilosc;
	
	
	public Purchase(String id, String nazwiskoImie, String towar, Double cena, Double ilosc){
		this.id = id;
		this.nazwiskoImie = nazwiskoImie;
		this.towar = towar;
		this.cena = cena;
		this.ilosc = ilosc;
//		this.cena = Double.parseDouble(cena);
//		this.ilosc = Double.parseDouble(ilosc);
		
	}
	
	
	@Override
	public String toString() {
		return id + ";" + nazwiskoImie
				+ ";" + towar + ";" + cena + ";" + ilosc;
	}


	public String getId() {
		return id;
	}


	public String getNazwiskoImie() {
		return nazwiskoImie;
	}


	public String getTowar() {
		return towar;
	}


	public double getCena() {
		return cena;
	}


	public double getIlosc() {
		return ilosc;
	}
	
	
}
