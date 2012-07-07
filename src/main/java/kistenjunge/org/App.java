package kistenjunge.org;

import kistenjunge.org.dungeorithm.Dungeorithm;
import kistenjunge.org.dungeorithm.objects.Dungeon;
import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.painters.impl.SwingDungeonPainter;
import kistenjunge.org.dungeorithm.painters.impl.TextualDungeonPainter;

public class App {
	static final int MAX_LENGTH = 50;

	static final int MIN_LENGTH = 20;

	public static void main(String[] args) {
		Dungeorithm dungeorithm = new Dungeorithm(MIN_LENGTH, MAX_LENGTH);
		dungeorithm.generateDungeon();

		Dungeon dungeon = dungeorithm.getDungeon();

		DungeonPainter dungeonPainter = new TextualDungeonPainter();
		dungeonPainter.drawDungeon(dungeon);

		DungeonPainter swingDungeonPainter = new SwingDungeonPainter();
		swingDungeonPainter.drawDungeon(dungeon);
	}

}
