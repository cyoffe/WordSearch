package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

	public GamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));

		/*
		 * if (words != null) { for (String w : this.words) {
		 * model.addElement(w); } this.wordSearch = new WordSearch(); } else {
		 * wordSearch = new WordSearch(); }
		 */

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

	/*
	 * public void setWords(String[] words) { //model.clear(); for (String w :
	 * words) { model.addElement(w); } this.validate(); }
	 */

	public void setGame(String[] words, Cell[][] board) {
		grid.removeAll();
		for (String w : words) {
			model.addElement(w);
		}
		
		cells = board;
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 20; col++) {
				cells[row][col].setDimension(new Dimension(grid.getWidth() / 20,
						grid.getHeight() / 20));
				grid.add(cells[row][col], JButton.CENTER);
				
				//JLabel l = new JLabel(String.valueOf(board[row][col]
				//	.getLetter()), JLabel.CENTER);

			}
		}
		

	}

}
