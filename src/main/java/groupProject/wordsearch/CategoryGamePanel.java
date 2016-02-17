package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class CategoryGamePanel extends JPanel implements ActionListener {

	private JButton cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9,
			cat10;
	private JLabel instructions;
	private JButton mainMenu;
	private ImageIcon image;
	private int imgWidth;
	private int imgHeight;
	private WordSearchGUI wordSearchGUI;
	private WordSearch wordSearch;

	public CategoryGamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5, 2, 20, 20));

		this.wordSearchGUI = wordSearchGUI;

		cat1 = new JButton("HOUSE");
		cat1.setBorder(BorderFactory.createRaisedBevelBorder());
		cat1.setBackground(Color.RED);

		cat2 = new JButton("SOUND");
		cat3 = new JButton("FRUIT");
		cat4 = new JButton("CARS");
		cat5 = new JButton("NUMBERS");
		cat6 = new JButton("COMPUTERS");
		cat7 = new JButton("SPORTS");
		cat8 = new JButton("POLITICS");
		cat9 = new JButton("WEATHER");
		cat10 = new JButton("MEDICAL");

		cat1.addActionListener(this);
		cat2.addActionListener(this);
		cat3.addActionListener(this);
		cat4.addActionListener(this);
		cat5.addActionListener(this);
		cat6.addActionListener(this);
		cat7.addActionListener(this);
		cat8.addActionListener(this);
		cat9.addActionListener(this);
		cat10.addActionListener(this);

		buttons.add(cat1);
		buttons.add(cat2);
		buttons.add(cat3);
		buttons.add(cat4);
		buttons.add(cat5);
		buttons.add(cat6);
		buttons.add(cat7);
		buttons.add(cat8);
		buttons.add(cat9);
		buttons.add(cat10);

		JPanel heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.BLACK));

		instructions = new JLabel("Choose a Category", JLabel.CENTER);
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
		add(buttons, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		String category = source.getText();

		TestApi api = new TestApi(category);
		String[] words = api.getApi();
		WordSearch search = new WordSearch(words);
		wordSearchGUI.getGamePanel().setGame(words, search.getGrid());
		wordSearchGUI.getCategoryPanel().setVisible(false);
		wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(), "Game");
	}

	public WordSearch getWordSearch() {
		return wordSearch;
	}

}
