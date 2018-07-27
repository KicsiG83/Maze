package hu.ak_akademia.maze;

public class Player {
	private String name;
	private char symbolInMaze = '$';
	private int coorX = 1;
	private int coorY = 0;
	public String getName() {
		return name;
	}
	public char getSymbolInMaze() {
		return symbolInMaze;
	}
	public int getCoorX() {
		return coorX;
	}
	public int getCoorY() {
		return coorY;
	}
	
	public void setCoordinates(int a, int b) {
		coorX = a;
		coorY = b;
		
	}
}
