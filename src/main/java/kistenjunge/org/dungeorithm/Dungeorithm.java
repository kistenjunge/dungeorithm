package kistenjunge.org.dungeorithm;

import kistenjunge.org.dungeorithm.objects.Dungeon;
import kistenjunge.org.dungeorithm.services.DungeonService;
import kistenjunge.org.dungeorithm.util.CalcUtils;

public class Dungeorithm {
	int maxLength = 30;

	int minLength = 15;

	Dungeon dungeon;

	public Dungeorithm(int minLength, int maxLength) {
		this.maxLength = maxLength;
		this.minLength = minLength;
	}

	public void generateDungeon() {
		int dungeonSize = CalcUtils.randomOddNumber(minLength, maxLength);

		DungeonService dungeonService = new DungeonService(dungeonSize);
		dungeonService.fillDungeonWithRooms();

		dungeon = new Dungeon(dungeonSize, dungeonSize);
		dungeon.setDungeonLayout(dungeonService.getLayout());
		dungeon.setDungeonService(dungeonService);
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
}
