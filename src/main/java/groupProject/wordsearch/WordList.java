package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WordList extends JPanel {
	private DefaultListModel<String> model;
	private JList<String> list;

	public WordList(GamePanel gamePanel) {
		setBorder(new LineBorder(Color.BLUE, 3));

		Dimension dimension = new Dimension(150, gamePanel.getHeight());
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);

		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setCellRenderer(new SelectedListCellRenderer());
		list.setBackground(null);
		list.setEnabled(false);

		add(list);
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public JList<String> getList() {
		return list;
	}
}
