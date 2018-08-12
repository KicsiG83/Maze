package hu.ak_akademia.maze;

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
		Enemy[] enemies = new Enemy[3];
		for(int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy(game.getRadiusOfAgressitivity());
		}
		enemies[0].setCoordinates(maze.length - 2, maze[maze.length - 2].length - 2);
		enemies[1].setCoordinates(1,  maze[1].length - 2);
		enemies[2].setCoordinates(maze.length - 2,1);
		int index = 0;
		MazeFrame frame = new MazeFrame(maze);
		while(index < game.getNumberOfEnemies()) {
			frame.getMaze().getEnemies().add(enemies[index]);
			index++;
		}
	}
}
