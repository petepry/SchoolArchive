package zad4;

import java.util.function.Function;

public class InputConverter <T>{

	private T source;
		
	public InputConverter(T source) {
		this.source = source;
	}
	
	@SuppressWarnings("unchecked")
	public <A, B, C, D> D convertBy(@SuppressWarnings("rawtypes") Function ... funky) {
		
//		switch (funky.length){
//		case 1: return (D) funky[0].apply(source);
//		case 2: return (D) funky[1].apply(funky[0].apply(source));
//		case 3: return (D) funky[2].apply(funky[1].apply(funky[0].apply(source)));
//		case 4: return (D) funky[3].apply(funky[2].apply(funky[1].apply(funky[0].apply(source))));
//		}
//		
//		return null;
		
		
		for (int i = 1; i < funky.length ; i++)
			funky[0] = funky[0].andThen(funky[i]);
		
		return (D) (funky[0].apply(source));
	}

}
