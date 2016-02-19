package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CustomGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
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
		setBackground(new Color(0, 89, 66));
		count = 0;
		JPanel heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBackground(getBackground());
		heading.setBorder(new LineBorder(Color.WHITE));

		instructions = new JLabel("Enter 15 Words", JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 50));
		instructions.setForeground(new Color(100, 255, 216));

		mainMenu = new JButton("MAIN MENU");
		mainMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mainMenu.setBackground(new Color(100, 255, 216));
		mainMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				list.setModel(model = new DefaultListModel<String>());
				word.setText("");
				count = 0;
				wordSearchGUI.revalidate();
				wordSearchGUI.repaint();
				wordSearchGUI.getCustomPanel().setVisible(false);
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Menu");

			}

		});

		heading.add(instructions, BorderLayout.CENTER);
		heading.add(mainMenu, BorderLayout.WEST);

		JPanel listPanel = new JPanel();
		listPanel.setSize(new Dimension(100, 100));
		listPanel.setBorder(new LineBorder(Color.WHITE, 3));
		listPanel.setBackground(new Color(246, 255, 252));

		model = new DefaultListModel<String>();
		wordList = new String[15];

		list = new JList<String>(model);
		list.setBackground(listPanel.getBackground());
		list.setCellRenderer(new ListCellRenderer<String>() {

			public Component getListCellRendererComponent(JList list,
					String value, int index, boolean isSelected,
					boolean hasFocus) {
				JLabel label = new JLabel(value);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setFont(new Font("Arial", Font.BOLD, 18));
				return label;
			}

		});

		listPanel.add(list);

		JPanel words = new JPanel();
		words.setLayout(new GridLayout(3, 1, 5, 5));
		word = new JTextField();
		word.requestFocus();
		word.setBorder(null);
		word.setBackground(new Color(158, 255, 230));

		addBtn = new JButton("ADD");
		addBtn.requestFocus();
		addBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		addBtn.setBackground(new Color(193, 255, 239));
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() < 15) {
					if (!word.getText().trim().equals("")) {
						if (!model.contains(word.getText())) {
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

				}

				word.setText("");
				word.requestFocus();
				list.repaint();
				notWord = false;

			}

		});

		removeBtn = new JButton("REMOVE");
		removeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		removeBtn.setBackground(new Color(193, 255, 239));
		removeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (model.size() > 0) {
					int index = list.getSelectedIndex();
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
		playGame.setBackground(new Color(225, 255, 247));
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

	public void setModel(DefaultListModel<String> m) {
		model = m;
		list.setModel(model);
		word.setText("");
		list.repaint();

	}
}
