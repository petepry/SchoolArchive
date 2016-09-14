import java.util.ArrayList;
import java.util.List;

public class Bookshelf {

	String nazwa;
	int rozmiar;
	
	List<Book> lista;
	
	
	Bookshelf(String nazwa, int rozmiar) {
		this.nazwa = nazwa;
		this.rozmiar = rozmiar;
		lista = new ArrayList<Book>();
	}

	public void insert(Book trajkacz) throws Exception {
		if (trajkacz.isCzyNaPolce())
			throw new Exception("")
		if ((lista.size() < rozmiar)){
			lista.add(trajkacz);
			trajkacz.setCzyNaPolce(true);
		}
		else
			throw new Exception("Nie mogê wstawiæ ksi¹¿ki na pó³kê (Pó³ka P2) - brak miejsca");
	}

	public List<Book> getBooks() {

		return lista;
	}

	public void remove(Book b) {

	}
	
	public String toString(){
		return "Polka " + nazwa;
	}
	
}
