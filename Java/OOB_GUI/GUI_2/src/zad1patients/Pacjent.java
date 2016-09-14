package zad1patients;

public abstract class Pacjent {
	
	private String name;
	
	Pacjent(String name){
		this.name = name;
	}
	
	abstract String nazwisko();
	abstract String choroba();
	abstract String leczenie();

	public String getName() {
		return name;
	}
	
	

}
