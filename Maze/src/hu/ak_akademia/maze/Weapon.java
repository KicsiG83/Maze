package hu.ak_akademia.maze;

public class Weapon extends Movable {
	private char sybombolInMaze = 'W';
	
	@Override
	char getSymbolInMaze() {
		return sybombolInMaze;
	}

}
