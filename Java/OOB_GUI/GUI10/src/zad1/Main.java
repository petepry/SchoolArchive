/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;


import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {

    Employee janek = new Employee("Jan", "Janek", 30, 4000);
    System.out.println(janek);
    System.out.println(janek.getFirstName() + " " + janek.getLastName());
    System.out.println("Za rok bedzie mial: " + (janek.getAge() + 1) + " lat.");
    janek.chgSalary(3.5);
    System.out.println("I bedzie zarabial: " + janek.getSalary() );

    Employee e = EmpManager.defEmp("Podaj dane pracownika");
    if (e == null) JOptionPane.showMessageDialog(null, "Nie podano danych");
    else {
      EmpManager.showInfo(e);
      EmpManager.changeSalary(e);
      EmpManager.showInfo(e);
    }
  }
}
