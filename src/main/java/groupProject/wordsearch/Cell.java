package groupProject.wordsearch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Cell extends JButton implements ActionListener {
	private char letter;
	private boolean clicked;
	private int row;
	private int col;

	public Cell(int row, int col) {
		this(null, row, col);
	}

	public Cell(Character letter, int row, int col) {

		if (letter == null) {
			letter = ' ';
		} else {
			this.letter = letter;
		}
		this.clicked = false;
		this.setText(String.valueOf(letter));
		this.setFont(new Font("Arial", Font.BOLD, 13));
		this.setBackground(null);
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);

	}

	public char getLetter() {
		return letter;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setDimension(Dimension d) {
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
	}

	public void actionPerformed(ActionEvent e) {
		Object source= e.getSource();
		((JComponent) source).setBackground(Color.YELLOW);
		
	}

}
