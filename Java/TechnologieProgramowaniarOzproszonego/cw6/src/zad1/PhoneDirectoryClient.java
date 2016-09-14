package zad1;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class PhoneDirectoryClient {
	
	public static void main(String args[]) {
		try {
			Context ctx = new InitialContext();

			Object objref = ctx.lookup("PhoneDirectoryService");
//			System.out.println(objref.getClass().getName());

			PhoneDirectoryInterface pdi; // uwaga: zawsze inerfejs!
			pdi = (PhoneDirectoryInterface) PortableRemoteObject.narrow(objref,
					PhoneDirectoryInterface.class);


			Scanner sc = new Scanner (System.in);
			String[] line;
			boolean bb = false;
			System.out.println("Write either:"
					+ "\n  \"get name\" to read a number for given name"
					+ "\n  \"add name number\" to add given name and number to the database"
					+ "\n  \"replace name number\" to replace number for given name"
					+ "\n  \"bye\" to quit.");
			
			while (true) {
				System.out.println("\"get name\" or \"add name number\" or \"replace name number\" or \"bye\"");
				line = sc.nextLine().split(" ", 3);
				line[0] = line[0].toLowerCase();
				
				switch (line[0]) {
					case "get":
						if (line[1] == null){
							System.out.println("404 - NOT FOUND");
						}
						else {
							System.out.println("200 - OK");
							System.out.println(pdi.getPhoneNumber(line[1]));
						}
						break;
						
					case "add":
						boolean doneA = pdi.addPhoneNumber(line[1], line[2]);
						if (doneA)
							System.out.println("200 - DONE");
						else
							System.out.println("500 - ERROR");
						break;
						
					case "replace":
						boolean doneR = pdi.replacePhoneNumber(line[1], line[2]);
						if (doneR)
							System.out.println("200 - DONE");
						else
							System.out.println("500 - ERROR");
						break;
						
					case "bye":
						System.out.println("bye, bye!");
						ctx.close();
						bb = true;
						break;
						
					default:
						System.out.println("COMMAND NOT RECOGNIZED. TRY AGAIN.");
						break;
				}
				if (bb)
					break;
			}
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Shutting down client...");
		System.exit(0);
	}

}
