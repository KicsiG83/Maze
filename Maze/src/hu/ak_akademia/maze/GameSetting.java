package hu.ak_akademia.maze;

import java.util.Scanner;

public class GameSetting {

	private String size;
	private String enemies;
	private String aggressiveness;

	public GameSetting(Scanner sc) {

		printSetting("Please choose which size you want to play: ");
		size = wrongChoice(sc, size);
		
		printSetting("Please choose enemies numbers: ");
		enemies = wrongChoice(sc, enemies);
		
		printSetting("Please choose enemies aggressiveness: ");
		aggressiveness = wrongChoice(sc, aggressiveness);

	}
	
	private String wrongChoice(Scanner sc, String menuNumber) {
		menuNumber = sc.nextLine();
		while (!new Validators().isValidNumber(menuNumber)) {
			System.out.print("The input was wrong, please try again (1, 2 or 3): ");
			menuNumber = sc.nextLine();
		}
		return menuNumber;
	}

	private void printSetting(String message) {
		System.out.println("***********************************");
		System.out.println(" ╔ 1. Easy");
		System.out.println(" ╠ 2. Normal");
		System.out.println(" ╚ 3. Hard");
		System.out.print(message);
	}

	public String getSize() {
		return size;
	}

	public String getEnemies() {
		return enemies;
	}

	public String getAggressiveness() {
		return aggressiveness;
	}

}
