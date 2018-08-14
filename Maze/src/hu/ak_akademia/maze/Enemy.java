package hu.ak_akademia.maze;

public class Enemy extends Movable {
	private char symbolInMaze = 'O';
	private int radiusOfAgressivity;
	private boolean onFlee;
	private int fleeDurability = 5;

	public Enemy(int radiusOfAgressivity) {
		this.radiusOfAgressivity = radiusOfAgressivity;
	}

	@Override
	public char getSymbolInMaze() {
		return symbolInMaze;
	}
	public boolean isOnFlee() {
		return onFlee;
	}
	public void setSymbolInMaze(char symbolInMaze) {
		this.symbolInMaze = symbolInMaze;
	}

	public void setOnFlee(boolean onFlee) {
		this.onFlee = onFlee;
	}

	public int getRadiusOfAgressivity() {
		return radiusOfAgressivity;
	}

	public int getFleeDurability() {
		return fleeDurability;
	}

	public void setFleeDurability(int fleeDurability) {
		this.fleeDurability = fleeDurability;
	}

	public boolean isInRange(Movable player) {
		int rangeLimit = radiusOfAgressivity * radiusOfAgressivity;
		int checkSum = getDistanceSquare(player);
		return rangeLimit >= checkSum;
	}
	
}
