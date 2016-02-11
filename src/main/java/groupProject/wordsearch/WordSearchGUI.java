package groupProject.wordsearch;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WordSearchGUI extends JFrame {

	private CardLayout cardLayout;
	private Menu menuPanel;
	private JPanel card;
	private CustomGamePanel customPanel;
	private CategoryGamePanel categoryPanel;
	private GamePanel gamePanel;
	private ImageIcon image;

	public WordSearchGUI() {
		setTitle("Word Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setResizable(false);

	
		Background b = new Background();
		add(b);
		validate();
		
		JPanel container = (JPanel) getContentPane();
		container.setBorder(new EmptyBorder(50, 50, 50, 50));

		
		card = new JPanel();
		card.setLayout(cardLayout = new CardLayout());

		menuPanel = new Menu(this);
		customPanel = new CustomGamePanel(this);
		categoryPanel = new CategoryGamePanel(this);
		gamePanel = new GamePanel();

		card.add("Menu", menuPanel);
		card.add("Custom Puzzle", customPanel);
		card.add("Category Puzzle", categoryPanel);
		card.add("Game", gamePanel);
		
		container.add(card);
		cardLayout.show(card, "Menu");
		
		
		
		

	}

	public CustomGamePanel getCustomPanel() {
		return customPanel;
	}

	public CategoryGamePanel getCategoryPanel() {
		return categoryPanel;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public Menu getMenuPanel() {
		return menuPanel;
	}

	public JPanel getCard() {
		return card;
	}

	public static void main(String[] args) {
		WordSearchGUI gui = new WordSearchGUI();
		gui.setVisible(true);
	}

}
