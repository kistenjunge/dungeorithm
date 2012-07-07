package kistenjunge.org.dungeorithm.services;

import java.util.HashMap;
import java.util.Set;

import kistenjunge.org.dungeorithm.objects.Room;
import kistenjunge.org.dungeorithm.util.Coordinate;
import kistenjunge.org.dungeorithm.util.TileType;

/**
 * 
 * All Dungeons are square with an odd number of rows and columns. The Rooms
 * have odd numbers in height and width.
 * 
 */
public class DungeonService {
	int size;

	RoomService roomHelper;

	//Should be replaced with Layout class/interface
	HashMap<Coordinate, TileType> layout;

	public DungeonService(int dungeonSize) {
		initializeDungeonService(dungeonSize);
	}

	public void initializeDungeonService(int size) {
		this.size = size;
		initEmptyLayout();
		roomHelper = new RoomService(this.size);
	}

	private void initEmptyLayout() {
		layout = new HashMap<Coordinate, TileType>();
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				Coordinate coord = new Coordinate(x, y);
				layout.put(coord, TileType.EMPTY);
			}
		}
	}

	public void fillDungeonWithRooms() {
		int numberOfRooms = roomHelper.getNumberOfRooms();
		for (int i = 1; i <= numberOfRooms; i++) {
			Room room = roomHelper.generateRoom();
			addRoom(room);
		}
	}

	private void addRoom(Room room) {

		if (!checkIfRoomFits(room)) {
			// TODO
			// axis mirroring / rotations
			// simple 4 field clustering?
			// easy solution let room shrink until it fits
			// check path safety (access)
			room = divideRoom(room);
		}

		if (checkIfRoomFits(room)) {
			layout.putAll(room.getLayout());
		}
	}

	private Room divideRoom(Room room) {
		return roomHelper.divideRoom(room);
	}

	private boolean checkIfRoomFits(Room room) {
		HashMap<Coordinate, TileType> roomLayout = room.getLayout();
		Set<Coordinate> roomCoords = roomLayout.keySet();
		for (Coordinate roomCoord : roomCoords) {
			TileType dungeonTile = layout.get(roomCoord);
			TileType roomTile = roomLayout.get(roomCoord);

			if (dungeonTile.equals(roomTile)) {
				if (dungeonTile != TileType.PERIMETER
						&& dungeonTile != TileType.DOOR) {
					return false;
				}
			} else if (dungeonTile.equals(TileType.DOOR)
					&& roomTile != TileType.PERIMETER) {
				return false;
			} else if (dungeonTile != TileType.EMPTY) {
				return false;
			}
		}
		return true;
	}

	public HashMap<Coordinate, TileType> getLayout() {
		return layout;
	}

	/**
	 * sub get_opts { my $opts = { 'seed' => time(), 'n_rows' => 31, # must be
	 * an odd number 'n_cols' => 31, # must be an odd number 'dungeon_layout' =>
	 * 'None', 'room_min' => 3, # minimum room size 'room_max' => 9, # maximum
	 * room size 'room_layout' => 'Scattered', # Packed, Scattered
	 * 'corridor_layout' => 'Bent', 'remove_deadends' => 50, # percentage
	 * 'add_stairs' => 2, # number of stairs 'map_style' => 'Standard',
	 * 'cell_size' => 18, # pixels }; return $opts; }
	 * 
	 * $dungeon->{'n_i'} = int($dungeon->{'n_rows'} / 2); $dungeon->{'n_j'} =
	 * int($dungeon->{'n_cols'} / 2); $dungeon->{'n_rows'} = $dungeon->{'n_i'} *
	 * 2; $dungeon->{'n_cols'} = $dungeon->{'n_j'} * 2; $dungeon->{'max_row'} =
	 * $dungeon->{'n_rows'} - 1; $dungeon->{'max_col'} = $dungeon->{'n_cols'} -
	 * 1; $dungeon->{'n_rooms'} = 0;
	 */
}
