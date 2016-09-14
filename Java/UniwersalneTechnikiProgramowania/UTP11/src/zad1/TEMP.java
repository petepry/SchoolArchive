package zad1;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TEMP {

	public static void main(String[] args) {
		String asdf = "1234";
		double a = Double.parseDouble(asdf);
		System.out.println(a);
		
		
		Locale.setDefault(new Locale("pl","PL"));
		
		System.out.println("Domyślna lokalizacja : " + Locale.getDefault());
	    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
	    System.out.println(df.format(new Date()));
	    double num = 123.4;
	    NumberFormat nf = NumberFormat.getInstance();
	    System.out.println("Liczba " + num +
	                       " w lokalizacji domyślnej: " + nf.format(num));
	    nf = NumberFormat.getInstance(new Locale("en"));
	    System.out.println("Liczba " + num +
	                       " w lokalizacji angielskiej: " + nf.format(num));
	    
	    System.out.println("*******");
	    Locale loc = Locale.getDefault();
	    System.out.println(loc);
	    Locale.setDefault(new Locale("en","PL"));
	    loc = Locale.getDefault();
	    System.out.println(loc);
	    
	    System.out.println("*******");
	    System.out.println(loc.getCountry());
	    
	    
	    
	 // Tablica dostępnych lokalizacji

	    Locale[] loc1 = Locale.getAvailableLocales();

	    System.out.println("Kod języka" + "#" +
	                       "Kod kraju" + "#" +
	                       "Kod wariantu" +  "#" +
	                       "Język" + "#" +
	                       "Kraj" +  "#" + "Wariant"
	                      );

	    
	    
	    
	    for (int i=0; i<loc1.length; i++) {
	      String countryCode = loc1[i].getCountry();  // kod kraju
	      String langCode = loc1[i].getLanguage();    // kod języka
//	      String varCode  = loc1[i].getVariant();     // wariant

	      // lokalizacja opisana w języku domyślnej lokalizacji (polskim)
	      String kraj =  loc1[i].getDisplayCountry();
	      String jezyk = loc1[i].getDisplayLanguage();
//	      String wariant = loc1[i].getDisplayVariant();
	      System.out.println(langCode + "#" +
	                         countryCode +  "#" +
//	                         varCode + "#" +
	                         jezyk + "#" + kraj);// + "#" + wariant);

	    }
	    
	    
		   // Make a new Date object. It will be initialized to the 
        // current time.
        Date now = new Date();

        // Print the result of toString()
        String dateString = "2015-09-01";
        System.out.println(" 1. " + dateString);

        // Make a SimpleDateFormat for toString()'s output. This
        // has short (text) date, a space, short (text) month, a space,
        // 2-digit date, a space, hour (0-23), minute, second, a space,
        // short timezone, a final space, and a long year.
        SimpleDateFormat format = 
            new SimpleDateFormat("yyyy-MM-dd");

        // See if we can parse the output of Date.toString()
        try {
            Date parsed = format.parse(dateString);
            System.out.println(" 2. " + parsed.toString());
        }
        catch(ParseException pe) {
            System.out.println("ERROR: Cannot parse \"" + dateString + "\"");
        }

        // Print the result of formatting the now Date to see if the result
        // is the same as the output of toString()
        System.out.println(" 3. " + format.format(now));

	}

}
