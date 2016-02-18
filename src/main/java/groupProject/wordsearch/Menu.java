package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton playCustom, playCategory, quit;
	private WordSearchGUI wordSearchGUI;
	public Menu(final WordSearchGUI wordSearchGUI) {
		this.wordSearchGUI = wordSearchGUI;
		setBorder(new EmptyBorder(50,50,50,50));
		setLayout(new BorderLayout());
		setBackground(new Color(255, 211, 204));
		
		Title t = new Title();
		
		playCustom = new JButton("CREATE YOUR OWN GAME");
		playCustom.addActionListener(this);
		playCustom.setBackground(new Color(255, 124, 102));

		playCategory = new JButton("PLAY BY CATEGORY");
		playCategory.addActionListener(this);
		playCategory.setBackground(new Color(255, 103, 76));

		quit = new JButton("EXIT");
		quit.addActionListener(this);
		quit.setBackground(new Color(255, 146, 127));

		JPanel buttons = new JPanel();
		buttons.setBackground(new Color(255, 211, 204));
		buttons.setLayout(new GridLayout(3, 1, 5, 5));
		buttons.add(playCategory);
		buttons.add(playCustom);
		buttons.add(quit);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(255, 211, 204));
		menu.setLayout(new BorderLayout(10, 10));
		menu.add(buttons, BorderLayout.EAST);
		// menu.add(title, BorderLayout.CENTER);
		menu.add(t, BorderLayout.CENTER);

		add(menu, BorderLayout.CENTER);
		
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
			wordSearchGUI.getMenuPanel().setVisible(false);
			layout.show(wordSearchGUI.getCard(), "Custom Puzzle");
			revalidate();
			

		}
		if (source == playCategory) {
			wordSearchGUI.getMenuPanel().setVisible(false);
			layout.show(wordSearchGUI.getCard(), "Category Puzzle");
			revalidate();
		}
		if (source == quit) {
			wordSearchGUI.dispose();
		}

	}

}
