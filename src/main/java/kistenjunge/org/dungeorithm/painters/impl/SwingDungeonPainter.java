package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class SwingDungeonPainter implements DungeonPainter {
	private static final String FRAME_IDENTIFIER = "Dungeorithm";
	private JFrame frame;
	private static JPanel menuPanel;
	private JPanel dungeonPanel;

	@Override
	public void drawDungeon(HashMap<Coordinate, TileType> dungeon) {
		Dimension dungeonDimension = getDimension(dungeon);
		int dungeonRowCount = (int) dungeonDimension.getHeight() + 1;
		int dungeonColCount = (int) dungeonDimension.getWidth() + 1;

		frame = new JFrame(FRAME_IDENTIFIER);
		frame.setLayout(new BorderLayout());

		dungeonPanel = new JPanel();
		dungeonPanel
				.setLayout(new GridLayout(dungeonRowCount, dungeonColCount));

		int y = 0;
		int x = 0;
		Coordinate key = new Coordinate(x, y);

		while (dungeon.containsKey(key)) {
			do {
				TileType tileType = dungeon.get(key);
				JLabel tileLabel = new SwingDungeonTileTypeLabel(tileType, key);
				dungeonPanel.add(tileLabel);
				key = new Coordinate(++x, y);
			} while (dungeon.containsKey(key));
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

	/**
	 * Returns the {@link Dimension} for the dungeon.
	 * 
	 * @param dungeon
	 * @return
	 */
	private Dimension getDimension(HashMap<Coordinate, TileType> dungeon) {
		int x = 0;
		int y = 0;
		int maxX = x;
		int maxY = y;

		Coordinate key = new Coordinate(x, y);

		while (dungeon.containsKey(key)) {
			do {
				maxX = x;
				key = new Coordinate(++x, y);
			} while (dungeon.containsKey(key));
			x = 0;
			maxY = y;
			key = new Coordinate(x, ++y);
		}

		System.out.println("Dimension of Dungeon :" + maxX + "x" + maxY);
		return new Dimension(maxX + 1, maxY);
	}

	protected static SwingDungeonMenuPanel getSwingDungeonMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new SwingDungeonMenuPanel();
		}
		return (SwingDungeonMenuPanel) menuPanel;
	}
}
