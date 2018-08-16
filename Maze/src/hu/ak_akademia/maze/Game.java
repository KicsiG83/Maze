package hu.ak_akademia.maze;

public class Game {
	private int sizeOfMaze;
	private int numberOfEnemies;
	private int radiusOfAgressitivity;

	public Game(GameSetting settings) {
		sizeOfMaze = 10 * Integer.parseInt(settings.getSize());
		int helperNumber = Integer.parseInt(settings.getSize()) + Integer.parseInt(settings.getEnemies()) - 2;
		numberOfEnemies = helperNumber < 3 ? helperNumber : 3;
		radiusOfAgressitivity = 3 * Integer.parseInt(settings.getAggressiveness()) + 1;
	}

	public int getSizeOfMaze() {
		return sizeOfMaze;
	}

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public int getRadiusOfAgressitivity() {
		return radiusOfAgressitivity;
	}

	public Enemy constructEnemy() {
		Enemy newEnemy = new Enemy(radiusOfAgressitivity);
		return newEnemy;
	}

}
