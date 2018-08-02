package hu.ak_akademia.maze;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Main().run(sc);
		sc.close();
	}

	private void run(Scanner sc) {
		new Print().printWelcome();
		Game game = new Game(new GameSetting(sc));
		char[][] maze = new MazeGenerator(game.getSizeOfMaze()).display();
		
		Enemy[] enemies = new Enemy[4];
		enemies[0] = new Enemy(game.getRadiusOfAgressitivity());
		enemies[0].setCoordinates(maze.length - 2, maze[maze.length - 2].length - 2);
		enemies[1] = new Enemy(game.getRadiusOfAgressitivity());
		enemies[1].setCoordinates(1,  maze[1].length - 2);
		enemies[2] = new Enemy(game.getRadiusOfAgressitivity());
		enemies[2].setCoordinates(maze.length - 2,1);
		//enemies[3] = new Enemy(game.getRadiusOfAgressitivity());
		//int[] fourthCoors =  randomCoordinates(maze);
		//enemies[3].setCoordinates(fourthCoors[0], fourthCoors[1]);
		
		int index = 0;
		MazeFrame frame = new MazeFrame(maze);
		while(index < game.getNumberOfEnemies()) {
			frame.getMaze().getEnemies().add(enemies[index]);
			index++;
		}

		while(frame.getFrame().isActive()) {
			
		}
		System.out.println("Game Over");
		return; //jelenleg ez a vége a programnak
		
		
	}
	
	/*private int[] randomCoordinates(char[][] maze) {
		Random rnd = new Random();
		int[] result = new int[2];
		int x = rnd.nextInt(maze.length);
		int a = x > 0 ?  x - 1 : 0;
		int y = rnd.nextInt(maze[0].length);
		int b = y > 0 ? y - 1 : 0;
		
		if(maze[a][b] == ' ') {
			result[0] = a;
			result[1] = b;
		} else if(maze[a + 1][b] == ' ') {
			result[0] = a + 1;
			result[1] = b;
		} else if(maze[a][b + 1] == ' ') {
			result[0] = a;
			result[1] = b + 1;
		} else if(maze[a + 1][b + 1] == ' ') {
			result[0] = a + 1;
			result[1] = b + 1;
		} else {
			//kicsi a valószínűsége, de előfordulhat.
		}
		
	return result;
	}*/
}
