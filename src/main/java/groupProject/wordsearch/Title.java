package groupProject.wordsearch;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title extends JPanel {

	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial", Font.BOLD, 85));
		g2.drawString("WORD", 65, 150);
		
		g2.drawString("SEARCH", 20, 250);
		
		
	
	}
	
	
}
