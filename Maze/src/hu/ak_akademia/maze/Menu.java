package hu.ak_akademia.maze;

import java.util.Scanner;

public class Menu {
	private String menuChoice;

	public int getMenuChoice() {
		return Integer.parseInt(menuChoice);
	}

	public void setMenuChoice(Scanner sc) {
		this.menuChoice = menuChoice(sc);
	}
	
	private String menuChoice(Scanner sc) {
		new Print().menu();
		System.out.print("               Select from menu: ");
		String selectedMenu = sc.nextLine();
		while (!new Validators().isValidNumber(selectedMenu)) {
			System.out.print("              Wrong menu, try again:");
			selectedMenu = sc.nextLine();
		}
		return selectedMenu;
	}
	
}
