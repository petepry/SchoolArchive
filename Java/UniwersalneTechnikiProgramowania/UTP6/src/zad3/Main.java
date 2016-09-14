/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad3;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
//		BiFunction<String, List<String>, List<String>> givAnalgrams = ((String bread, List<String> werdz) -> {
//			List<String> analgramsList = new ArrayList<>();
//			for (String w : werdz){
//				if (Main.testForAnagram(bread, w))
//					analgramsList.add(w);
//			}	
//			return analgramsList;
//		});

		
		List<String> listaPrzebojow = new ArrayList<>();
		
		try {
			URL theURLthatKnowsALLLL = new URL("http://www.puzzlers.org/pub/wordlists/unixdict.txt");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(theURLthatKnowsALLLL.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				listaPrzebojow.add(inputLine);
			in.close();
//			System.out.println(listaPrzebojow);
		} catch (Exception ex){
			return;
		}
//		Map<String, Integer> lalala = new HashMap<>();
		
//		Function<String, Map<String, Integer>> givAnalgrams = ((String bread) -> {
//			int counterMeasure = 0;
////			List<String> analgramsList = new ArrayList<>();
////			Map<String, Integer> analgramsWinnerList = new HashMap<>();
//			for (String w : listaPrzebojow){
////					analgramsList.add(w);
//					counterMeasure++;
//				}
//				lalala.put(bread, counterMeasure);
//			}	
//			return lalala;
//		});
		
		
		@SuppressWarnings("unused")
		Stream<String> didIwin = listaPrzebojow.stream();

//			.map(givAnalgrams)
//			.filter(predicate);
//			.forEach((e) -> {
//				int counter = 0;
//				for (String s : listaPrzebojow){
//					if (Main.testForAnagram(e, s))
//						counter++;
//					}
//			lalala.put(e, counter);
//			});
		
//		System.out.println(didIwin);
		
		
		
		
		System.out.println("evil levi live veil vile\n"
				+ "elan lane lean lena neal\n"
				+ "caret carte cater crate trace\n"
				+ "angel angle galen glean lange\n"
				+ "alger glare lager large regal\n"
				+ "abel able bale bela elba");
		}
	


}


