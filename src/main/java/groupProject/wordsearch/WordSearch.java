package groupProject.wordsearch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;

/*public class WordSearch {
 private Cell[][] letters = new Cell[20][20];
 private String[] words;

 public WordSearch(String[] list) {

 this.words = list;

 if (words == null) {
 fillEmptyBoard();
 } else {
 for (int i = 0; i < list.length; i++) {
 this.words[i] = list[i].toUpperCase();
 }
 this.words = new String[15];
 fillEmptyBoard();

 // keep a backup copy of the grid in case a word doesn't fit
 Cell[][] backup = new Cell[20][20];
 boolean placed = false;
 int tries = 0;
 int lettersPlaced = 0;
 int row;
 int col;

 // do the following for all the words in the list
 for (int i = 0; i < 15; i++) {
 placed = false;
 lettersPlaced = 0;
 tries = 0;

 // while this word is not placed, try many times to add it
 while (!placed && tries < 400) {

 // ensure that backup[][] and letters[][] are the same
 for (int k = 0; k < 20; k++) {
 for (int j = 0; j < 20; j++) {
 backup[k][j] = letters[k][j];
 }
 }

 Random r = new Random();

 // randomly chooses if forward or backward
 int orientation = r.nextInt(2); // 0 = Forwards, 1 =
 // Backwards
 if (orientation == 1) {
 words[i] = flip(words[i]);
 }

 // randomly chooses the direction
 int direction = r.nextInt(3); // 0 = Horizontal, 1 =
 // Vertical,
 // 2 = Diagonal

 // randomly choose a starting box,
 // ensuring that the word will not exceed
 // the dimensions of the board
 row = r.nextInt(19 - words[i].length());
 col = r.nextInt(19 - words[i].length());

 // try fitting in the word at this spot by testing each
 // letter
 for (int letterNum = 0; letterNum < words[i].length(); letterNum++) {

 // if this spot is available, add the next letter
 // and advance position in the grid
 if (backup[row][col].getLetter() == ' '
 || backup[row][col].getLetter() == words[i]
 .charAt(letterNum)) {

 letters[row][col].setLetter(words[i]
 .charAt(letterNum));
 lettersPlaced++;

 if (direction == 0) {
 col++;
 } else if (direction == 1) {
 row++;
 } else {
 col++;
 row++;
 }

 if (lettersPlaced == words[i].length()) {
 placed = true;
 System.out.println(words[i]);
 }
 }

 // if the letter cannot go here, the word cannot go here
 // and need to take away all letters added from this
 // word
 else {
 for (int k = letterNum; letterNum > 0; letterNum--) {
 if (direction == 0) {
 col--;
 } else if (direction == 1) {
 row--;
 } else {
 col--;
 row--;
 }

 letters[row][col] = backup[row][col];

 }
 break;

 }
 }

 // how deal if word doesn't fit anywhere?
 // right now, program will just not include it
 // if(--i > 0) return true;

 tries++;
 }// end while not placed

 }
 }// went through all words in the list

 // fill empty spaces
 // fill();
 }

 private void fillEmptyBoard() {
 // fill a 20x20 [][] with ' '
 for (int i = 0; i < 20; i++) {
 for (int j = 0; j < 20; j++) {
 this.letters[i][j] = new Cell(i, j);
 }
 }

 }

 private String flip(String word) {
 StringBuilder reverse = new StringBuilder();
 for (int i = word.length() - 1; i >= 0; i--) {
 reverse.append(word.charAt(i));
 }
 return reverse.toString();
 }

 private void fill() {
 RandomChar rand = new RandomChar();

 for (int i = 0; i < 20; i++) {
 for (int j = 0; j < 20; j++) {
 if (letters[i][j].getLetter() == ' ') {
 letters[i][j].setLetter(rand.nextChar());
 }
 }
 }
 }

 public String[] getWords() {
 return words;
 }

 public void setWords(String[] list) {
 this.words = list;
 for (int i = 0; i < words.length; i++) {
 words[i] = words[i].toUpperCase();

 }
 }

 public Cell[][] getBoard() {
 return letters;
 }

 }*/

/*public class WordSearch {
 private char[][] letters;
 private String[] words;

 public WordSearch(String[] words) {
 this.words = words;
 letters = new char[20][20];
 for (int i = 0; i < words.length; i++) {
 words[i] = words[i].toUpperCase();
 }

 // fill a 20x20 [][] with ' '
 for (int i = 0; i < 20; i++) {
 for (int j = 0; j < 20; j++) {
 this.letters[i][j] = ' ';
 }
 }

 }

 public void getGrid() {
 // keep a backup copy of the grid in case a word doesn't fit
 char[][] backup = new char[20][20];
 boolean placed = false;
 int tries = 0;
 int lettersPlaced = 0;
 int row;
 int col;

 // do the following for all the words in the list
 for (int i = 0; i < 15; i++) {
 placed = false;
 lettersPlaced = 0;
 tries = 0;

 // while this word is not placed, try many times to add it
 while (!placed && tries < 400) {

 // ensure that backup[][] and letters[][] are the same
 for (int k = 0; k < 20; k++) {
 for (int j = 0; j < 20; j++) {
 backup[k][j] = letters[k][j];
 }
 }

 Random r = new Random();

 // randomly chooses if forward or backward
 int orientation = r.nextInt(2); // 0 = Forwards, 1 = Backwards
 if (orientation == 1) {
 words[i] = flip(words[i]);
 }

 // randomly chooses the direction
 int direction = r.nextInt(3); // 0 = Horizontal, 1 = Vertical,
 // 2 = Diagonal

 // randomly choose a starting box,
 // ensuring that the word will not exceed
 // the dimensions of the board
 row = r.nextInt(20 - words[i].length());
 col = r.nextInt(20 - words[i].length());

 // try fitting in the word at this spot by testing each letter
 for (int letterNum = 0; letterNum < words[i].length(); letterNum++) {

 // if this spot is available, add the next letter
 // and advance position in the grid
 if (backup[row][col] == ' '
 || backup[row][col] == words[i].charAt(letterNum)) {

 letters[row][col] = words[i].charAt(letterNum);
 lettersPlaced++;

 if (direction == 0) {
 col++;
 } else if (direction == 1) {
 row++;
 } else {
 col++;
 row++;
 }

 if (lettersPlaced == words[i].length()) {
 placed = true;
 System.out.println(words[i]);
 }
 }

 // if the letter cannot go here, the word cannot go here
 // and need to take away all letters added from this word
 else {
 for (int k = letterNum; letterNum > 0; letterNum--) {
 if (direction == 0) {
 col--;
 } else if (direction == 1) {
 row--;
 } else {
 col--;
 row--;
 }

 letters[row][col] = backup[row][col];

 }
 break;

 }
 }

 // how deal if word doesn't fit anywhere?
 // right now, program will just not include it
 // if(--i > 0) return true;

 tries++;
 }// end while not placed

 }// went through all words in the list

 // fill empty spaces
 //fill();

 }

 private String flip(String word) {
 StringBuilder reverse = new StringBuilder();
 for (int i = word.length() - 1; i >= 0; i--) {
 reverse.append(word.charAt(i));
 }
 return reverse.toString();
 }

 private void fill() {
 RandomChar rand = new RandomChar();

 for (int i = 0; i < 20; i++) {
 for (int j = 0; j < 20; j++) {
 if (letters[i][j] == ' ') {
 letters[i][j] = rand.nextChar();
 }
 }
 }
 }

 public Cell[][] getBoard() {
 Cell[][] cells = new Cell[20][20];
 for (int i = 0; i < 20; i++) {
 for (int j = 0; j < 20; j++) {
 cells[i][j] = new Cell(letters[i][j], i,j);
 }
 }
 return cells;
 }

 public  char[][] getLetters() {
 return letters;
 }

 }*/

public class WordSearch {
	private char[][] letters = new char[20][20];
	private String[] words;

	public WordSearch(String[] list) {
		words = new String[list.length];
		for (int i = 0; i < this.words.length; i++) {
			this.words[i] = list[i].toUpperCase();
		}

		// fill a 20x20 [][] with ' '
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				this.letters[i][j] = ' ';
			}
		}

	}

	public Cell[][] getGrid() {
		// keep a backup copy of the grid in case a word doesn't fit
		char[][] backup = new char[20][20];
		boolean placed = false;
		int tries = 0;
		int lettersPlaced = 0;
		int row;
		int col;
		Cell[][] cells = new Cell[20][20];

		// do the following for all the words in the list
		for (int i = 0; i < 15; i++) {
			placed = false;
			lettersPlaced = 0;
			tries = 0;

			// while this word is not placed, try many times to add it
			while (!placed && tries < 400) {

				// ensure that backup[][] and letters[][] are the same
				for (int k = 0; k < 20; k++) {
					for (int j = 0; j < 20; j++) {
						backup[k][j] = letters[k][j];
					}
				}

				Random r = new Random();

				// randomly chooses if forward or backward
				int orientation = r.nextInt(2); // 0 = Forwards, 1 = Backwards
				if (orientation == 1) {
					this.words[i] = flip(this.words[i]);
				}

				// randomly chooses the direction
				int direction = r.nextInt(3); // 0 = Horizontal, 1 = Vertical,
												// 2 = Diagonal

				// randomly choose a starting box,
				// ensuring that the word will not exceed
				// the dimensions of the board
				row = r.nextInt(20 - this.words[i].length());
				col = r.nextInt(20 - this.words[i].length());

				// try fitting in the word at this spot by testing each letter
				for (int letterNum = 0; letterNum < this.words[i].length(); letterNum++) {

					// if this spot is available, add the next letter
					// and advance position in the grid
					if (backup[row][col] == ' '
							|| backup[row][col] == this.words[i].charAt(letterNum)) {

						letters[row][col] = this.words[i].charAt(letterNum);
						lettersPlaced++;

						if (direction == 0) {
							col++;
						} else if (direction == 1) {
							row++;
						} else {
							col++;
							row++;
						}

						if (lettersPlaced == this.words[i].length()) {
							placed = true;
							System.out.println(this.words[i]);
						}
					}

					// if the letter cannot go here, the word cannot go here
					// and need to take away all letters added from this word
					else {
						for (int k = letterNum; letterNum > 0; letterNum--) {
							if (direction == 0) {
								col--;
							} else if (direction == 1) {
								row--;
							} else {
								col--;
								row--;
							}

							letters[row][col] = backup[row][col];

						}
						break;

					}
				}

				// how deal if word doesn't fit anywhere?
				// right now, program will just not include it
				// if(--i > 0) return true;

				tries++;
			}// end while not placed

		}// went through all words in the list

		// fill empty spaces
		fill();
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				cells[i][j] = new Cell(letters[i][j], i,j);
				
				//cells[i][j].setBorderPainted( false );
				//cells[i][j].setFocusPainted( false );
			}
		}
		return cells;
	}
	

	private String flip(String word) {
		StringBuilder reverse = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse.append(word.charAt(i));
		}
		return reverse.toString();
	}

	private void fill() {
		RandomChar rand = new RandomChar();

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (letters[i][j] == ' ') {
					letters[i][j] = rand.nextChar();
				}
			}
		}
	}

}
