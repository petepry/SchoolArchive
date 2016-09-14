/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;




public class Anagrams {
	
	
	List<String> allWerds;

	public Anagrams(String allWords) {
		File plikTxt = new File(allWords);
		Scanner sc;
		allWerds = new ArrayList<>();
		try {
			sc = new Scanner(plikTxt);
			while(sc.hasNext())
				allWerds.add(sc.next());
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku.");
			e.printStackTrace();
		}
	}

	public List<List<String>> getSortedByAnQty() {
		List<List<String>> listOfLists = new ArrayList<>();
		List<String> allWerdsCopy = new ArrayList<>();
		List<String> toCheck = new ArrayList<>();
		List<String> toStore = new ArrayList<>();
		allWerdsCopy.addAll(allWerds);
		toCheck.addAll(allWerds);
		
		if (allWerds.size() > 2){
//			String word = allWerds.get(0);
			
			for (Iterator<String> iterWerdsCopy = allWerdsCopy.iterator(); iterWerdsCopy.hasNext();){
				boolean found = false;
				String one = iterWerdsCopy.next();
				for (Iterator<String> iterToCheck = toCheck.iterator(); iterToCheck.hasNext();){
					String two = iterToCheck.next();
					if (Anagrams.testForAnagram(one, two)){
						toStore.add(two);
						iterToCheck.remove();
						found = true;
					}
				}
				
				if (!found)
					continue;
				List<String> tmp = new ArrayList<>();
				tmp.addAll(toStore);
				listOfLists.add(tmp);
				toStore.clear();

			}

			
		}
		listOfLists.sort((e1, e2) -> e2.size() - e1.size());	// YAAAAA LAMPADAAAAAAAA...
//		Collections.sort(listOfLists, new Comparator<List<String>>(){
//			@Override
//			public int compare (List<String> p1, List<String> p2){
//				int ffs = (p1.size() < (p2.size()) ? 1 : -1);
//				System.out.println(ffs);
////				if (ffs == 0)
////					return p1.getId().compareTo(p2.getId());
//				return ffs;
//			}
//		});;
		
		return listOfLists;
	}
	
	public static boolean testForAnagram(String bread, String beat){
		char[] word1 = bread.toCharArray();
		char[] word2 = beat.toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
		
	}
			
		
//		if (bread.length() != beat.length())
//			return false;
//		int[] candies = new int[bread.length()];
////		char[] first = new char [bread.length()];
////		char[] second = first.clone();
//		
//		for (int i = 0; i < bread.length(); i++){
//			for (int j = 0; j < bread.length(); j++)
//				if (bread.charAt(i) == beat.charAt(j))
//					return false;
//				else
//					candies[i]++;
//		}
//		System.out.println("zwracam SWIENTOMPRAWDE");
//		return true;
//	}
	
	

	public String getAnagramsFor(String findMeIfYouCan) {
		
		if (!allWerds.contains(findMeIfYouCan))
			return findMeIfYouCan + ": null";
		
		List<String> foundYa = new ArrayList<>();
		
		for (String me : allWerds){
			if (Anagrams.testForAnagram(findMeIfYouCan, me))
					foundYa.add(me);
		}
		foundYa.remove(findMeIfYouCan);
		
		return findMeIfYouCan + ": " + foundYa;
	}
}  




















