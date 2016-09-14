package zad1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {
	
	private final List<Flower> shoppingCart;
	
	public ShoppingCart(){
		shoppingCart = new CopyOnWriteArrayList<Flower>();
	}

	public List<Flower> getShoppingCart() {
		return shoppingCart;
	}
	
	public String toString(){
		return shoppingCart + "";
	}
}
