package kistenjunge.org.dungeorithm;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.services.DungeonService;
import kistenjunge.org.dungeorithm.util.CalcUtils;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

public class Dungeorithm
{
  HashMap<Coordinate,TileType> dungeon;

  int maxLength = 30;

  int minLength = 15;

  public Dungeorithm(int minLength, int maxLength)
  {
    this.maxLength = maxLength;
    this.minLength = minLength;
  }

  public void generateDungeon()
  {
    int dungeonSize = CalcUtils.randomOddNumber(minLength, maxLength);
    DungeonService dungeonService = new DungeonService(dungeonSize);
    dungeonService.fillDungeonWithRooms();
    dungeon = dungeonService.getLayout();
  }

  public void setMaxLength(int maxLength)
  {
    this.maxLength = maxLength;
  }

  public void setMinLength(int minLength)
  {
    this.minLength = minLength;
  }

  public HashMap<Coordinate, TileType> getDungeon()
  {
    return dungeon;
  }

}
