/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main {

  public static void main(String[] args) {
	  
	  String soe4itgr = JOptionPane.showInputDialog("PODAJ OPCJE [A-G]...");
	  if (soe4itgr == null || soe4itgr.equals("")){
		  System.out.println("Nie podano opcji. Dobranoc.");
		  System.exit(1);
	  }
		  
	  JFrame frame = new JFrame();
//	  frame.getContentPane().setLayout(new GridLayout());
	  
	  frame.setSize(600, 300);
	  
	  JButton one = new JButton("Przycisk 1");
	  JButton two = new JButton("P 2");
	  JButton three = new JButton("Wiêszy przycisk numer 3");
	  JButton four = new JButton("Przycisk 4");
	  JButton five = new JButton("P 5");
	  
	  //	TEMPLATE METHOD?
	  
	  
	  JPanel panel = new JPanel();
	  boolean added = false;
	  
//	  panel.setBounds(300, 300, 700, 700);
	  
	  switch (soe4itgr) {
	  	case "A": ;
	  	case "a": panel.setLayout(new BorderLayout());
			panel.add(one, BorderLayout.EAST);
			panel.add(two, BorderLayout.WEST);
			panel.add(three, BorderLayout.CENTER);
			panel.add(four, BorderLayout.NORTH);
			panel.add(five, BorderLayout.SOUTH);
			added = true;
		  	break;
	  	case "B": ;
	  	case "b": panel.setLayout(new FlowLayout()); break;
	  	case "C": ;
	  	case "c": panel.setLayout(new FlowLayout(FlowLayout.LEFT)); break;
	  	case "D": ;
	  	case "d": panel.setLayout(new FlowLayout(FlowLayout.RIGHT)); break;
	  	case "E": ;
	  	case "e": panel.setLayout(new GridLayout(1,0)); break;
	  	case "F": ;
	  	case "f": panel.setLayout(new GridLayout(0,1)); break;
	  	case "G": ;
	  	case "g": panel.setLayout(new GridLayout(3,2)); break;
	  	

	  	default: break;
	  }
	  if (!added){
		  panel.add(one);
		  panel.add(two);
		  panel.add(three);
		  panel.add(four);
		  panel.add(five);
	  }
	  frame.add(panel);
	  frame.setLocationRelativeTo(null);
//	  panel.setLayout(new GridLayout());
//	  frame.pack();
	  frame.setVisible(true);
	  
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  
	  
  }
}
