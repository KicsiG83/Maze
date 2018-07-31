package hu.ak_akademia.maze;

public class Enemy extends Movable {
	private char symbolInMaze = 'O';
	private int radiusOfAgressivity;
	
	public Enemy(int radiusOfAgressitivity) {
		this.radiusOfAgressivity = radiusOfAgressivity;
	}
	
	@Override
	public char getSymbolInMaze() {
		return symbolInMaze;
	}
	
	public int getRadiusOfAgressivity() {
		return radiusOfAgressivity;
	}
	
}
