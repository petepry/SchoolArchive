package zad1patients;

public class ChoryNaDyspepsje extends Pacjent {
	
	
	ChoryNaDyspepsje(String name) {
		super(name);
	}


	@Override
	String nazwisko() {
		return this.getName();
	}

	@Override
	String choroba() {
		return "dyspepsja";
	}

	@Override
	String leczenie() {
		return "węgiel";
	}

}
