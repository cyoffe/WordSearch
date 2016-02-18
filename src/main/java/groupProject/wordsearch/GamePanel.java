package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel {

	private JLabel instructions;

	private JPanel heading, gridPanel, grid;
	private Cell[][] cells;
	private HashMap<String, Boolean> words;
	private Stack<Cell> cellsClicked;
	private WordList listPanel;
	private JButton mainMenu;
	private StringBuilder lettersSelected;
	private int startX, startY, endX, endY, wordsLeft;
	private String category;

	public GamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		//new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		cellsClicked = new Stack<Cell>();
		category = "Word Search";
		gridPanel = new JPanel();
		gridPanel.setLayout(new BorderLayout());
		gridPanel.setBorder(new LineBorder(Color.BLUE, 3));
		grid = new JPanel();
		grid.setLayout(new GridLayout(20, 20));
		Dimension di = new Dimension(3000, 3000);
		grid.setMinimumSize(di);
		grid.setPreferredSize(di);
		grid.setMaximumSize(di);
		gridPanel.add(grid, BorderLayout.CENTER);

		listPanel = new WordList(this);

		heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.BLACK));

		instructions = new JLabel(category.toUpperCase(), JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 50));

		mainMenu = new JButton("MAIN MENU");
		mainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				wordSearchGUI.getCategoryPanel().setVisible(false);
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Menu");
			}

		});

		heading.add(instructions, BorderLayout.CENTER);
		heading.add(mainMenu, BorderLayout.WEST);

		add(heading, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		add(listPanel, BorderLayout.EAST);

	}

	public void setGame(String[] words, Cell[][] board) {
		this.words = new HashMap<String, Boolean>();
		grid.removeAll();
		wordsLeft = words.length;
		listPanel.getModel().clear();
		for (String w : words) {
			listPanel.getModel().addElement(w);
			this.words.put(w, false);
		}

		cells = board;
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 20; col++) {
				cells[row][col].setDimension(new Dimension(
						grid.getWidth() / 20, grid.getHeight() / 20));
				grid.add(cells[row][col], JButton.CENTER);
			}

			grid.addMouseListener(new MouseListener() {

				public void mousePressed(MouseEvent e) {
					startX = 19 - (e.getX() / (cells[0][0].getWidth()));
					startY = 19 - (e.getY() / (cells[0][0].getHeight()));

				}

				public void mouseReleased(MouseEvent e) {
					endX = 19 - (e.getX() / (cells[0][0].getWidth()));
					endY = 19 - (e.getY() / (cells[0][0].getHeight()));

					checkWord();

				}

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

		}
	}

	// checks if the letters selected are a word in the list
	public void checkWord() {
		lettersSelected = new StringBuilder();
		int distance;
		char letter;

		// determine if word is horizontal, vertical, or diagonal
		// and add letters to StringBuffer

		// vertical word downwards
		if (startX == endX && startY < endY) {
			for (int i = startY; i <= endY; ++i) {
				lettersSelected.append(cells[i][startX].getLetter());
				cellsClicked.push(cells[i][startX]);
				repaint();

			}
			System.out.println(lettersSelected.toString());
		}
		// vertical word upwards
		else if (startX == endX && startY > endY) {
			for (int i = startY; i >= endY; --i) {
				lettersSelected.append(cells[i][startX].getLetter());
				cellsClicked.push(cells[i][startX]);

			}
			System.out.println(lettersSelected.toString());
		}
		// horizontal word left->right
		else if (startY == endY && startX < endX) {
			for (int i = startX; i <= endX; ++i) {
				lettersSelected.append(cells[startY][i].getLetter());
				cellsClicked.push(cells[startY][i]);

			}
			System.out.println(lettersSelected.toString());
		}
		// horizontal word right->left
		else if (startY == endY && startX > endX) {
			for (int i = startX; i >= endX; --i) {
				lettersSelected.append(cells[startY][i].getLetter());
				cellsClicked.push(cells[startY][i]);

			}
			System.out.println(lettersSelected.toString());
		}
		// \ diagonal upper left to lower right
		else if (endX - startX == endY - startY && startX < endX) {
			for (int i = 0; i <= (endX - startX); ++i) {
				lettersSelected.append(cells[startY + i][startX + i]
						.getLetter());
				cellsClicked.push(cells[startY + i][startX + i]);

			}
			System.out.println(lettersSelected.toString());
		}
		// \ diagonal lower right to upper left
		else if (endX - startX == endY - startY && startX > endX) {
			for (int i = 0; i <= (startX - endX); ++i) {
				lettersSelected.append(cells[startY - i][startX - i]
						.getLetter());
				cellsClicked.push(cells[startY - i][startX - i]);

			}
			System.out.println(lettersSelected.toString());
		}

		/*
		 * // check if it's a word for (int i = 0; i < words.length; i++) { if
		 * (lettersSelected.toString().equalsIgnoreCase(words[i])) {
		 * System.out.println(lettersSelected.toString());
		 * lettersSelected.setLength(0); // clears stringbuffer
		 * 
		 * return i; } }
		 */
		checkWordList(lettersSelected.toString());
		lettersSelected.setLength(0); // clears stringbuffer
	}

	public void checkWordList(String wordChecking) {
		if (words.containsKey(wordChecking.toLowerCase())
				&& !words.get(wordChecking.toLowerCase())) {
			highlightWord(wordChecking);
			wordsLeft--;

		} else {
			wordChecking = flip(wordChecking);
			if (words.containsKey(wordChecking.toLowerCase())
					&& !words.get(wordChecking.toLowerCase())) {
				highlightWord(wordChecking);
				wordsLeft--;

			}

		}
		wordChecking = "";
		cellsClicked.clear();
		repaint();

		// check if finished game
		// checkIfFinished();

	}

	private void checkIfFinished() {
		if (wordsLeft == 0) {
			JOptionPane.showMessageDialog(this, "Winner!");
		}

	}

	private void highlightWord(String wordChecking) {
		while (!cellsClicked.isEmpty()) {
			Cell c = cellsClicked.pop();
			c.highlight();
		}

		int index = listPanel.getList().getNextMatch(wordChecking, 0, null);

		listPanel.getList().setSelectedValue(
				listPanel.getModel().getElementAt(index), true);

		listPanel.getList().setSelectionBackground(null);

		repaint();

	}

	private String flip(String word) {
		StringBuilder reverse = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse.append(word.charAt(i));
		}
		return reverse.toString();
	}
	
	public void setCategory(String name){
		category = name;
		repaint();
	}

}
