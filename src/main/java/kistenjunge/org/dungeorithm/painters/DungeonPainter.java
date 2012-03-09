package kistenjunge.org.dungeorithm.painters;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public interface DungeonPainter
{
  void drawDungeon(HashMap<Coordinate, TileType> layout);
}
