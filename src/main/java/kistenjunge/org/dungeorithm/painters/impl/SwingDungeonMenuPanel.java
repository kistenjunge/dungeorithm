package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingDungeonMenuPanel extends JPanel {

	private static final String DEFAULT_TEXT = "DefaultMenuText";

	private static final long serialVersionUID = 8410617556244888733L;

	private JLabel textLabel;

	public SwingDungeonMenuPanel() {
		super();
		this.setLayout(new FlowLayout());
		this.textLabel = new JLabel(DEFAULT_TEXT);
		this.add(textLabel);
	}

	public void setText(String text) {
		this.textLabel.setText(text);
	}

}
