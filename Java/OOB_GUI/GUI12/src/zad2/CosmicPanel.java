package zad2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CosmicPanel extends JPanel{
	
	private Image uobrazek;
	private int fontSize;
	private int time;
	private int secretCode;

	public CosmicPanel(int fontSize, int time){

		this.setLayout(new FlowLayout());
		this.fontSize = fontSize;
		this.time = time;

	}

	public int setNpaint(String path, JFrame frame){
		secretCode = -1;
		Path catalog = Paths.get(path);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(catalog, "*.{jpg,png,gif}")) {
			for (Path wpis : stream) {
				secretCode = 0;
				Image uobrazek = ImageIO.read(wpis.toFile());
				setImage(uobrazek);
				frame.pack();
				Thread.sleep(this.time * 1000);
				secretCode = 1;
			}
		} catch (IOException x) {
			return -1;
		} catch (InterruptedException e) {
			return -1;
		}

		return secretCode;

	}

	public void setImage(Image image){
		this.uobrazek = image;
		this.setPreferredSize(new Dimension(uobrazek.getWidth(this), uobrazek.getHeight(this)));
		this.repaint();

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (secretCode == 0)
			g.drawImage(uobrazek, 0, 0, getWidth(), getHeight(), null);
		else {
			String errMsg = "unknown error";
			switch (secretCode) {
			case -1:
				errMsg = "Brak obrazka";
				break;
			case 1:
				errMsg = "Koniec prezentacji";
				break;
			default:
				break;
			}
			
			Font itsFont = g.getFont();
			Font finalFont = itsFont.deriveFont((float)fontSize);
			g.setFont(finalFont);
			Graphics2D g2d = (Graphics2D) g;
			FontMetrics fm = g2d.getFontMetrics();
			Rectangle2D r = fm.getStringBounds(errMsg, g2d);
			g.drawString(errMsg, ((getWidth() - (int) r.getWidth()) / 2), (getHeight() - (int) r.getHeight()) / 2 + fm.getAscent());
		}
	}









}
