package groupProject.wordsearch;

import java.awt.CardLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WordSearchGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private Menu menuPanel;
	private JPanel card;
	private CustomGamePanel customPanel;
	private CategoryGamePanel categoryPanel;
	private GamePanel gamePanel;
	private ImageIcon img;
	private FinishedPanel finishedPanel;

	public WordSearchGUI() {
		setTitle("Word Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 100);
		setResizable(false);

		img = new ImageIcon("button images/icon2.jpg");
		Image imgBig = img.getImage();
		imgBig = imgBig
				.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
		setIconImage(imgBig);

		JPanel container = (JPanel) getContentPane();

		card = new JPanel();

		card.setLayout(cardLayout = new CardLayout());

		menuPanel = new Menu(this);
		customPanel = new CustomGamePanel(this);
		categoryPanel = new CategoryGamePanel(this);
		gamePanel = new GamePanel(this);
		finishedPanel = new FinishedPanel(this);

		card.add("Menu", menuPanel);
		card.add("Custom Puzzle", customPanel);
		card.add("Category Puzzle", categoryPanel);
		card.add("Game", gamePanel);
		card.add("Finished", finishedPanel);

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
