/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2florist;


public class FloristsTest {
  // definicja metody sumowania wartosci kwiatów o podanym kolorze 
  static int valueOf(Box box, String color) {
       /*<- tu trzeba wpisac kod metody */
	  int wartosc = 0;
	  for (int i = 0; i < box.getBox().size(); i++)
		  if (box.getBox().get(i).getColor().equals(color))
			  wartosc += (PriceList.getPrice(box.getBox().get(i).getNazwa()))*(box.getBox().get(i).getIlosc());
	  return wartosc;
	
	  
  }

  public static void main(String[] args) {
    // Kwiaciarnia samoobsługowa
    // ustalenie cennika
    PriceList pl = PriceList.getInstance();
    pl.put("róża", 10.0);
    pl.put("bez", 12.0);
    pl.put("piwonia", 8.0);

    // Przychodzi klient janek. Ma 200 zł
    Customer janek = new Customer("Janek", 200);

    // Bierze różne kwiaty: 5 róż, 5 piwonii, 3 frezje, 3 bzy
    janek.get(new Rose(5));
    janek.get(new Peony(5));
    janek.get(new Freesia(3));
    janek.get(new Lilac(3));

    // Pewnie je umieścił na wózku sklepowyem
    // Zobaczmy co tam ma
    ShoppingCart wozekJanka = janek.getShoppingCart();
    System.out.println("Przed płaceniem\n" + wozekJanka);

    // Teraz za to zapłaci...
    janek.pay();

    // Czy przypadkiem przy płaceniu nie okazało się,
    // że w koszu są kwiaty na które nie ustalono jeszcze ceny?
    // W takim arzie zostałyby usunięte z wózka i Janek nie płaciłby za nie
    // Również może mu zabraknąc pieniędzy, wtedy też kwaity są odkładane.

    System.out.println("Po zapłaceniu\n" + janek.getShoppingCart());

    // Ile Jankowi zostało pieniędzy? 
    System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

    // Teraz jakos zapakuje kwiaty (może do pudełka)
    Box pudelkoJanka = new Box(janek);
    janek.pack(pudelkoJanka);

    // Co jest teraz w wózku Janka...
    // (nie powinno już nic być)
    System.out.println("Po zapakowaniu do pudełka\n" + janek.getShoppingCart());

    // a co w pudełku
    System.out.println(pudelkoJanka);

    // Zobaczmy jaka jest wartość czerwonych kwiatów w pudełku Janka
    System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: "
        + valueOf(pudelkoJanka, "czerwony"));

    // Teraz przychodzi Stefan
    // ma tylko 60 zł
    Customer stefan = new Customer("Stefan", 60);

    // Ale nabrał kwiatów nieco za dużo jak na tę sumę
    stefan.get(new Lilac(3));
    stefan.get(new Rose(5));

    // co ma w wózku
    System.out.println(stefan.getShoppingCart());

    // płaci i pakuje do pudełka
    stefan.pay();
    Box pudelkoStefana = new Box(stefan);
    stefan.pack(pudelkoStefana);

    // co ostatecznie udało mu się kupić
    System.out.println(pudelkoStefana);
    // ... i ile zostało mu pieniędzy
    System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
  }
}
