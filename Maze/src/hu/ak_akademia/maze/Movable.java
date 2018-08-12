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

	public int[] move(String direction) {
		int oldX = coorX;
		int oldY = coorY;
		int newX = oldX;
		int newY = oldY;

		switch (direction) {
		case "up":
			newX = oldX - 1;
			break;
		case "down":
			newX = oldX + 1;
			break;
		case "left":
			newY = oldY - 1;
			break;
		case "right":
			newY = oldY + 1;
			break;
		default:
			break;
		}
		int[] result = { newX, newY };
		return result;
	}
}
