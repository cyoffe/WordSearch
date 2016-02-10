package yoffe.wordsearch;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel implements ActionListener {

	private JButton playCustom, playCategory, quit;
	private WordSearchGUI wordSearchGUI;

	public Menu(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout());

		this.wordSearchGUI = wordSearchGUI;

		playCustom = new JButton("CREATE YOUR OWN GAME");
		playCustom.addActionListener(this);

		playCategory = new JButton("PLAY BY CATEGORY");
		playCategory.addActionListener(this);

		quit = new JButton("EXIT");
		quit.addActionListener(this);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3, 1, 5, 5));
		buttons.add(playCategory);
		buttons.add(playCustom);
		buttons.add(quit);

		this.setBorder(new EmptyBorder(100, 300, 100, 300));
		this.add(buttons, BorderLayout.CENTER);

	}

	public JButton getPlayCustom() {
		return playCustom;
	}

	public JButton getPlayCategory() {
		return playCategory;
	}

	public JButton getQuit() {
		return quit;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		CardLayout layout = wordSearchGUI.getCardLayout();
		if (source == playCustom) {
			layout.show(wordSearchGUI.getCard(), "Custom Puzzle");
		}
		if (source == playCategory) {
			layout.show(wordSearchGUI.getCard(), "Category Puzzle");
		}
		if (source == quit) {
			wordSearchGUI.dispose();
		}

	}

}
