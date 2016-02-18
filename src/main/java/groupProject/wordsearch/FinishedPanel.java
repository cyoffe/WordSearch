package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class FinishedPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel finishedScrn, message;

	public FinishedPanel(final WordSearchGUI wordSearchGUI) {
		setLayout(new BorderLayout(30, 30));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		setBackground(new Color(17, 0, 28));

		finishedScrn = new JPanel();
		finishedScrn.setLayout(new BorderLayout());
		finishedScrn.setBackground(null);

		message = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				g2.setFont(new Font("Minion Pro", Font.BOLD, 60));
				g2.setColor(new Color(255, 38, 0));
				g2.drawString("Congratulations", 150, 120);

				g2.setFont(new Font("Minion Pro", Font.BOLD, 40));
				g2.drawString("on finishing the", 215, 200);

				g2.setFont(new Font("Minion Pro", Font.BOLD, 70));
				g2.drawString("#1 WORD SEARCH!", 40, 300);
			}

		};
		message.setBackground(null);

		final JPanel tyMessage = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				g2.setFont(new Font("Minion Pro", Font.BOLD, 60));
				g2.setColor(new Color(255, 38, 0));
				g2.drawString("Thank You", 290, 120);

				g2.setFont(new Font("Minion Pro", Font.BOLD, 40));
				g2.drawString("for playing the", 215, 200);

				g2.setFont(new Font("Minion Pro", Font.BOLD, 70));
				g2.drawString("#1 WORD SEARCH!", 40, 300);

			}
		};
		tyMessage.setBackground(null);

		Dimension d = new Dimension(100, 100);
		final JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2, 100, 0));
		buttons.setBorder(new EmptyBorder(0, 50, 0, 50));
		buttons.setBackground(null);
		buttons.setPreferredSize(d);
		buttons.setMinimumSize(d);
		buttons.setMaximumSize(d);

		JButton playAgain = new JButton("PLAY AGAIN?");
		playAgain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				wordSearchGUI.getCategoryPanel().setVisible(false);
				wordSearchGUI.getCardLayout().show(wordSearchGUI.getCard(),
						"Menu");

			}

		});

		JButton exit = new JButton("NEXT TIME");

		buttons.add(playAgain);
		buttons.add(exit);

		finishedScrn.add(message, BorderLayout.CENTER);
		finishedScrn.add(buttons, BorderLayout.SOUTH);



		exit.addActionListener(new ActionListener() {

			private Timer timer;

			public void actionPerformed(ActionEvent e) {
				finishedScrn.remove(message);
				finishedScrn.remove(buttons);
				finishedScrn.add(tyMessage, BorderLayout.CENTER);
				revalidate();
				repaint();

				timer = new Timer(2500, new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						wordSearchGUI.dispose();

					}

				});
				timer.start();


			}

		});

		add(finishedScrn);
	}

}
