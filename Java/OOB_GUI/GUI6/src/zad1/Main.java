/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreads()) System.out.println(t.getName());
    
    
    
    for (Thread t : letters.getThreads()) t.start();
    /*<- tu uruchomić 
         wszystkie kody w wątkach 
    */

    Thread.sleep(5000);
    
    
    
    for (Thread t : letters.getThreads()) t.interrupt();
//    Letters.endIt();
    
    /*<- tu trzeba zapisać
       fragment, który kończy działanie kodów, wypisujących litery 
    */
    
//	nie korzystać z metody stop!
//    Runnable r = () -> { // wyrazenie lambda
//    	for (int i =0; i<10; i++){
//    		System.out.println("sth");
//    	}
//    };
    System.out.println("\nProgram skończył działanie");
  }

}
