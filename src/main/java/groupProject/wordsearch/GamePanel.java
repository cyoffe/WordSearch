package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel instructions;

	private JPanel heading, gridPanel, grid;
	private Cell[][] cells;
	private ArrayList<String> words;
	private Stack<Cell> cellsClicked;
	private WordList listPanel;
	private JButton mainMenu;
	private StringBuilder lettersSelected;
	private int startX, startY, endX, endY;
	private String instruction;

	private WordSearchGUI wordSearchGUI;

	public GamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setBackground(new Color(17, 0, 28));

		this.wordSearchGUI = wordSearchGUI;
		cellsClicked = new Stack<Cell>();
		instruction = "CLICK AND DRAG TO SELECT A WORD";
		gridPanel = new JPanel();
		gridPanel.setLayout(new BorderLayout());
		gridPanel.setBorder(new LineBorder(Color.WHITE, 3));

		grid = new JPanel();
		grid.setBackground(new Color(232, 193, 255));
		grid.setLayout(new GridLayout(20, 20));
		Dimension di = new Dimension(3000, 3000);
		grid.setMinimumSize(di);
		grid.setPreferredSize(di);
		grid.setMaximumSize(di);
		gridPanel.add(grid, BorderLayout.CENTER);

		listPanel = new WordList(this);

		Dimension d = new Dimension(this.getWidth(), 75);
		heading = new JPanel();
		heading.setPreferredSize(d);
		heading.setMaximumSize(d);
		heading.setMinimumSize(d);
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.WHITE));
		heading.setBackground(new Color(17, 0, 28));

		instructions = new JLabel(instruction, JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 25));
		instructions.setForeground(new Color(197, 100, 255));



		mainMenu = new JButton("MAIN MENU");
		mainMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mainMenu.setBackground(new Color(197, 100, 255));
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
		this.words = new ArrayList<String>();
		grid.removeAll();
		listPanel.getModel().clear();
		for (String w : words) {
			listPanel.getModel().addElement(w);
			this.words.add(w);
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

				}

				public void mouseEntered(MouseEvent e) {

				}

				public void mouseExited(MouseEvent e) {

				}

			});

		}
	}

	// checks if the letters selected are a word in the list
	public void checkWord() {
		lettersSelected = new StringBuilder();

		// determine if word is horizontal, vertical, or diagonal
		// and add letters to StringBuffer

		// vertical word downwards
		if (startX == endX && startY < endY) {
			for (int i = startY; i <= endY; ++i) {
				lettersSelected.append(cells[i][startX].getLetter());
				cellsClicked.push(cells[i][startX]);
				repaint();

			}

		}
		// vertical word upwards
		else if (startX == endX && startY > endY) {
			for (int i = startY; i >= endY; --i) {
				lettersSelected.append(cells[i][startX].getLetter());
				cellsClicked.push(cells[i][startX]);

			}

		}
		// horizontal word left->right
		else if (startY == endY && startX < endX) {
			for (int i = startX; i <= endX; ++i) {
				lettersSelected.append(cells[startY][i].getLetter());
				cellsClicked.push(cells[startY][i]);

			}

		}
		// horizontal word right->left
		else if (startY == endY && startX > endX) {
			for (int i = startX; i >= endX; --i) {
				lettersSelected.append(cells[startY][i].getLetter());
				cellsClicked.push(cells[startY][i]);

			}

		}
		// \ diagonal upper left to lower right
		else if (endX - startX == endY - startY && startX < endX) {
			for (int i = 0; i <= (endX - startX); ++i) {
				lettersSelected.append(cells[startY + i][startX + i]
						.getLetter());
				cellsClicked.push(cells[startY + i][startX + i]);

			}

		}
		// \ diagonal lower right to upper left
		else if (endX - startX == endY - startY && startX > endX) {
			for (int i = 0; i <= (startX - endX); ++i) {
				lettersSelected.append(cells[startY - i][startX - i]
						.getLetter());
				cellsClicked.push(cells[startY - i][startX - i]);

			}

		}

		checkWordList(lettersSelected.toString().toLowerCase());
		lettersSelected.setLength(0); // clears stringbuffer

		// check if finished game
		checkIfFinished();

	}

	public void checkWordList(String wordChecking) {
		if (words.contains(wordChecking)) {
			highlightWord(wordChecking);
			words.remove(wordChecking);
			System.out.print("words left:" + words.size());
		} else {
			wordChecking = flip(wordChecking);
			if (words.contains(wordChecking)) {
				highlightWord(wordChecking);
				words.remove(wordChecking);
				System.out.print("words left:" + words.size());
			}

		}
		// wordChecking = "";
		cellsClicked.clear();
		repaint();
	}

	private void checkIfFinished() {
		if (words.size() == 0) {
			wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
					"Finished");
		}

	}

	private void highlightWord(String wordChecking) {
		while (!cellsClicked.isEmpty()) {
			Cell c = cellsClicked.pop();
			c.highlight();
		}

		for (int index = 0; index < listPanel.getList().getModel().getSize(); index++) {
			String element = listPanel.getList().getModel().getElementAt(index);
			if (element.equalsIgnoreCase(wordChecking)
					|| element.equalsIgnoreCase(flip(wordChecking))) {
				listPanel.getList().setSelectedValue(
						listPanel.getModel().getElementAt(index), true);
				break;

			}
		}

		// int index = listPanel.getList().getNextMatch(wordChecking, 0, null);

		// listPanel.getList().setSelectedValue(
		// listPanel.getModel().getElementAt(index), true);

		listPanel.getList().setSelectionBackground(null);
		// --wordsLeft;
		repaint();

	}

	private String flip(String word) {
		StringBuilder reverse = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse.append(word.charAt(i));
		}
		return reverse.toString();
	}


}
