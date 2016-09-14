/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;



public abstract class Spiewak {

	private String nazwisko;
	private int nr;
	private static int nr_startowy = 1;


	public Spiewak(String nazwisko){
		this.nazwisko = nazwisko;
		nr = nr_startowy++;
	}

	public abstract String spiewaj();
	public String toString(){

		return "(" + nr + ") " + nazwisko + ": " + spiewaj();
	}

	public static String najglosniej(Spiewak[] tab){
		int[] winner = new int[tab.length];
		for (int i = 0; i < tab.length; i++){
			String tmp = tab[i].spiewaj();
			for (int x = 0; x < tmp.length(); x++){
				if (Character.isUpperCase(tmp.charAt(x)))
					winner[i] += 1;
			}
		}
		int max = 0;
		int ind = 0;
		for (int i = 0; i < winner.length; i++)
			if (winner[i] > max){
				max = winner[i];
				ind = i;
			}
			
		return tab[ind].toString();
	}

}
