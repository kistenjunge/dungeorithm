package kistenjunge.org.dungeorithm.objects;

import java.util.HashMap;

import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

//TODO should replace the layouts used
// add coordinate access
public abstract class Layout {
	HashMap<Coordinate, TileType> layout;
}
