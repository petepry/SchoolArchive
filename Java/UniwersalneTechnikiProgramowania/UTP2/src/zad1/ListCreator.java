/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;


public class ListCreator <T> { // Uwaga: klasa musi być sparametrtyzowana
	
	
	
	List<T> list;

	
	ListCreator(List<T> src){
		
		list = src;
		
	}
	

	public static <T> ListCreator<T> collectFrom(List<T> src)	{return new ListCreator<T>(src);}
	
	public ListCreator<T> when (Selector<T> sel){
		List<T> selectedList = new ArrayList<>();
		for (T element : list){
			if (sel.select(element))
				selectedList.add(element);
				
		}
		list = selectedList;
		return this;
		
	}


	@SuppressWarnings("unchecked")
	public List<Integer> mapEvery(Mapper<Integer, T> map) {
		List<T> mappedList = new ArrayList<>();
		for (T element : list){
			mappedList.add((T) map.map(element));
		}
		
		return  (List<Integer>) mappedList;
	}



}  
