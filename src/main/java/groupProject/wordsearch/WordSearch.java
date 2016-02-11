package groupProject.wordsearch;

import java.util.Random;

public class WordSearch {
	char[][] letters = new char[20][20];
	String[] words;

	public WordSearch(String[] words) {
		this.words = words;
		for(int i = 0; i < words.length; i++){
			words[i] = words[i].toUpperCase();
		}


		// fill a 20x20 [][] with ' '
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				this.letters[i][j] = ' ';
			}
		}

	}

	public char[][] getGrid() {		
		//keep a backup copy of the grid in case a word doesn't fit
		char[][] backup = new char[20][20];

		//do the following for all the words in the list
		for(int i = 0; i < 20; i++){	

			//try many times to add this particular word
			for(int tries = 0; tries < 100; tries++) {

				//ensure that backup[][] and letters[][] are the same
				for(int k = 0; k < 20; k++){
					for(int j = 0; j < 20; j++){
						backup[k][j] = letters[k][j];
					}
				}


				Random r = new Random();

				//randomly chooses if forward or backward
				int orientation = r.nextInt(2); // 0 = Forwards,   1 = Backwards
				if(orientation == 1){
					words[i] = flip(words[i]);
				}

				//randomly chooses the direction
				int direction   = r.nextInt(3); // 0 = Horizontal, 1 = Vertical,  2 = Diagonal

				//randomly choose a starting box, 
				//ensuring that the word will not exceed the dimensions of the board
				int row	= r.nextInt(20 - words[i].length());
				int col	= r.nextInt(20 - words[i].length());

				//try fitting in the word at this spot by testing each letter
				for(int j = 0; j < words[i].length(); j++) {

					//if this spot is available, add the next letter
					//and advance position in the grid
					if(backup[row][col] == ' ' || backup[row][col] == words[i].charAt(j)) {
						letters[row][col] = words[i].charAt(j);

						if(direction == 0){
							col++;
						}
						else if(direction == 1) {
							row++;
						}
						else {
							col++; 
							row++; 
						}
					} 
					//if the letter cannot go here, the word cannot go here
					//need to take away all letters added from this word
					else {
						for(int k = j; k > 0; k--) {
							if(direction == 0){
								col--;
							}
							else if(direction == 1){
								row--;
							}
							else { 
								col--; 
								row--; 
							}

							letters[row][col] = backup[row][col]; 
						}
						break;	//break out of this try, go to next try
					}
				}

				//how deal if word doesn't fit anywhere?
				//right now, program will just not include it
				//if(--i > 0) return true;
			}//end tries for this word, go to next word
			//return false;
		}//went through all words in the list
		
		//fill empty spaces
		fill();
		return this.letters;
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
