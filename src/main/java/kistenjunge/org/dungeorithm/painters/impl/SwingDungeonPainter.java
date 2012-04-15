package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class SwingDungeonPainter implements DungeonPainter {
	private static final String FRAME_IDENTIFIER = "Dungeorithm";
	private JFrame frame;

	@Override
	public void drawDungeon(HashMap<Coordinate, TileType> dungeon) {
		Dimension dungeonDimension = getDimension(dungeon);
		int dungeonRowCount = (int) dungeonDimension.getHeight() + 1;
		int dungeonColCount = (int) dungeonDimension.getWidth() + 1;
		
		frame = new JFrame(FRAME_IDENTIFIER);
		frame.setLayout(new GridLayout(dungeonRowCount, dungeonColCount));

		int y = 0;
		int x = 0;
		Coordinate key = new Coordinate(x, y);

		while (dungeon.containsKey(key)) {
			do {
				TileType tileType = dungeon.get(key);
				JLabel tileLabel = tileTypeToJLabel(tileType);
				frame.add(tileLabel);
				key = new Coordinate(++x, y);
			} while (dungeon.containsKey(key));
			x = 0;
			key = new Coordinate(x, ++y);
		}

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
		return new Dimension(maxX+1, maxY);
	}

	 private JLabel tileTypeToJLabel(TileType tileType) {
	 JLabel tileLabel = new JLabel();
	 tileLabel.setSize(10, 10);
	 tileLabel.setOpaque(true);
	
	 switch (tileType) {
	 case EMPTY:
	 tileLabel.setBackground(Color.BLACK);
	 break;
	 case ROOM:
	 tileLabel.setBackground(Color.BLACK);
	 break;
	 case PERIMETER:
	 tileLabel.setText("x");
	 tileLabel.setBackground(Color.WHITE);
	 break;
	
	 default:
	 tileLabel.setBackground(Color.RED);
	 break;
	 }
	 return tileLabel;
	 }
}
