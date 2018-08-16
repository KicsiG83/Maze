package hu.ak_akademia.maze;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new Main().run(sc);
		sc.close();
	}

	private void run(Scanner sc) {
		Print print = new Print();
		print.welcome();
		Menu menu = new Menu();
		menu.setMenuChoice(sc);
		switch (menu.getMenuChoice()) {
		case 1:
			Game game = new Game(new GameSetting(sc));
			char[][] maze = new MazeGenerator(game.getSizeOfMaze()).display();
			EnemyGenerator enemyGenerator = new EnemyGenerator(maze);
			Enemy[] enemies = enemyGenerator.generate(game.getNumberOfEnemies(), game.getRadiusOfAgressitivity());
			MazeFrame frame = new MazeFrame(maze);
			for (Enemy e : enemies) {
				frame.getMaze().getEnemies().add(e);
			}
			break;
		case 2:
			print.aboutMaze();
			break;
		case 3:
			print.bye();
			System.exit(0);
			break;
		}
	}

}
