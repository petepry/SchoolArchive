/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad2;

import java.awt.Dimension;
import javax.swing.*;




public class Main {

	public static void main(String[] args) {
		String path = args[0];
		int czos = Integer.parseInt(args[1]);
		int fSize = Integer.parseInt(args[2]);

		JFrame frame = new JFrame();
		JPanel cosmicPanel = new CosmicPanel(fSize, czos);
		frame.getContentPane().add(cosmicPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		@SuppressWarnings("unused")
		int errCode = ((CosmicPanel) cosmicPanel).setNpaint(path, frame);
		cosmicPanel.setPreferredSize(new Dimension (300, 200));
		cosmicPanel.repaint();
		frame.pack();

	}


}
