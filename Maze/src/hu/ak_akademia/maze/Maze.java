package hu.ak_akademia.maze;

import java.util.ArrayList;
import java.util.Random;

public class Maze {
	public MazeFrame frame;
	private char[][] maze;
	private Player player;
	private Weapon weapon;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public char[][] getMaze() {
		return maze;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setMaze(char[][] maze) {
		this.maze = maze;
	}

	public Player getPlayer() {
		return player;
	}

	public Maze() {
		player = new Player();
		weapon = new Weapon();
	}

	public void setFrame(MazeFrame frame) {
		this.frame = frame;
	}

	public void movePlayer(String direction) {
		if (player.getDistanceSquare(weapon) == 1) {
			player.pickUpWeapon();
			maze[weapon.getCoorX()][weapon.getCoorY()] = ' ';

		}
		int oldX = player.getCoorX();
		int oldY = player.getCoorY();
		int[] aimField = player.move(direction);
		int newX = aimField[0];
		int newY = aimField[1];
		if (newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
			return;
		}
		if (!isFree(newX, newY)) {
			return;
		}
		maze[oldX][oldY] = ' ';
		player.setCoordinates(newX, newY);
		putMovableToMaze(player);

		if (newX == maze.length - 2 && newY == maze[maze.length - 2].length - 1) {
			// System.out.println("Game Over!\nYou have escaped.");
			Print print = new Print();
			print.gameOver();
			print.youWon();
			frame.stopTimer();
			frame.getFrame().dispose();
		}
	}

	private int[] getCoorsOfFreeCentrum() {
		int centerX = maze.length / 2;
		int centerY = maze[centerX].length / 2;
		int[] result = new int[2];
		if (isFree(centerX, centerY)) {
			result[0] = centerX;
			result[1] = centerY;
		} else if (isFree(centerX + 1, centerY)) {
			result[0] = centerX + 1;
			result[1] = centerY;
		} else if (isFree(centerX, centerY + 1)) {
			result[0] = centerX;
			result[1] = centerY + 1;
		} else {
			result[0] = centerX + 1;
			result[1] = centerY + 1;
		}
		return result;
	}

	public void placeWeapon() {
		int[] coorsOfWeapon = getCoorsOfFreeCentrum();
		weapon.setCoordinates(coorsOfWeapon[0], coorsOfWeapon[1]);
		putMovableToMaze(weapon);
	}

	public void moveEnemies() {
		String[] directions = { "left", "right", "up", "down" };
		Random random = new Random();
		for (Enemy e : enemies) {
			int oldX = e.getCoorX();
			int oldY = e.getCoorY();
			if (e.isOnFlee()) {
				if (e.getFleeDurability() > 0) {
					e.setFleeDurability(e.getFleeDurability() - 1);
				} else {
					e.setOnFlee(false);
				}
				e.setSymbolInMaze('o');
				int[] up = { oldX - 1, oldY };
				int[] down = { oldX + 1, oldY };
				int[] left = { oldX, oldY - 1 };
				int[] right = { oldX, oldY + 1 };
				int[][] optionalSteps = { up, down, left, right };
				ArrayList<Integer> distances = new ArrayList<Integer>();

				for (int i = 0; i < optionalSteps.length; i++) {
					if (isFreeStep(optionalSteps[i][0], optionalSteps[i][1])) {
						Integer distance = (player.getCoorX() - optionalSteps[i][0])
								* (player.getCoorX() - optionalSteps[i][0])
								+ (player.getCoorY() - optionalSteps[i][1]) * (player.getCoorY() - optionalSteps[i][1]);
						distances.add(distance);
					} else {
						distances.add(0);
					}
				}
				int maxIndex = 0;
				for (int i = 0; i < distances.size(); i++) {
					if (distances.get(i) > distances.get(maxIndex)) {
						maxIndex = i;
					}
				}
				maze[oldX][oldY] = ' ';
				e.setCoordinates(optionalSteps[maxIndex][0], optionalSteps[maxIndex][1]);
				putMovableToMaze(e);
			} else if (e.isInRange(player)) {
				e.setSymbolInMaze('ő');
				if (e.getDistanceSquare(player) == 1) {
					Print print = new Print();
					print.gameOver();
					print.youLose();
					// System.out.println("Game Over!\nYou lose!");
					frame.stopTimer();
					frame.getFrame().dispose();
				}
				int[] up = { oldX - 1, oldY };
				int[] down = { oldX + 1, oldY };
				int[] left = { oldX, oldY - 1 };
				int[] right = { oldX, oldY + 1 };
				int[][] optionalSteps = { up, down, left, right };
				ArrayList<Integer> distances = new ArrayList<Integer>();

				for (int i = 0; i < optionalSteps.length; i++) {
					if (isFreeStep(optionalSteps[i][0], optionalSteps[i][1])) {
						Integer distance = (player.getCoorX() - optionalSteps[i][0])
								* (player.getCoorX() - optionalSteps[i][0])
								+ (player.getCoorY() - optionalSteps[i][1]) * (player.getCoorY() - optionalSteps[i][1]);
						distances.add(distance);
					} else {
						distances.add(1000000);
					}
				}
				int minIndex = 0;
				for (int i = 0; i < distances.size(); i++) {
					if (distances.get(i) < distances.get(minIndex)) {
						minIndex = i;
					}
				}
				maze[oldX][oldY] = ' ';
				e.setCoordinates(optionalSteps[minIndex][0], optionalSteps[minIndex][1]);
				putMovableToMaze(e);
			} else {
				e.setSymbolInMaze('O');
				int newX = oldX;
				int newY = oldY;
				do {
					String direction = directions[random.nextInt(directions.length)];
					int[] aimField = e.move(direction);
					newX = aimField[0];
					newY = aimField[1];

					if (newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
						continue;
					}
				} while (!isFree(newX, newY));
				if (newX == maze.length - 2 && newY == maze[maze.length - 2].length - 1) {
				} else {
					maze[oldX][oldY] = ' ';
					e.setCoordinates(newX, newY);
					putMovableToMaze(e);
				}
			}
		}
	}

	private boolean isFreeStep(int x, int y) {
		if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
			return false;
		}
		if (!isFree(x, y)) {
			return false;
		}
		return true;
	}

	private boolean isFree(int x, int y) {
		if (maze[x][y] == ' ') {
			return true;
		}
		return false;
	}

	private void putMovableToMaze(Movable obj) {
		maze[obj.getCoorX()][obj.getCoorY()] = obj.getSymbolInMaze();
	}

	@Override
	public String toString() {
		putMovableToMaze(player);
		for (Enemy e : enemies) {
			putMovableToMaze(e);
		}
		String result = "";
		for (Movable obj : enemies) {
			putMovableToMaze(obj);
		}
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				result = result + maze[i][j];
			}
			result = result + "\n";
		}
		return result;
	}
}
