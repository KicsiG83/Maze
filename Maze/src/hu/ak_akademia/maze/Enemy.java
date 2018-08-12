package hu.ak_akademia.maze;

public class Enemy extends Movable {
	private char symbolInMaze = 'O';
	private int radiusOfAgressivity;

	public Enemy(int radiusOfAgressivity) {
		this.radiusOfAgressivity = radiusOfAgressivity;
	}

	@Override
	public char getSymbolInMaze() {
		return symbolInMaze;
	}

	public int getRadiusOfAgressivity() {
		return radiusOfAgressivity;
	}

	public int getDistanceSquare(Movable player) {
		int squareX = (player.getCoorX() - this.coorX) * (player.getCoorX() - this.coorX);
		int squareY = (player.getCoorY() - this.coorY) * (player.getCoorY() - this.coorY);
		return squareX + squareY;
	}

	public boolean isInRange(Movable player) {
		int rangeLimit = radiusOfAgressivity * radiusOfAgressivity;
		int checkSum = getDistanceSquare(player);
		return rangeLimit >= checkSum;
	}
}
