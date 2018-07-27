package hu.ak_akademia.maze;

public class Maze {
	private Player player;
	private char[][] maze;

	public char[][] getMaze() {
		return maze;
	}

	public void setMaze(char[][] maze) {
		this.maze = maze;
	}
	public Maze() {
		player = new Player();
	}
	
	public void move(String direction) {
		int oldX = player.getCoorX();
		int oldY = player.getCoorY();
		int newX = oldX;
		int newY = oldY;
		
		switch(direction) {
		case "up":
			newX = oldX-1;
			break;
		case "down":
			newX = oldX+1;
			break;
		case "left":
			newY = oldY-1;
			break;
		case "right":
			newY = oldY+1;
			break;
		default: break;
		}
		
		if(!isFree(newX,newY)) {
			return;
		}
		maze[oldX][oldY] = ' ';
		player.setCoordinates(newX, newY);
		putPlayerInMaze(player);
	
	}
	
	private boolean isFree(int x,int y) {
		if(maze[x][y] == ' ') {
			return true;
		}
		return false;
	}
	private void putPlayerInMaze(Player player) {
		maze[player.getCoorX()][player.getCoorY()] = player.getSymbolInMaze();
	}
	
	@Override
	public String toString() {
		putPlayerInMaze(player);
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
