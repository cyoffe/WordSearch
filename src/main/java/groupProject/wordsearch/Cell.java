package groupProject.wordsearch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class Cell extends JLabel {
	private char letter;
	private boolean highlighted;

	public Cell(Character letter) {

		if (letter == null) {
			letter = ' ';
		} else {
			this.letter = letter;
		}
		highlighted = false;
		setText(String.valueOf(letter));
		setFont(new Font("Arial", Font.BOLD, 13));
		setOpaque(true);
		setBorder(null);
		setBackground(Color.WHITE);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);

	}

	public char getLetter() {
		return letter;
	}

	public boolean isHighlighted() {
		return highlighted;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setDimension(Dimension d) {
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
	}

	public void highlight() {
		this.setBackground(Color.YELLOW);
		this.highlighted = true;

	}

}
