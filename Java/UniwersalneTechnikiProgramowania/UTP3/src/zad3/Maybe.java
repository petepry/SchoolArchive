package zad3;

import java.util.NoSuchElementException;
import java.util.function.*;



public class Maybe<T> {

	
	T IsCrazy;
	
	Maybe(T s){
		this.IsCrazy = s;
	}
	
	Maybe(){
		
	}
	
	
//	@SuppressWarnings("unchecked")
	static <T> Maybe<T> of(T s) {
//		if (s != null)
			return new Maybe<T>(s);
//		else
//			return new Maybe<T>();
	}

	void ifPresent(Consumer<T> cons){
		if (this.isPresent())
			cons.accept(this.IsCrazy);
		else
			return;
	}
	
	public <R> Maybe<R> map(Function<T,R> func) {
		if (this.isPresent()) {
//			if (func.apply(IsCrazy) != null) {
				return new Maybe<R>(func.apply(this.IsCrazy));
			} else {
				return new Maybe<R>();
			}
//		}
//		return new Maybe<R>();
	}
	
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	Maybe map (Function<T, ? extends Object> func){
//		if(this.isPresent()){
//			return new Maybe(func.apply((T)this.IsCrazy));
//		}
//		else
//			return this;
//	}
	

	T get () throws NoSuchElementException{
		if(this.isPresent())
			return this.IsCrazy;
		else
			throw new NoSuchElementException("maybe is empty");
	}
	
	
	boolean isPresent(){
		if (this.IsCrazy != null)
			return true;
		else
			return false;
	}

	
	T orElse(T defVal){
		if (this.isPresent())
			return this.IsCrazy;
		else
			return defVal;
	}
	
	
	public Maybe<T> filter(Predicate<T> ffs){
		if(ffs.test(this.IsCrazy))
			return this;
		else	
			return null;
	}
	
	public
	String toString(){
		if (this.isPresent())
			return "Maybe has value " + this.IsCrazy;
		else
			return "Maybe is empty";
	}
	
	
}

















