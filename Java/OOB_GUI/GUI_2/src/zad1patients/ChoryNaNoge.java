package zad1patients;

public class ChoryNaNoge extends Pacjent {


	ChoryNaNoge(String name) {
		super(name);
	}

	String nazwisko() {
		return this.getName();
	}

	String choroba() {
		return "noga";
	}

	String leczenie() {
		return "gips";
	}

}
