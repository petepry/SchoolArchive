package zad2florist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {
	
	private final List<Flower> ShoppingCart;
	
	public ShoppingCart(){
		ShoppingCart = new CopyOnWriteArrayList<Flower>();
	}

	public List<Flower> getShoppingCart() {
		return ShoppingCart;
	}
	
	public String toString(){
		return ShoppingCart + "";
	}
}
