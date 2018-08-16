package hu.ak_akademia.maze;

public class Print {

	public void welcome() {
		System.out.println("**********************************************");
		System.out.println("*        ┬ ┬┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┌┬┐┌─┐       *");
		System.out.println("*        │││├┤ │  │  │ ││││├┤    │ │ │       *");
		System.out.println("*        └┴┘└─┘┴─┘└─┘└─┘┴ ┴└─┘   ┴ └─┘       *");
		System.out.println("*     ███╗   ███╗ █████╗ ███████╗███████╗    *");
		System.out.println("*     ████╗ ████║██╔══██╗╚══███╔╝██╔════╝    *");
		System.out.println("*     ██╔████╔██║███████║  ███╔╝ █████╗      *");
		System.out.println("*     ██║╚██╔╝██║██╔══██║ ███╔╝  ██╔══╝      *");
		System.out.println("*     ██║ ╚═╝ ██║██║  ██║███████╗███████╗    *");
		System.out.println("*     ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    *");
		System.out.println("*                                            *");
	}

	public void menu() {
		System.out.println("**********************************************");
		System.out.println("** [1] Start Game  [2] Created By  [3] Exit **");
		System.out.println("**********************************************");
	}

	public void createdBy() {
		System.out.printf("%-30s- %s%n", "Nagy Balázs", " ....");
		System.out.printf("%-30s- %s%n", "Ölvedi Artúr", " ....");
		System.out.printf("%-30s- %s%n", "Balogh Gergely", " ....");
		System.out.printf("%-30s- %s%n", "Maze frame", "https://rosettacode.org/wiki/Maze_generation#Java");
	}

	public void bye() {
		System.out.println("**********************************************");
		System.out.println("**          Hope, to see you soon!          **");
		System.out.println("**                 Goodbye!                 **");
		System.out.println("**********************************************");
	}

	public void gameOver() {
		System.out.println(" ▄▄ •  ▄▄▄· • ▌ ▄ ·. ▄▄▄ .           ▌ ▐·▄▄▄ .▄▄▄  ▄▄ ");
		System.out.println("▐█ ▀ ▪▐█ ▀█ ·██ ▐███▪▀▄.▀·    ▪     ▪█·█▌▀▄.▀·▀▄ █·██▌");
		System.out.println("▄█ ▀█▄▄█▀▀█ ▐█ ▌▐▌▐█·▐▀▀▪▄     ▄█▀▄ ▐█▐█•▐▀▀▪▄▐▀▀▄ ▐█·");
		System.out.println("▐█▄▪▐█▐█ ▪▐▌██ ██▌▐█▌▐█▄▄▌    ▐█▌.▐▌ ███ ▐█▄▄▌▐█•█▌.▀ ");
		System.out.println("·▀▀▀▀  ▀  ▀ ▀▀  █▪▀▀▀ ▀▀▀      ▀█▄▀▪. ▀   ▀▀▀ .▀  ▀ ▀ ");
	}

	public void youWon() {
		System.out.println("   ╦ ╦┌─┐┬ ┬  ┬ ┬┌─┐┬  ┬┌─┐  ┌─┐┌─┐┌─┐┌─┐┌─┐┌─┐┌┬┐ ");
		System.out.println("   ╚╦╝│ ││ │  ├─┤├─┤└┐┌┘├┤   ├┤ └─┐│  ├─┤├─┘├┤  ││ ");
		System.out.println("    ╩ └─┘└─┘  ┴ ┴┴ ┴ └┘ └─┘  └─┘└─┘└─┘┴ ┴┴  └─┘─┴┘o");
	}

	public void youLose() {
		System.out.println("             ╦ ╦┌─┐┬ ┬  ┬  ┌─┐┌─┐┌─┐ ");
		System.out.println("             ╚╦╝│ ││ │  │  │ │└─┐├┤  ");
		System.out.println("              ╩ └─┘└─┘  ┴─┘└─┘└─┘└─┘o");
	}

}
