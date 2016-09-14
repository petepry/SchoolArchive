public class TestBook {

	public static void main(String[] args) {
		Book b1 = new Book("A", "bbb");
		Book b2 = new Book("B", "ccc");
		Book b3 = new Book("C", "ddd");

		Bookshelf bs1 = new Bookshelf("P1", 10);
		Bookshelf bs2 = new Bookshelf("P2", 2);

		try {
			bs1.insert(b1);
			bs1.insert(b2);
			bs1.insert(b3);
		
			System.out.println(bs1);
			for (Book b : bs1.getBooks())
				System.out.println(b);

			bs2.insert(b1);
		} catch (Exception exc) {
			System.out.println(exc.getMessage()); 
		}
		try {
			for (Book b : bs1.getBooks())
				bs1.remove(b);
			bs2.insert(b1);
			bs2.insert(b2);

			System.out.println(bs2);
			for (Book b : bs2.getBooks())
				System.out.println(b);

			bs2.insert(b3);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

		try {
			bs2.remove(b3);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}

}
