package zad1;


public class Customer {
	
	private String name;
	private int wallet;
	private ShoppingCart flowerz;
	
	public Customer(String name, int wallet){
		this.name = name;
		this.wallet = wallet;
		flowerz = new ShoppingCart();
	}

	public void get(Flower flower) {
		flowerz.getShoppingCart().add(flower);
	}

	public ShoppingCart getShoppingCart() {
		return flowerz;
	}
	
	public String toString(){
		return ("Klient: " + name + "\nZawartosc koszyka:\n" + flowerz.getShoppingCart());
	}

	public void pay() {
		int suma = 0;
		for (Flower f : flowerz.getShoppingCart()){
			if (!PriceList.getMap().containsKey(f.getNazwa())){
				System.out.println ("Produktu " + f.getNazwa() + " nie ma w cenniku. Zostanie on usunięty z koszyka.");
				flowerz.getShoppingCart().remove(f);
				}
			else
				suma += (PriceList.getPrice(f.getNazwa()))*(f.getIlosc());
		}
		if (suma > wallet){
			System.out.println ("Suma do zapłaty: " + suma + " Klient " + name + " ma w portfelu: " + this.getCash() + " - brak środków!"
					+ "\nUsuwam ostatnio dodane produkty z koszyka...");
			if ((flowerz.getShoppingCart().get((flowerz.getShoppingCart().size()-1)).getIlosc()) == 0)
				flowerz.getShoppingCart().remove(flowerz.getShoppingCart().size());
			else
				flowerz.getShoppingCart().get((flowerz.getShoppingCart().size()-1)).minusIlosc(1);
			this.pay();
		}
		else
			wallet -= suma;
	}
	public double getCash() { return wallet; }

	public void pack(Box pudelkoJanka) {
		for (Flower f : flowerz.getShoppingCart())
			pudelkoJanka.getBox().add(f);
		flowerz.getShoppingCart().clear();
	}
	

}
