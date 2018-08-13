package hu.ak_akademia.maze;

public class Weapon extends Movable {
	private boolean useable;
	private char sybombolInMaze = 'W';
	@Override
	char getSymbolInMaze() {
		return sybombolInMaze;
	}

}
