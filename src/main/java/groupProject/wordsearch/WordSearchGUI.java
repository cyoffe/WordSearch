package groupProject.wordsearch;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WordSearchGUI extends JFrame {

	private CardLayout cardLayout;
	private Menu menuPanel;
	private JPanel card;
	private CustomGamePanel customPanel;
	private CategoryGamePanel categoryPanel;
	private GamePanel gamePanel;

	public WordSearchGUI() {
		setTitle("Word Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setResizable(false);

		JPanel container = (JPanel) getContentPane();

		card = new JPanel();

		card.setLayout(cardLayout = new CardLayout());

		menuPanel = new Menu(this);
		customPanel = new CustomGamePanel(this);
		categoryPanel = new CategoryGamePanel(this);
		gamePanel = new GamePanel(this);

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
