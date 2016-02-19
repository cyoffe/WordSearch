package groupProject.wordsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WordList extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JList<String> list;

	public WordList(GamePanel gamePanel) {
		setLayout(new BorderLayout());
		setBorder(new LineBorder(Color.WHITE, 3));
		setBackground(new Color(218, 158, 255));

		Dimension dimension = new Dimension(150, gamePanel.getHeight());
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);

		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setCellRenderer(new SelectedListCellRenderer());
		list.setBackground(null);
		list.setEnabled(false);

		add(list, BorderLayout.CENTER);
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public JList<String> getList() {
		return list;
	}

}
