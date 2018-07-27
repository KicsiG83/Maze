package hu.ak_akademia.maze;

public class Maze {
	private char[][] maze;

	public char[][] getMaze() {
		return maze;
	}

	public void setMaze(char[][] maze) {
		this.maze = maze;
	}
	public Maze() {}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Olyan metódusok kellenek még, amik ennek a char tömb egy elemének, mind a 4
	 * szomszédjáról tudnak nyilatkozni, hogy üres-e vagy sem.
	 * 
	 */
	@Override
	public String toString() {
		String result = "";
		for(int i= 0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++)  {
				result = result + maze[i][j];
			}
			result = result + "\n";
		}
		return result;
	}
	
}
