/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*<--
 *  niezbędne importy
 */

public class Main {
  public static void main(String[] args) {
	
	Function<String, List<String>> flines = ((String sciezkaPliku) -> {
		File plikTxt = new File(sciezkaPliku);
		Scanner sc;
		List<String> listaWierszy = new ArrayList<>();
		try {
			sc = new Scanner(plikTxt);
			while(sc.hasNextLine())
				listaWierszy.add(sc.nextLine());
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku.");
			e.printStackTrace();
		}
		return listaWierszy;
	});
	
	Function<List<String>, String> join = ((List<String> elemeledudki) -> {
		StringBuilder sumaNapisow = new StringBuilder();
		for (String element : elemeledudki)
			sumaNapisow.append(element);
		
		return sumaNapisow.toString();
	});
	
	Function<String, List<Integer>> collectInts = ((String superDuperString) -> {
		List<Integer> listaIntow = new ArrayList<>();
		Pattern tralalala = Pattern.compile("\\d+");
		Matcher lululu = tralalala.matcher(superDuperString);
		while(lululu.find())
			listaIntow.add(Integer.parseInt(lululu.group()));
		
		return listaIntow;
	});
	
	Function<List<Integer>, Integer> sum = ((List<Integer> listaListaListaPrzebojow) -> {
		Integer sumaElemelentow = 0;
		for (Integer element : listaListaListaPrzebojow)
			sumaElemelentow += element;
		
		return sumaElemelentow;
	});
	

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
