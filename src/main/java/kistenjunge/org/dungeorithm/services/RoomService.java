package kistenjunge.org.dungeorithm.services;

import org.apache.commons.math.random.RandomDataImpl;

import kistenjunge.org.dungeorithm.objects.Room;
import kistenjunge.org.dungeorithm.util.CalcUtils;
import kistenjunge.org.dungeorithm.util.Coordinate;

public class RoomService {
	private static final int FACTOR_ROOMSIZE_MIN = 10;

	private static final int FACTOR_ROOMSIZE_MAX = 3;

	int dungeonSize;

	int sizeRoomMax;

	int sizeRoomMin;

	int numberOfRooms;

	public RoomService(int dungeonSize) {
		initializeRoomService(dungeonSize);
	}

	public void initializeRoomService(int size) {
		dungeonSize = size;
		sizeRoomMin = dungeonSize / FACTOR_ROOMSIZE_MIN;
		sizeRoomMax = dungeonSize / FACTOR_ROOMSIZE_MAX;
		numberOfRooms = calcNumberOfRooms(dungeonSize, sizeRoomMax);
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public Room generateRoom() {
		int width = CalcUtils.randomOddNumber(sizeRoomMin, sizeRoomMax);
		int height = CalcUtils.randomOddNumber(sizeRoomMin, sizeRoomMax);
		Coordinate randomPosition = getRandomPosition(width, height);
		Room room = new Room(randomPosition, width, height);
		return room;
	}

	private Coordinate getRandomPosition(int width, int height) {
		int half = dungeonSize / 2;
		int xPos = new RandomDataImpl().nextInt(0, half - width) * 2;
		int yPos = new RandomDataImpl().nextInt(0, half - height) * 2;
		return new Coordinate(xPos, yPos);
	}

	private int calcNumberOfRooms(int size, int sizeRoomMax) {
		int power = 2;
		int numberOfRooms = (int) (Math.pow(size, power) / Math.pow(
				sizeRoomMax, power));
		return numberOfRooms;
	}

	public Room divideRoom(Room room) {
		if (room.getWidth() > 3 && room.getHeight() > 3) {
			System.out.println("RoomService : TODO : Divide room.");
		} else {
			System.out
					.println("RoomService : Room is to small. Can't divide it any further.");
		}
		return room;
	}

}
