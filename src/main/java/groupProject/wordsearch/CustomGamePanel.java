package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CustomGamePanel extends JPanel {
	private JList<String> list;
	private JTextField word;
	private JLabel instructions;
	private JButton addBtn, removeBtn, playGame;
	private DefaultListModel<String> model;
	private String[] wordList;
	private int count;
	private JButton mainMenu;
	private boolean notWord = false;

	public CustomGamePanel(final WordSearchGUI wordSearchGUI) {

		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));

		JPanel heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBackground(getBackground());
		heading.setBorder(new LineBorder(Color.BLACK));
		
		instructions = new JLabel("Enter 15 Words", JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 50));
		instructions.setForeground(Color.ORANGE);

		mainMenu = new JButton("MAIN MENU");
		mainMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mainMenu.setBackground(Color.RED);
		mainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				wordSearchGUI.getCustomPanel().setVisible(false);
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Menu");

			}

		});

		heading.add(instructions, BorderLayout.CENTER);
		heading.add(mainMenu, BorderLayout.WEST);

		JPanel listPanel = new JPanel();
		listPanel.setSize(new Dimension(100, 100));
		// listPanel.setBackground(Color.ORANGE);
		listPanel.setBorder(new LineBorder(Color.BLUE, 3));
		// listPanel.setBackground(getBackground());

		model = new DefaultListModel<String>();
		wordList = new String[15];
		list = new JList<String>(model);
		list.setFont(new Font("Arial", Font.BOLD, 18));
		list.setBackground(null);

		listPanel.add(list);

		JPanel words = new JPanel();
		words.setLayout(new GridLayout(3, 1, 5, 5));
		word = new JTextField();
		word.requestFocus();

		addBtn = new JButton("ADD");
		addBtn.requestFocus();
		addBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		addBtn.setBackground(Color.ORANGE);
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() < 15) {
					if (!word.getText().trim().equals("")) {
						char[] letters = word.getText().toCharArray();
						for (Character c : letters) {
							if (!Character.isLetter(c)) {
								notWord = true;
								break;
							}
						}
						if (!notWord) {
							model.addElement(word.getText());
							wordList[count++] = word.getText();

						}

					}

				}
				word.setText("");
				word.requestFocus();
				list.repaint();

			}

		});

		removeBtn = new JButton("REMOVE");
		removeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		removeBtn.setBackground(Color.ORANGE);
		removeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() > 0) {
					int index = list.getSelectedIndex();
					// list.remove(index);
					model.remove(index);
					for (int i = index; i < wordList.length - 1; i++) {
						wordList[i] = wordList[i + 1];
					}
					count--;
					list.repaint();
				}
			}

		});

		playGame = new JButton("PLAY GAME");
		playGame.setBorder(BorderFactory.createRaisedBevelBorder());
		playGame.setBackground(Color.ORANGE);
		playGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				WordSearch search = new WordSearch(wordList);
				wordSearchGUI.getGamePanel()
						.setGame(wordList, search.getGrid());
				wordSearchGUI.getCategoryPanel().setVisible(false);
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Game");

			}

		});

		JPanel addRemove = new JPanel();
		addRemove.setBackground(getBackground());
		addRemove.add(addBtn);
		addRemove.add(removeBtn);

		words.add(word);
		words.add(addRemove);
		words.add(playGame);

		add(words, BorderLayout.EAST);
		add(listPanel, BorderLayout.CENTER);
		add(heading, BorderLayout.NORTH);

	}
}
