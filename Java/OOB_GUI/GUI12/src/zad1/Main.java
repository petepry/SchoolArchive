/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.awt.*;


@SuppressWarnings("serial")
public class Main extends Frame{

	public static void main(String[] args) {




		Main fraim = new Main();
		fraim.setLayout(new FlowLayout());
		fraim.setSize(400, 300);

		fraim.setLocationRelativeTo(null);
		fraim.setVisible(true);


	}


	public void paint (Graphics g){

		g.setColor(Color.blue);
		g.drawLine( 0, 0, 400, 300);
		g.drawLine( 0, 300, 400, 0);




	}

}
