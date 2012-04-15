package kistenjunge.org;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.Dungeorithm;
import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.painters.impl.SwingDungeonPainter;
import kistenjunge.org.dungeorithm.painters.impl.TextualDungeonPainter;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class App
{
  static final int MAX_LENGTH = 50;

  static final int MIN_LENGTH = 20;

  public static void main(String[] args)
  {
    Dungeorithm dungeorithm = new Dungeorithm(MIN_LENGTH, MAX_LENGTH);
    dungeorithm.generateDungeon();
    HashMap<Coordinate,TileType> dungeon = dungeorithm.getDungeon();

    DungeonPainter dungeonPainter = new TextualDungeonPainter();
    dungeonPainter.drawDungeon(dungeon);
    
    DungeonPainter swingDungeonPainter = new SwingDungeonPainter();
    swingDungeonPainter.drawDungeon(dungeon);
  }

}
