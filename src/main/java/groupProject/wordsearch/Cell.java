package groupProject.wordsearch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Cell extends JLabel implements MouseListener {
	private char letter;
	private boolean clicked;
	private int row;
	private int col;

	public Cell(int row, int col) {
		this(null, row, col);
	}

	public Cell(Character letter, int row, int col) {

		if (letter == null) {
			letter = ' ';
		} else {
			this.letter = letter;
		}
		//this.clicked = false;
		this.setText(String.valueOf(letter));
		this.setFont(new Font("Arial", Font.BOLD, 13));
		setBorder(null);
		//setBorderPainted(false);
		//setContentAreaFilled(false);
		setOpaque(false);
		/*this.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setBackground(Color.YELLOW);
				
			}
			
		});*/

	}

	public char getLetter() {
		return letter;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setDimension(Dimension d) {
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		((JComponent) source).setBackground(Color.YELLOW);
		super.repaint();

	}

	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		((JComponent) source).setBackground(Color.YELLOW);
		super.repaint();

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
