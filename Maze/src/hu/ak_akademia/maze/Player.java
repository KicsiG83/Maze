package hu.ak_akademia.maze;

public class Player extends Movable {
	private String name;
	private char symbolInMaze = '$';
	
	public Player() {
		super.coorX = 1;
		super.coorY = 0;
	}
	public String getName() {
		return name;
	}
	@Override
	public char getSymbolInMaze() {
		return symbolInMaze;
	}
	
}
