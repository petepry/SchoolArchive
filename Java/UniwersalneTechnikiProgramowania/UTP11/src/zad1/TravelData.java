package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TravelData {

	List<SingleTrip> imTrippin;

	public TravelData(File dataDir) {
		imTrippin = new ArrayList<>();
		try {

			// WALKING ON SUNSHINE (WHOA OH!) errr thru specified directory (datadir) looking for files (regular files).
			Path pathToData = dataDir.toPath();
			Files.walk(pathToData).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					readSingleFile(filePath);
				}
			});


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method for reading a single file and creating SingleTrip objects from it -> addin to our great list of trips
	public void readSingleFile(Path filePath) {

		String loc;
		String countryName;
		String dateStart;
		String dateEnd;
		String place;
		Double price;
		String currency;



		try {
			//BufferedReader used to get a line from a file
			BufferedReader br = new BufferedReader(new FileReader(filePath.toString()));
			String line = "";

			while ((line = br.readLine()) != null){
				@SuppressWarnings("resource")

				//Scanner used to read from a single line (not whole file bcoz then its f#ckd up)
				Scanner sc = new Scanner (line).useDelimiter("	");	//delimiter <TAB>
				while (sc.hasNext()){
					//					System.out.println(sc.locale());	//test
					loc = sc.next();
					sc.useLocale(new Locale(loc.substring(0, 2)));	//telling scanner to use locale as provided (for reading double values, difference between "." and ",") its a substring of two characters from for example either "en" or "en_GB"
					//					System.out.println(sc.locale());	//test
					countryName = sc.next();
					dateStart = sc.next();
					dateEnd = sc.next();
					place = sc.next();
					price = sc.nextDouble();
					//					System.out.println(price);		//test
					currency = sc.next();

					imTrippin.add(new SingleTrip(loc, countryName, dateStart, dateEnd, place, price, currency));



					// what is read while its running:
					/*					System.out.print("loc: ");
					System.out.println(sc.next());	//loc
					System.out.print("Kraj: ");
					System.out.println(sc.next());	//countryName
					System.out.print("Start: ");
					System.out.println(sc.next());	//dateStart
					System.out.print("End: ");
					System.out.println(sc.next());	//dateEnd
					System.out.print("Miejsce: ");
					System.out.println(sc.next());	//place
					System.out.print("Cena: ");
					System.out.println(sc.next());	//price
					System.out.print("Waluta: ");
					System.out.println(sc.next());	//currency
//				System.out.print("Fake: ");
//				System.out.println(sc.next());	//fake reading coz of new line (in case of reading a whole file not a single line, does NOT work anyway))
					 */				}
				sc.close();
			}
			br.close();

		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public List<String> getOffersDescriptionsList(String localeFromMain,
			String dateFormatFromMain) {
//		System.out.println(imTrippin.toString());		//test
		Locale[] locAll = Locale.getAvailableLocales();
		List<String> finalList = new ArrayList<>();


		Locale savedLoc = Locale.getDefault();
		Locale loc = Locale.getDefault();
		if (localeFromMain.startsWith("pl"))
			loc = new Locale ("pl", "PL");
		if (localeFromMain.startsWith("en"))
			loc = new Locale ("en", "GB");


//foookin complicated
		for (SingleTrip st : imTrippin){
			String finalSTRINGWOHOOOOO = "";
			Locale.setDefault(st.getLoc());
			Locale found = Locale.getDefault();		//FOUND WHAT???!!! 
//			Locale countryLoc = st.getLoc();
			String countryName = st.getCountryName();
//			System.out.println(countryName);	//test
			for (int i = 0; i < locAll.length; i++) {
				if (countryName.equals(locAll[i].getDisplayCountry())){
					found = locAll[i];				// FU ?I DONT KNOW
					break;
//					System.out.println("Szukalem: " + countryName);
//					System.out.println("Znalazlem: " + locAll[i].getDisplayCountry() + " " + i);
				}
			}
			Locale.setDefault(loc);
			String finalCountryName = found.getDisplayCountry();
			String finalCountryName2 = found.getDisplayCountry(new Locale("pl"));

			finalSTRINGWOHOOOOO += finalCountryName + " ";

//			Japonia 2015-09-01 2015-10-01 jezioro 10 000,2 PLN

			SimpleDateFormat format = new SimpleDateFormat(dateFormatFromMain);
			format.setLenient(true);


			try {
				Date dateStart = format.parse(st.getDateStart());
				Date dateEnd = format.parse(st.getDateEnd());
//				System.out.println(format.format(dateStart));		//test
//				System.out.println(format.format(dateEnd));		//test
				finalSTRINGWOHOOOOO += format.format(dateStart) + " " + format.format(dateEnd) + " ";
			} catch (ParseException e) {
				System.out.println("ERROR: Cannot parse \"" + st.getDateStart() + " or " + st.getDateEnd() + "\"");
			}
			//****************** lokalizacja SIEDZMIU GOR RZEK I JEZIOR
			ResourceBundle info = ResourceBundle.getBundle("zad1.TripInfo", Locale.getDefault());
			String place = "";
			
			if (st.getPlace().startsWith("j") || st.getPlace().startsWith("l"))
				place = info.getString("lake");
			else
				if (st.getPlace().startsWith("mor") || st.getPlace().startsWith("s"))
					place = info.getString("sea");
				else
					place = info.getString("mountains");
			
			
			//********** DODANIE GOR, CENY I WALUTYffs
			NumberFormat nf = NumberFormat.getInstance();
			String tempString = nf.format(st.getPrice());
			
			finalSTRINGWOHOOOOO += place + " " + tempString + " " + st.getCurrency();
			
			
			finalList.add(finalSTRINGWOHOOOOO);

		}

		
		
		
		
		
		
		
		
		
		

		return finalList;
	}

}
