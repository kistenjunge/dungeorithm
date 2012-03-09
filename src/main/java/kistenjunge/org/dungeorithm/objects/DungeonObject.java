package kistenjunge.org.dungeorithm.objects;

import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class DungeonObject
{
  Coordinate position;

  TileType type;

  public Coordinate getPosition()
  {
    return position;
  }

  public void setPosition(Coordinate position)
  {
    this.position = position;
  }

  public TileType getType()
  {
    return type;
  }

  public void setType(TileType type)
  {
    this.type = type;
  }

}
