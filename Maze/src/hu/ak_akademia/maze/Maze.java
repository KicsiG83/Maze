package hu.ak_akademia.maze;
/**
 * 
 * @author balag
 *Labirintus, két mezője van. A játékos és maga az épület
 */
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
	/**
	 * Melyik irányba lépjen a játékos.
	 * Annak megfelelően megváltoztatja a játékos koordinátáit
	 * @param direction
	 */
	public void movePlayer(String direction) {
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
		if(newX < 0 || newY<0 || newX >= maze.length || newY >= maze[0].length) {
			return;
		}
		
		if(!isFree(newX,newY)) {
			return;
		}
		
		maze[oldX][oldY] = ' ';
		player.setCoordinates(newX, newY);
		putPlayerInMaze(player);
		
		if(newX == maze.length - 2 && newY == maze[maze.length - 2].length - 1) {
			System.out.println("You have escaped.");
			System.exit(0);
		}
	
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
