package zad2florist;

import java.util.ArrayList;
import java.util.List;

public class Box {
	
	private List<Flower> box;
	
	public Box(Customer janek) {
		box = new ArrayList<>();
	}
	
	public List<Flower> getBox() { return box; }
	
	public String toString(){
		return box + "";
	}

}
