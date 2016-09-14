/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Main {

  public static void main(String[] args) {
	  
	  
	  
	  JFrame frame = new JFrame();
	  frame.setSize(500, 300);
//	  JPanel panel = new JPanel();
	  JTextArea txtA = new JTextArea();
	  JScrollPane sPane = new JScrollPane(txtA);
	  
	  sPane.setPreferredSize(new Dimension (500, 500));
	  
	  
	  GraphicsEnvironment GP = GraphicsEnvironment.getLocalGraphicsEnvironment();
	  Font[] fonts = GP.getAllFonts();
	  Font fontNotRdy = fonts[(int)(Math.random()*fonts.length)];
	  int fontSize = (12+(int)(Math.random()*55));
	  Font font = fontNotRdy.deriveFont((float)fontSize);
	  
	  Color background = Main.newColorPlease();
	  Color foreground = Main.newColorPlease();
	  
	  txtA.setBackground(background);
	  txtA.setForeground(foreground);
	  txtA.setFont(font);
	  
	  txtA.setText("JAKIE POLECENIE\nTAKIE ZADANIE.\n"
	  		+ "Kolor tla: " + txtA.getBackground() + "\n"
	  		+ "Kolor czcionki: " + foreground + "\n"
	  		+ "Czcionka: " + txtA.getFont());
	  
	  frame.add(sPane);
//	  frame.pack();
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static Color newColorPlease(){
	  Random rand = new Random();
	return new Color (rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
  }
}
