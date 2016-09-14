package zad1;
import javax.naming.Context;
import javax.naming.InitialContext;


public class PhoneDirectoryServer {
	
	public static void main(String[] args) {
        try {
   
            PhoneDirectory ref = 
                  new PhoneDirectory(System.getProperty("user.home")+"/pNumbers.txt");
//            Remote obj = UnicastRemoteObject.exportObject(this, 10000);
//            Registry r = LocateRegistry.createRegistry(10000);
//            r.bind("test", obj);

            Context ctx = new InitialContext();   
            ctx.rebind("PhoneDirectoryService", ref );
            System.out.println("Start serwera");

         } catch (Exception exc) {
            exc.printStackTrace();
         } 
     }

}
