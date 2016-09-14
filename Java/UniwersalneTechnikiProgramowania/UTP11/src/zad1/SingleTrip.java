package zad1;

import java.util.Date;
import java.util.Locale;

public class SingleTrip {
	/*
	lokalizacja - napis,  oznaczający język_kraj (np. pl_PL, en_US; tak jak zwraca to metoda toString() z klasy Locale)
	kraj - nazwa kraju w języku kontrahenta,
	daty - (wyjazdu, powrotu) daty w formacie RRRR-MM-DD (np. 2015-12-31),
	miejsce - jedno z: [morze, jezioro, góry] - w języku kontrahenta,
	cena - liczba w formacie liczb, używanym w kraji kontrahenta,
	symbol_waluty = PLN, USD itp.*/
	
	Locale loc;
//	String locLanguage;
//	String locCountry;
	String countryName;
	String dateStart;
	String dateEnd;
	String place;
	Double price;
	String currency;
	
	
	public SingleTrip(String loc, String countryName, String dateStart, String dateEnd, String place, 
			Double price, String currency){
		
		if (loc.length() > 2)
			this.loc = new Locale(loc.substring(0, 2),loc.substring(3, 4));
		else
			this.loc = new Locale(loc.substring(0, 2));
		
		this.countryName = countryName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.place = place;
		this.price = price;
		this.currency = currency;
		
			
		
		
	}


	public Locale getLoc() {
		return loc;
	}


	public String getCountryName() {
		return countryName;
	}


	public String getDateStart() {
		return dateStart;
	}


	public String getDateEnd() {
		return dateEnd;
	}


	public String getPlace() {
		return place;
	}


	public Double getPrice() {
		return price;
	}


	public String getCurrency() {
		return currency;
	}


	@Override
	public String toString() {
		return "SingleTrip [loc=" + loc + ", countryName=" + countryName
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd
				+ ", place=" + place + ", price=" + price + ", currency="
				+ currency + "]";
	}
	
	
	

}
