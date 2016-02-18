package groupProject.wordsearch;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class SelectedListCellRenderer extends DefaultListCellRenderer {

	private ArrayList<Object> listItemBackground;

	public SelectedListCellRenderer() {
		listItemBackground = new ArrayList<Object>();
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		//Component c = super.getListCellRendererComponent(list, value, index,
		//		isSelected, cellHasFocus);
		JLabel word = new JLabel(value.toString().toUpperCase());
		word.setHorizontalAlignment(JLabel.CENTER);
		word.setVerticalAlignment(JLabel.CENTER);
		word.setFont(new Font("Arial", Font.BOLD, 13));
		word.setBorder(new EmptyBorder(4,0,4,0));
		
		if (listItemBackground.contains(value)) {
			word.setForeground(Color.LIGHT_GRAY);
			word.setBackground(null);
			

		} else {
			if (isSelected) {
				word.setForeground(Color.LIGHT_GRAY);
				word.setBackground(null);
				listItemBackground.add(value);
			}
			else{
				word.setForeground(Color.BLACK);
			}
		}
		return word;
	}
}