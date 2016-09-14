package zad2;

import java.util.List;
import java.util.function.Function;

public class InputConverter <T>{

	private T source;
		
	public InputConverter(T source) {
		this.source = source;
	}
	
	public <A, B, C, D> D convertBy(Function ... funky) {
		
//		switch (funky.length){
//		case 1: return (D) funky[0].apply(source);
//		case 2: return (D) funky[1].apply(funky[0].apply(source));
//		case 3: return (D) funky[2].apply(funky[1].apply(funky[0].apply(source)));
//		case 4: return (D) funky[3].apply(funky[2].apply(funky[1].apply(funky[0].apply(source))));
//		}
//		
//		return null;
		try {
		
		for (int i = 1; i < funky.length ; i++)
			funky[0] = funky[0].andThen(funky[i]);
		
		return (D) (funky[0].apply(source));
		} catch (ClassCastException e){
//			System.out.println(source.toString());
			return (D) (funky[0].apply(source.toString()));
		}
	}
/*	// flines
		public <A, B> B convertBy(Function<T, B> flines) {
			return flines.apply(source);
		}
		
		// flines + join
		public <A, B> A convertBy(Function<T, B> flines,
				Function<B, A> join) {
			return join.apply(flines.apply(source));
		}
		
		// flines + join + collectInts
		public <A, B, C> C convertBy(Function<T, B> flines,
				Function<B, A> join,
				Function<A, C> collectInts) {
			return collectInts.apply(join.apply(flines.apply(source)));
		}

		// flines + join + collectInts + sum
		public <A, B, C, D>  D convertBy(Function<T, B> flines,
				Function<B, A> join,
				Function<A, C> collectInts,
				Function<C, D> sum) {
			return sum.apply(collectInts.apply(join.apply(flines.apply(source))));
		}*/
}
