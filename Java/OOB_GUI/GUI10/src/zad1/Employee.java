/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


public class Employee {
	
	private String imie;
	private String nazwisko;
	private int wiek;
	private double pensja;

	
	public Employee(String string, String string2, int i, double j) {
		imie = string;
		nazwisko = string2;
		wiek = i;
		pensja = j;
	}

	public String getFirstName() {
		return imie;
	}
	
	public String getLastName() {
		return nazwisko;
	}

	public int getAge() {
		return wiek;
	}

	public Double getSalary() {
		return pensja;
	}

	public void chgSalary(double d) {
		pensja += (d*pensja)/100;
		
	}
	public void setSalary(double d) {
		pensja = d;
	}
	@Override
	public String toString(){
		return imie + " " + nazwisko + " " + wiek + " " + pensja;
	}


}
