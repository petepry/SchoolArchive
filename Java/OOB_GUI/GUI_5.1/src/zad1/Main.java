/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


public class Main {
	public static void main(String[] args)
	{

		Spiewak s1 = new Spiewak("Carrey"){

			public String spiewaj() {
				return "oooooooooo";
			}

		};

		Spiewak s2 = new Spiewak("Houston"){

			public String spiewaj() {
				return "a4iBBiii";
			}

		};

		Spiewak s3 = new Spiewak("Madonna"){

			public String spiewaj() {
				return "aAa";
			}

		};

		Spiewak sp[] = {s1, s2, s3};

		for (Spiewak s : sp)
			System.out.println(s);
		

		System.out.println("\n" + Spiewak.najglosniej(sp));
	}
}
