package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kistenjunge.org.dungeorithm.objects.Dungeon;
import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class SwingDungeonPainter implements DungeonPainter {
	private static final String FRAME_IDENTIFIER = "Dungeorithm";
	private JFrame frame;
	private static JPanel menuPanel;
	private JPanel dungeonPanel;

	@Override
	public void drawDungeon(Dungeon dungeon) {
		int dungeonRowCount = dungeon.getHeight() + 1;
		int dungeonColCount = dungeon.getWidth() + 1;

		frame = new JFrame(FRAME_IDENTIFIER);
		frame.setLayout(new BorderLayout());

		dungeonPanel = new JPanel();
		dungeonPanel
				.setLayout(new GridLayout(dungeonRowCount, dungeonColCount));

		int y = 0;
		int x = 0;
		Coordinate key = new Coordinate(x, y);

		while (dungeon.getDungeonLayout().containsKey(key)) {
			do {
				TileType tileType = dungeon.getDungeonLayout().get(key);
				JLabel tileLabel = new SwingDungeonTileTypeLabel(tileType, key);
				dungeonPanel.add(tileLabel);
				key = new Coordinate(++x, y);
			} while (dungeon.getDungeonLayout().containsKey(key));
			x = 0;
			key = new Coordinate(x, ++y);
		}

		menuPanel = new SwingDungeonMenuPanel();

		frame.add(menuPanel, BorderLayout.NORTH);
		frame.add(dungeonPanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	protected static SwingDungeonMenuPanel getSwingDungeonMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new SwingDungeonMenuPanel();
		}
		return (SwingDungeonMenuPanel) menuPanel;
	}
}
