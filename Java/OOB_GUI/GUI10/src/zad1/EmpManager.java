/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class EmpManager {

	public static Employee defEmp(String string) {
		String dane = JOptionPane.showInputDialog(string);
//		System.out.println(dane);
		try{
			Scanner sc = new Scanner(dane);
			Employee e = new Employee (sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
			sc.close();
			return e;
		}catch (InputMismatchException ex){
			try{
				Scanner scx = new Scanner(dane);
				Employee e = new Employee (scx.next(), scx.next(), scx.nextInt(), Double.parseDouble(scx.next()));
				scx.close();
				return e;
			}catch (InputMismatchException | NumberFormatException exc){
//				System.out.println(dane);
				return null;
			}
		}catch (NoSuchElementException | NullPointerException | NumberFormatException ex){
//			System.out.println(dane);
			return null;
		}
	}

	public static void showInfo(Employee e) {
		JOptionPane.showMessageDialog(null, e);
	}

	public static void changeSalary(Employee e) {
		String d = JOptionPane.showInputDialog("Podaj % zmiany pensji");
		
		try{
			Scanner sc = new Scanner(d);
			e.chgSalary(sc.nextDouble());
			sc.close();
			
		}catch (InputMismatchException exc){
			try {
				e.chgSalary(Double.parseDouble(d));
			}catch (Exception excp){
				return;
			}
		}catch (Exception ex){
			return;
		}
	}

}    















