package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel {

	private JList<String> list;
	private JLabel instructions;
	private JButton mainMenu;
	private JPanel heading;
	private JPanel listPanel;
	private DefaultListModel<String> model;
	private JPanel gridPanel;
	private JPanel grid;
	private Cell[][] cells;
	private String[] words;
	private StringBuilder lettersSelected;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public GamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));

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

		listPanel = new JPanel();
		listPanel.setBorder(new LineBorder(Color.BLUE, 3));

		Dimension dimension = new Dimension(150, this.getHeight());
		listPanel.setMinimumSize(dimension);
		listPanel.setPreferredSize(dimension);
		listPanel.setMaximumSize(dimension);

		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setBackground(null);
		listPanel.add(list);

		heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.BLACK));

		instructions = new JLabel("Word Search", JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 50));

		mainMenu = new JButton("MAIN MENU");
		mainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				model.clear();
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
		grid.removeAll();
		this.words = words;
		for (String w : words) {
			model.addElement(w);
		}

		cells = board;
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 20; col++) {

				cells[row][col].setDimension(new Dimension(
						grid.getWidth() / 20, grid.getHeight() / 20));
				grid.add(cells[row][col], JButton.CENTER);
				

			}
		}
		
		grid.addMouseListener(new MouseListener() {

			
			public void mousePressed(MouseEvent e) {
				startX = 19 - (e.getX() / (cells[0][0].getWidth()));
				startY = 19 - (e.getY() / (cells[0][0].getHeight()));
				
			}

			public void mouseReleased(MouseEvent e) {
				endX = 19 - (e.getX() / (cells[0][0].getWidth()));
				endY = 19 - (e.getY() / (cells[0][0].getHeight()));
				
				int index = checkWord();
				

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

	// checks if the letters selected are a word in the list
	// returns the index of the word in the array or -1 if not found
	public int checkWord(){
		lettersSelected = new StringBuilder();
		int distance;
		char letter;
		
		//determine if word is horizontal, vertical, or diagonal
		//and add letters to StringBuffer
		
		
		// vertical word downwards
        if (startX == endX && startY < endY) {
            for (int i = startY; i <= endY; ++i) {
                lettersSelected.append(cells[i][startX].getLetter());
                cells[i][startX].setBackground(Color.YELLOW);
                repaint();
                
            }System.out.println(lettersSelected.toString());
        }
        // vertical word upwards
        else if (startX == endX && startY > endY) {
            for (int i = startY; i >= endY; --i) {
                lettersSelected.append(cells[i][startX].getLetter());
                cells[i][startX].setBackground(Color.YELLOW);
                repaint();
                
            }System.out.println(lettersSelected.toString());
        }
        // horizontal word left->right
        else if (startY == endY && startX < endX) {
            for (int i = startX; i <= endX; ++i) {
            	lettersSelected.append(cells[startY][i].getLetter());
            	cells[startY][i].setBackground(Color.YELLOW);
                repaint();
                
            }System.out.println(lettersSelected.toString());
        }
        // horizontal word right->left
        else if (startY == endY && startX > endX) {
            for (int i = startX; i >= endX; --i) {
                lettersSelected.append(cells[startY][i].getLetter());
                cells[startY][i].setBackground(Color.YELLOW);
                repaint();
                
            }System.out.println(lettersSelected.toString());
        }
        // \ diagonal upper left to lower right
        else if (endX - startX == endY - startY && startX < endX) {
            for (int i = 0; i <= (endX - startX); ++i) {
            	lettersSelected.append(cells[startY + i][startX + i].getLetter());                
                cells[startY + i][startX + i].setBackground(Color.YELLOW);
                repaint();
               

            } System.out.println(lettersSelected.toString());
        }
        // \ diagonal lower right to upper left
        else if (endX - startX == endY - startY && startX > endX) {
            for (int i = 0; i <= (startX - endX); ++i) {
                lettersSelected.append(cells[startY - i][startX - i].getLetter());
                cells[startY - i][startX - i].setBackground(Color.YELLOW);
                repaint();
                
            }System.out.println(lettersSelected.toString());
        }
        else {	// illegal selection = not a line
        	return -1;
        }
        
		
		//check if it's a word
		for(int i = 0; i < words.length; i++){
			if(lettersSelected.toString().equalsIgnoreCase(words[i])){
				System.out.println(lettersSelected.toString());
				lettersSelected.setLength(0); 	//clears stringbuffer
				
				return i;
			}
		}
		lettersSelected.setLength(0);
		return -1;
	}
}
