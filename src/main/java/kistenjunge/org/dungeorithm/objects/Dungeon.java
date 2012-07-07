package kistenjunge.org.dungeorithm.objects;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.services.DungeonService;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

/**
 * The container for a single dungeon.
 * 
 */
public class Dungeon {
	int width;
	int height;

	//Should be replaced with Layout class/interface
	HashMap<Coordinate, TileType> dungeonLayout;

	DungeonService dungeonService;

	public Dungeon(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public HashMap<Coordinate, TileType> getDungeonLayout() {
		return dungeonLayout;
	}

	public void setDungeonLayout(HashMap<Coordinate, TileType> dungeonLayout) {
		this.dungeonLayout = dungeonLayout;
	}

	public DungeonService getDungeonService() {
		return dungeonService;
	}

	public void setDungeonService(DungeonService dungeonService) {
		this.dungeonService = dungeonService;
	}
}
