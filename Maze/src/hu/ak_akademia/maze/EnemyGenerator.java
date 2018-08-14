package hu.ak_akademia.maze;

import java.util.ArrayList;
import java.util.Random;

public class EnemyGenerator {
	private char[][] maze;
	ArrayList<Integer[]> validCoors= new ArrayList<Integer[]>();
	Random random = new Random();
	

	public EnemyGenerator(char[][] maze) {
		this.maze = maze;
		setValidCoors();
	}
	
	public Enemy[] generate(int numberOfEnemies,int radiusOfAgressivity) {
		Enemy[] enemies = new Enemy[numberOfEnemies];
		for(int i=0;i<numberOfEnemies;i++) {
			enemies[i] = new Enemy(radiusOfAgressivity);
			int[] rndCoors = getRandomCoordinates();
			enemies[i].setCoordinates(rndCoors[0], rndCoors[1]);
		}
		return enemies;
	}
	private int[] getCoorsOfFreeCentrum() {
		int centerX = maze.length / 2;
		int centerY = maze[centerX].length / 2;
		int[] result = new int[2];
		if(isFree(centerX,centerY)) {
			result[0] = centerX;
			result[1] = centerY;
		} else if(isFree(centerX+1,centerY)) {
			result[0] = centerX+1;
			result[1] = centerY;	
		} else if(isFree(centerX,centerY+1)) {
			result[0] = centerX;
			result[1] = centerY+1;	
		} else{
			result[0] = centerX+1;
			result[1] = centerY+1;	
		}
		return result;
	}
	private boolean isFree(int x, int y) {
		if (maze[x][y] == ' ') {
			return true;
		}
		return false;
	}
	private void setValidCoors(){
		int[] centrumCoors = getCoorsOfFreeCentrum();		
		for(int i = maze.length/3;i<maze.length;i++) {
			for(int j=maze[i].length/3;j<maze[i].length;j++) {
				if(maze[i][j]==' ' && !(i==centrumCoors[0] && j==centrumCoors[1])) {
					Integer[] addMe = {i,j};
					validCoors.add(addMe);
				}
			}
		}
	}
	private int[] getRandomCoordinates() {
		
		ArrayList<Integer[]> validCoors=getValidCoors();
		int[] result = new int[2];
		int randomIndexOfValidCoors = random.nextInt(validCoors.size());
		result[0] = (int) validCoors.get(randomIndexOfValidCoors)[0];
		result[1] = (int) validCoors.get(randomIndexOfValidCoors)[1];
		validCoors.remove(randomIndexOfValidCoors);
		
		return result;
	}

	private ArrayList<Integer[]> getValidCoors() {
		return validCoors;
	}
}
