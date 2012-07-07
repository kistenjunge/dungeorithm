package kistenjunge.org.dungeorithm.objects;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

/**
 * 
 * A room represents a dungeon room with perimeter
 * 
 */
public class Room extends DungeonObject
{
	//Should be replaced with Layout class/interface
  HashMap<Coordinate, TileType> layout;

  int width;

  int height;

  int offsetX;

  int offsetY;

  public Room(Coordinate position, int width, int height)
  {
    this.position = position;
    this.width = width;
    this.height = height;
    setOffset(this.position);
    setupLayout();
  }

  private void setOffset(Coordinate position)
  {
    this.offsetX = position.getX() - 1;
    if (offsetX < 0)
    {
      offsetX = 0;
    }
    this.offsetY = position.getY() - 1;
    if (offsetY < 0)
    {
      offsetY = 0;
    }
  }

  private void setupLayout()
  {
    int totalWidth = width + 2;
    int totalHeight = height + 2;
    layout = new HashMap<Coordinate, TileType>(
        totalWidth * totalHeight);

    for (int y = 0; y < totalHeight; y++)
    {
      // first and last row will be perimeter
      if (y == 0 || y == (totalHeight - 1))
      {
        for (int x = 0; x < totalWidth; x++)
        {
          layout.put(coordinateWithOffset(x, y), TileType.PERIMETER);
        }
      }
      else
      {
        for (int x = 0; x < totalWidth; x++)
        {
          // first and last cells will be perimeter
          if (x == 0 || x == (totalWidth - 1))
          {
            layout.put(coordinateWithOffset(x, y), TileType.PERIMETER);
          }
          else
          {
            layout.put(coordinateWithOffset(x, y), TileType.ROOM);
          }
        }
      }
    }
  }

  private Coordinate coordinateWithOffset(int x, int y)
  {
    Coordinate withOffset = new Coordinate(x + offsetX, y + offsetY);
    return withOffset;
  }

  public HashMap<Coordinate, TileType> getLayout()
  {
    return layout;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

}
