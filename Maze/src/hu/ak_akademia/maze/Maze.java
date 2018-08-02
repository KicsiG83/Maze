package hu.ak_akademia.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;


public class Maze {
	public MazeFrame frame;
	private Player player;
	private char[][] maze;
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
	public Maze() {
		player = new Player();
	}
	public void setFrame(MazeFrame frame) {
		this.frame = frame;
	}
	/**
	 * Melyik irányba lépjen a játékos.
	 * Annak megfelelően megváltoztatja a játékos koordinátáit
	 * @param direction
	 */
	
	public void movePlayer(String direction) {
		int oldX = player.getCoorX();
		int oldY = player.getCoorY();
		int[] aimField = player.move(direction);
		int newX = aimField[0];
		int newY = aimField[1];
		
		if(newX < 0 || newY<0 || newX >= maze.length || newY >= maze[0].length) {
			return;
		}
		
		if(!isFree(newX,newY)) {
			return;
		}
		
		maze[oldX][oldY] = ' ';
		player.setCoordinates(newX, newY);
		putMovableToMaze(player);
		
		if(newX == maze.length - 2 && newY == maze[maze.length - 2].length - 1) {
			System.out.println("You have escaped.");
			frame.stopTimer();
			frame.getFrame().dispose();
		}
	
	}
	
	public void moveEnemies() {
		String[] directions = {"left","right","up","down"};
		Random random = new Random();
		for(Enemy e : enemies) {
			if(!e.isInRange(player)) {
				int oldX = e.getCoorX();
				int oldY = e.getCoorY();
				int newX = oldX;
				int newY = oldY;
				do {
					String direction = directions[random.nextInt(directions.length)];
					int[] aimField = e.move(direction);
					newX = aimField[0];
					newY = aimField[1];
				
					if(newX < 0 || newY<0 || newX >= maze.length || newY >= maze[0].length) {
						continue;
					}
				}
				while(!isFree(newX,newY));
				if(newX == maze.length - 2 && newY == maze[maze.length - 2].length - 1) {}
				else {
					maze[oldX][oldY] = ' ';
					e.setCoordinates(newX, newY);
					putMovableToMaze(e);
				}
			} else {
				if(e.getDistanceSquare(player) == 1) {
					System.out.println("You lose!");
					frame.stopTimer();
					frame.getFrame().dispose();
					
				}
				
				int oldX = e.getCoorX();
				int oldY = e.getCoorY();
				int[] up = {oldX - 1,oldY};
				int[] down = {oldX + 1,oldY};
				int[] left = {oldX,oldY - 1};
				int[] right = {oldX,oldY + 1};
				int[][] optionalSteps = {up,down,left,right};
				ArrayList<Integer> distances = new ArrayList<Integer>();
				
				for(int i=0;i  < optionalSteps.length; i++) {
					if(isFreeStep(optionalSteps[i][0],optionalSteps[i][1])) {
						Integer distance = (player.getCoorX() - optionalSteps[i][0])*(player.getCoorX() - optionalSteps[i][0]) +
								(player.getCoorY() - optionalSteps[i][1])*(player.getCoorY() - optionalSteps[i][1]);
						distances.add(distance);
					} else {
						distances.add(1000000);
					}
				}
				
				int minIndex = 0;
				for(int i=0;i < distances.size();i++) {
					if(distances.get(i) < distances.get(minIndex)) {
						minIndex = i;
					}
				}
				maze[oldX][oldY] = ' ';
				e.setCoordinates(optionalSteps[minIndex][0], optionalSteps[minIndex][1]);
				putMovableToMaze(e);
				
			}
		}
		
	}
	private boolean isFreeStep(int x,int y) {
		if(x < 0 || y<0 || x >= maze.length || y >= maze[0].length) {
			return false;
		}
		if(!isFree(x,y)) {
			return false;
		}
		return true;
	}
	private boolean isFree(int x,int y) {
		if(maze[x][y] == ' ') {
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
		for(Enemy e : enemies) {
			putMovableToMaze(e);
		}
		String result = "";
		for(Movable obj : enemies) {
			putMovableToMaze(obj);
		}
		for(int i= 0;i<maze.length;i++) {
			for (int j=0;j<maze[i].length;j++)  {
				result = result + maze[i][j];
			}
			result = result + "\n";
		}
		return result;
	}

	
}
