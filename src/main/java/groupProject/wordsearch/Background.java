package groupProject.wordsearch;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Background extends JComponent {
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		Image image = new ImageIcon("watercolorBackground.jpg").getImage();
		g2.drawImage(image, 0, 0, null);
		
		
	
	}
}
