package groupProject.wordsearch;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

		JPanel container = (JPanel) getContentPane();
		container.setBorder(new EmptyBorder(10, 10, 10, 10));

		card = new JPanel();
		card.setLayout(cardLayout = new CardLayout());

		menuPanel = new Menu(this);
		customPanel = new CustomGamePanel(this);
		categoryPanel = new CategoryGamePanel();
		gamePanel = new GamePanel();

		card.add("Menu", menuPanel);
		card.add("Custom Puzzle", customPanel);
		card.add("Category Puzzle", categoryPanel);
		card.add("Game", gamePanel);
		cardLayout.show(card, "Menu");
		container.add(card);

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
		new WordSearchGUI().setVisible(true);
	}

}
