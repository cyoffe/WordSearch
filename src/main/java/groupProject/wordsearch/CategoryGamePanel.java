package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CategoryGamePanel extends JPanel implements ActionListener {

	private JButton cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9,
			cat10;
	private JLabel instructions;
	private JButton mainMenu;
	private WordSearchGUI wordSearchGUI;
	private WordSearch wordSearch;

	public CategoryGamePanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setBackground(new Color(0, 7, 28));
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5, 2, 20, 20));
		buttons.setBackground(new Color(0, 7, 28));

		this.wordSearchGUI = wordSearchGUI;

		cat1 = new JButton("HOUSE");
		cat1.setBorder(BorderFactory.createRaisedBevelBorder());
		cat1.setBackground(new Color(100, 139, 255));

		cat2 = new JButton("SOUND");
		cat2.setBorder(BorderFactory.createRaisedBevelBorder());
		cat2.setBackground(new Color(100, 139, 255));
		cat3 = new JButton("FRUIT");
		cat3.setBorder(BorderFactory.createRaisedBevelBorder());
		cat3.setBackground(new Color(158, 182, 255));
		cat4 = new JButton("CARS");
		cat4.setBorder(BorderFactory.createRaisedBevelBorder());
		cat4.setBackground(new Color(158, 182, 255));
		cat5 = new JButton("NUMBERS");
		cat5.setBorder(BorderFactory.createRaisedBevelBorder());
		cat5.setBackground(new Color(193, 209, 255));
		cat6 = new JButton("TECHNOLOGY");
		cat6.setBorder(BorderFactory.createRaisedBevelBorder());
		cat6.setBackground(new Color(193, 209, 255));
		cat7 = new JButton("SPORTS");
		cat7.setBorder(BorderFactory.createRaisedBevelBorder());
		cat7.setBackground(new Color(225, 233, 255));
		cat8 = new JButton("POLITICS");
		cat8.setBorder(BorderFactory.createRaisedBevelBorder());
		cat8.setBackground(new Color(225, 233, 255));
		cat9 = new JButton("WEATHER");
		cat9.setBorder(BorderFactory.createRaisedBevelBorder());
		cat9.setBackground(new Color(246, 248, 255));
		cat10 = new JButton("MEDICAL");
		cat10.setBorder(BorderFactory.createRaisedBevelBorder());
		cat10.setBackground(new Color(246, 248, 255));

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
		heading.setBackground(new Color(0, 7, 28));
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.WHITE));

		instructions = new JLabel("Choose a Category", JLabel.CENTER);
		instructions.setFont(new Font("Arial Black", Font.PLAIN, 50));
		instructions.setForeground(new Color(0, 63, 255));

		mainMenu = new JButton("MAIN MENU");
		mainMenu.setBorder(BorderFactory.createRaisedBevelBorder());
		mainMenu.setBackground(new Color(0, 63, 255));
		mainMenu.setForeground(Color.WHITE);
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

		ApiThread api = new ApiThread(category, wordSearchGUI);
		api.start();

	}

	public WordSearch getWordSearch() {
		return wordSearch;
	}

}
