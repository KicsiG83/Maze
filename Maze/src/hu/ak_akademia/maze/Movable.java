package hu.ak_akademia.maze;

public abstract class Movable {
	protected int coorX;
	protected int coorY;
	
	abstract char getSymbolInMaze();
	
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
