package groupProject.wordsearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Title extends JPanel {

	private static final long serialVersionUID = 1L;

	public Title() {
		setBackground(new Color(255, 211, 204));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Minion Pro", Font.BOLD, 85));
		g2.setColor(new Color(255, 38, 0));
		g2.drawString("#1", 170, 120);
		g2.drawString("WORD", 90, 220);
		g2.drawString("SEARCH", 50, 320);

	}

}
