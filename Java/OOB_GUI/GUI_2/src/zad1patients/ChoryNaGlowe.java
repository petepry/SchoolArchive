package zad1patients;

public class ChoryNaGlowe extends Pacjent {
	
	
	ChoryNaGlowe(String string){
		super(string);
	}


	String nazwisko() {
		return this.getName();
	}


	String leczenie() {
		return "aspiryna";
	}


	String choroba() {
		return "głowa";
	}
}
