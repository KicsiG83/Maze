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
		int size = new Input().userInput(sc);
		MazeGenerator maze = new MazeGenerator(size);
		new MazeFrame();
		maze.display();
	}
}
