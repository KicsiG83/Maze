package hu.ak_akademia.maze;

public class Game {
	private int sizeOfMaze;
	private int numberOfEnemies;
	private int radiusOfAgressitivity;
	
	public Game(GameSetting settings) {
		sizeOfMaze = 10  * Integer.parseInt(settings.getSize());
		numberOfEnemies = Integer.parseInt(settings.getSize())
				+ Integer.parseInt(settings.getEnemies()) - 2;
		radiusOfAgressitivity = Integer.parseInt(settings.getAggressiveness()) + 1;
		
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
	
}
