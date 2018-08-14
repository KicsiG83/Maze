package hu.ak_akademia.maze;

import java.util.Scanner;

import hu.ak_akademia.maze.test.SecondTestMaze;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		new Main().test();
		new Main().run(sc);
		sc.close();
	}

	private void run(Scanner sc) {
		new Print().printWelcome();
		Game game = new Game(new GameSetting(sc));
		char[][] maze = new MazeGenerator(game.getSizeOfMaze()).display();
		EnemyGenerator enemyGenerator = new EnemyGenerator(maze);
		Enemy[] enemies=enemyGenerator.generate(game.getNumberOfEnemies(), game.getRadiusOfAgressitivity());
		MazeFrame frame = new MazeFrame(maze);
		for(Enemy e : enemies) {
			frame.getMaze().getEnemies().add(e);
		}
	}
	/*private void test() {
		char[][] beforeReplace = new SecondTestMaze().test();
		char[][] afterReplace = new MazeGenerator(0).checkNeighbours(beforeReplace);
		for (int i = 0; i < afterReplace.length; i++) {
			for (int j = 0; j < afterReplace[i].length; j++) {
				System.out.print(afterReplace[i][j]);
			}
			System.out.println();
		}
	}*/
	
}
