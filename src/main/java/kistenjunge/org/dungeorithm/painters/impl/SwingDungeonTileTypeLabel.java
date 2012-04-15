package kistenjunge.org.dungeorithm.painters.impl;

import java.awt.Color;

import javax.swing.JLabel;

import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class SwingDungeonTileTypeLabel extends JLabel {
	private static final int DEFAULT_WIDTH = 10;
	private static final int DEFAULT_HEIGHT = 10;

	private static final long serialVersionUID = -332859421668211080L;

	private TileType tileType;
	private Coordinate tileCoordinate;

	public SwingDungeonTileTypeLabel(TileType tileType,
			Coordinate tileCoordinate) {
		super();
		this.tileType = tileType;
		this.tileCoordinate = tileCoordinate;
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setOpaque(true);

		this.addMouseListener(new SwingDungeonMouseListener());

		switch (tileType) {
		case EMPTY:
			this.setBackground(Color.BLACK);
			break;
		case ROOM:
			this.setBackground(Color.BLACK);
			break;
		case PERIMETER:
			this.setText("x");
			this.setBackground(Color.WHITE);
			break;

		default:
			this.setBackground(Color.RED);
			break;
		}
	}

	public TileType getTileType() {
		return tileType;
	}

	public Coordinate getTileCoordinate() {
		return tileCoordinate;
	}
}
