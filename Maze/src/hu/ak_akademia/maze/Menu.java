package hu.ak_akademia.maze;

import java.util.Scanner;

public class Menu {

	private String size;
	private String enemies;
	private String aggressiveness;

	public Menu(Scanner sc) {

		printMenu("Please choose which size you want to play: ");
		size = wrongMenuChoice(sc, size);
		
		printMenu("Please choose enemies numbers: ");
		enemies = wrongMenuChoice(sc, enemies);
		
		printMenu("Please choose enemies aggressiveness: ");
		aggressiveness = wrongMenuChoice(sc, aggressiveness);

	}

	private String wrongMenuChoice(Scanner sc, String menuNumber) {
		menuNumber = sc.nextLine();
		while (!new Validators().isValidNumber(menuNumber)) {
			System.out.print("The input was wrong, please try again (1, 2 or 3): ");
			menuNumber = sc.nextLine();
		}
		return menuNumber;
	}

	private void printMenu(String message) {
		System.out.println("***********************************");
		System.out.println(" ╔ 1. Easy");
		System.out.println(" ╠ 2. Normal");
		System.out.println(" ╚ 3. Hard");
		System.out.print(message);
	}

}
