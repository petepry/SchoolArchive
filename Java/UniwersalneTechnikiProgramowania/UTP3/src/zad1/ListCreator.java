/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class ListCreator <T> { // Uwaga: klasa musi być sparametrtyzowana

	List<T> list;

	
	ListCreator(List<T> src){
		
		list = src;
//		to HAV - price in PLN:	5160
	}
	

	public static <T> ListCreator<T> collectFrom(List<T> src){
		return new ListCreator<T>(src);}
	
	public ListCreator<T> when (Predicate<T> ASD){
		List<T> selectedList = new ArrayList<>();
		for (T element : list){
			if (ASD.test(element))
				selectedList.add(element);
				
		}
		list = selectedList;
		return this;
		
	}


//	@SuppressWarnings("unchecked")
	public List<T> mapEvery(Function<T, T> ASD) {
		List<T> mappedList = new ArrayList<>();
		for (T element : list){
			mappedList.add((T) ASD.apply(element));
		}
		
		return  (List<T>) mappedList;
	}



}  
