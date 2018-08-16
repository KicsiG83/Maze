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
		System.out.println("** [1] Start Game  [2] About Maze  [3] Exit **");
		System.out.println("**********************************************");
	}

	public void aboutMaze() {
		System.out.println("Control:");
		System.out.println("\t up - w");
		System.out.println("\t down - s");
		System.out.println("\t left - a");
		System.out.println("\t right - d");
		System.out.println("\t action - space");
		System.out.println("\tif player use action enemies will flee from player 'til 5 seconds");
		System.out.println();
		System.out.println("Settings:");
		System.out.println("\t size:");
		System.out.println("\t\t esay - 10 x 10");
		System.out.println("\t\t normal - 20 x 20");
		System.out.println("\t\t hard - 30 x 30");
		System.out.println("\t number of eneimes is proportionate to size: easy - normal - hard");
		System.out.println("\t\t esay: 0 - 1 - 2");
		System.out.println("\t\t normal: 1 - 2 - 3");
		System.out.println("\t\t hard: 1 - 2 - 3");
		System.out.println("\t aggressiveness:");
		System.out.println("\tif player is closer to an enemy, like the aggressiveness,");
		System.out.println("\tthen enemy will take aggressive move");
		System.out.println("\t\t esay - 4");
		System.out.println("\t\t normal - 7");
		System.out.println("\t\t hard - 10");
		System.out.println();
		System.out.println("Enemies:");
		System.out.println("\t on board:");
		System.out.println("\t\t O - normal move:");
		System.out.println("\t\tEnemy will take a move in a random direction");
		System.out.println("\t\t ő - aggressive move:");
		System.out.println("\t\tEnemy will take a move to direction of player");
		System.out.println("\t\t o - flee:");
		System.out.println("\t\tEnemy will take a move to opposite direction of player");
		System.out.println();
		System.out.println("Credits:");	
		System.out.println("Produced by - A&K Játékbolt");	
		System.out.println("Implemented by - pinCoding GmbH");	
		System.out.println("Directed by - Balogh Gergely");	
		System.out.println("Maze by - https://rosettacode.org/wiki/Maze_generation#Java");	
		System.out.println("Customized the Maze by - Balogh Gergely");	
		System.out.println("Frame by - Nagy Balázs");
		System.out.println("Menu by - Ölvedi Artúr");
		System.out.println("GameSetting by - Ölvedi Artúr");
		System.out.println("Game by - Nagy Balázs");
		System.out.println();
		bye();
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
