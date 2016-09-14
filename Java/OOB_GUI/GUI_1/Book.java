
public class Book {
	
	public boolean isCzyNaPolce() {
		return czyNaPolce;
	}

	public void setCzyNaPolce(boolean czyNaPolce) {
		this.czyNaPolce = czyNaPolce;
	}

	private String autor;
	private String tytul;
	private boolean czyNaPolce;
	
	
	public Book (String autor, String tytul){
		this.autor= autor;
		this.tytul= tytul;
	}
	
	public String toString(){
		return autor + " " + tytul;
	}
	
	
	
}
