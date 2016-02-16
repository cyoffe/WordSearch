package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

	private WordSearch wordSearch;
	private JList<String> list;
	private JLabel instructions;
	private JButton mainMenu;
	public GamePanel(final WordSearchGUI wordSearchGUI, String[] words) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		
		wordSearch = new WordSearch(words);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(String w : words){
			model.addElement(w);			
		}
		
		list = new JList<String>(model);
		
		JPanel heading = new JPanel();
		heading.setLayout(new BorderLayout());
		heading.setBorder(new LineBorder(Color.BLACK));
		
		instructions = new JLabel("Word Search", JLabel.CENTER);
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
		add(list, BorderLayout.EAST);
		
		
	}
	
}
