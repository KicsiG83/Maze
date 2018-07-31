package hu.ak_akademia.maze;

import java.util.Scanner;

public class Input { 

	private int smallOrLarge; // a pálya mérete

	public int userInput(Scanner sc) {
		int tableSize = 0;
		System.out.println(" ╔ 1. small size");
		System.out.println(" ╚ 2. large size");
		System.out.print("Please choose which size you want to play: ");
		String size = sc.nextLine();
		while (!new Validators().isValidNumber(size)) {
			System.out.print("The input was wrong, please try again (1, 2 or 3): ");
			size = sc.nextLine();
		}
		setSmallOrbig(Integer.parseInt(size));
		if (getSmallOrbig() == 1) {
			tableSize = 10;
		} else {
			tableSize = 20;
		}
		return tableSize;
	}

	public int getSmallOrbig() {
		return smallOrLarge;
	}

	public void setSmallOrbig(int smallOrbig) {
		this.smallOrLarge = smallOrbig;
	}

}
