package yoffe.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomGamePanel extends JPanel {
	private JList<String> list;
	private JTextField word;
	private JLabel instructions;
	private JButton addBtn, removeBtn, playGame;
	private DefaultListModel<String> model;
	private int count = 0;
	private JButton mainMenu;

	public CustomGamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createRaisedBevelBorder());

		instructions = new JLabel("Enter 10 Words");

		JPanel listPanel = new JPanel();
		listPanel.setSize(new Dimension(100, 00));
		listPanel.setBackground(Color.ORANGE);
		listPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		model = new DefaultListModel<String>();
		list = new JList<String>(model);

		listPanel.add(list);

		JPanel words = new JPanel();
		words.setLayout(new GridLayout(4, 1, 5, 5));
		word = new JTextField();

		addBtn = new JButton("ADD WORD");
		addBtn.requestFocus();
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() < 10) {
					model.addElement(word.getText());
					word.setText("");
					word.requestFocus();
					list.repaint();

				} else {
					word.setText("");

				}

			}

		});

		removeBtn = new JButton("REMOVE WORD");
		removeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() > 0) {
					int index = list.getSelectedIndex();
					model.remove(index);
					list.repaint();
				}
			}

		});

		playGame = new JButton("PLAY GAME");
		playGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Game");

			}

		});

		mainMenu = new JButton("MAIN MENU");
		mainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Menu");

			}

		});

		words.add(word);
		words.add(addBtn);
		words.add(removeBtn);
		words.add(playGame);
		words.add(mainMenu);

		add(words, BorderLayout.EAST);
		add(listPanel, BorderLayout.CENTER);
		add(instructions, BorderLayout.NORTH);
	}
}
