package kistenjunge.org.dungeorithm.painters.impl;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.painters.DungeonPainter;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class TextualDungeonPainter implements DungeonPainter
{
  @Override
  public void drawDungeon(HashMap<Coordinate, TileType> layout)
  {
    StringBuilder builder = new StringBuilder();
    int y = 0;
    int x = 0;
    Coordinate key = new Coordinate(x, y);

    while (layout.containsKey(key))
    {
      builder.append("Row " + y + ":\t\t");
      do
      {
        TileType tileType = layout.get(key);
        String tileString = tileTypeToString(tileType);
        builder.append(tileString);
        key = new Coordinate(++x, y);
      }
      while (layout.containsKey(key));
      builder.append("\n");
      x = 0;
      key = new Coordinate(x, ++y);
    }
    System.out.println(builder.toString());
  }

  private String tileTypeToString(TileType tile)
  {
    String value;
    switch (tile)
    {
    case EMPTY:
      value = "E";
      break;
    case ROOM:
      value = "O";
      break;
    case PERIMETER:
      value = "X";
      break;

    default:
      value = "";
      break;
    }
    return value;
  }
}
