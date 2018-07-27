package hu.ak_akademia.maze;

import java.util.Arrays;
import java.util.Collections;

public class MazeGenerator {
	private final int x;
	private final int y;
	private final int[][] maze;

	public MazeGenerator(int size) {
		this.x = size;
		this.y = size;
		maze = new int[size][size];
		generateMaze(0, 0);
	}

	public char[][] display() {
		String mazeInString = "";
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				String s = (maze[j][i] & 1) == 0 ? "+---" : "+   ";
				mazeInString = mazeInString + s;
				System.out.print(s);
			}
			mazeInString = mazeInString + "+\n";
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				String s;
				if (i == 0 && j == 0) {
					s = (maze[j][i] & 8) == 0 ? "    " : "    ";
				} else {
					s = (maze[j][i] & 8) == 0 ? "|   " : "    ";
				}
				mazeInString = mazeInString + s;
				System.out.print(s);
			}
			String west = i == y - 1 ? " \n" : "|\n";
			mazeInString = mazeInString + west;
			if (i == y - 1) {
				System.out.println("");
			} else {
				System.out.println("|");
			}
		}
		// draw the bottom line
		for (int j = 0; j < x; j++) {
			String s = "+---";
			mazeInString = mazeInString + s;
			System.out.print(s);
		}
		mazeInString = mazeInString + "+\n";
		System.out.println("+");

		String[] resultArray = mazeInString.split("\n");
		int n = resultArray.length;
		int m = resultArray[0].toCharArray().length;
		char[][] result = new char[n][m];
		for(int i= 0; i < n;i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = resultArray[i].toCharArray()[j];
			}
		
		}
		return result;
	}

	private void generateMaze(int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0)) {
				maze[cx][cy] |= dir.bit;
				maze[nx][ny] |= dir.opposite.bit;
				generateMaze(nx, ny);
			}
		}
	}

	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}

	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;

		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}

		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	}
}