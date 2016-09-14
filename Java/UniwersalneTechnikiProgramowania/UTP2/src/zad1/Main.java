/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;




import java.util.*;


public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector<Integer> sel = new Selector<Integer>(){

		@Override
		public boolean select(Integer element) {
			if (element < 10)
				return true;
			else
				return false;
		}
    };
    Mapper<Integer, Integer> map = new Mapper<Integer, Integer>(){

		public Integer map(Integer element) {
			
			return element + 10;
		}
    };

    return  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector <String> sel = new Selector<String>(){

		@Override
		public boolean select(String element) {
			if (element.length() > 3)
				return true;
			else
				return false;
		}
    };
    Mapper<Integer, String> map = new Mapper<Integer, String>(){

		@Override
		public Integer map(String element) {
			Integer omg = element.length();
			return omg + 10;
		}
};
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
