package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel implements ActionListener {

	private JButton playCustom, playCategory, quit;
	private WordSearchGUI wordSearchGUI;
	private ImageIcon image;

	public Menu(final WordSearchGUI wordSearchGUI) {
		this.wordSearchGUI = wordSearchGUI;
		setBorder(new EmptyBorder(50,50,50,50));
		setLayout(new BorderLayout());

		Title t = new Title();
		

		/*
		 * JPanel title = new JPanel(); title.setLayout(new GridLayout(2, 1));
		 * title.setFont(new Font("Arial", Font.BOLD, 50));
		 * title.setForeground(Color.GRAY);
		 * 
		 * JLabel word = new JLabel("WORD"); word.setFont(new Font("Arial",
		 * Font.BOLD, 100)); word.setHorizontalAlignment(JLabel.CENTER);
		 * word.setVerticalAlignment(JLabel.CENTER);
		 * 
		 * JLabel search = new JLabel("SEARCH"); search.setFont(new
		 * Font("Arial", Font.BOLD, 85));
		 * search.setHorizontalAlignment(JLabel.CENTER);
		 * search.setVerticalAlignment(JLabel.CENTER);
		 * 
		 * title.add(word); title.add(search);
		 */

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

		JPanel menu = new JPanel();
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
