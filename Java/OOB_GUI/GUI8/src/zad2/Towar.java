package zad2;

public class Towar {

	private String id;
	private int waga;
	
	public Towar(String id, int waga){
		this.id = id;
		this.waga = waga;
	}

	public int getWaga() {
		return waga;
	}

	@Override
	public String toString() {
		return "Towar id:" + id + ", waga:" + waga + "";
	}
	

}
