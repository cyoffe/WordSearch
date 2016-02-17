package groupProject.wordsearch;

import java.awt.Color;

public class Cell {
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

}
