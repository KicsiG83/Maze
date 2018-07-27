package hu.ak_akademia.maze;

public class TestMaze {
	String s01 = "+---+---+---+---+---+---+---+---+---+---+";
	String s02 = "            |           |               |";
	String s03 = "+---+---+   +---+   +   +   +---+---+   +";
	String s04 = "|   |       |       |   |           |   |";
	String s05 = "+   +   +---+   +---+---+---+---+   +   +";
	String s06 = "|   |   |           |               |   |";
	String s07 = "+   +   +---+---+   +   +---+---+---+   +";
	String s08 = "|   |           |       |           |   |";
	String s09 = "+   +---+---+   +   +---+   +---+---+   +";
	String s10 = "|           |   |           |           |";
	String s11 = "+   +   +---+   +---+   +---+   +---+   +";
	String s12 = "|   |       |   |       |       |   |   |";
	String s13 = "+   +---+   +   +---+---+   +---+   +   +";
	String s14 = "|   |       |               |       |   |";
	String s15 = "+---+   +---+---+---+---+---+   +   +   +";
	String s16 = "|       |           |           |       |";
	String s17 = "+   +---+   +---+   +   +---+---+---+---+";
	String s18 = "|           |   |       |               |";
	String s19 = "+   +---+---+   +---+---+---+   +---+   +";
	String s20 = "|                               |        ";
	String s21 = "+---+---+---+---+---+---+---+---+---+---+";
	
	
	public char[][] test() {
		char[][] probe = new char[21][41];
		probe[0] = s01.toCharArray();
		probe[1] = s02.toCharArray();
		probe[2] = s03.toCharArray();
		probe[3] = s04.toCharArray();
		probe[4] = s05.toCharArray();
		probe[5] = s06.toCharArray();
		probe[6] = s07.toCharArray();
		probe[7] = s08.toCharArray();
		probe[8] = s09.toCharArray();
		probe[9] = s10.toCharArray();
		probe[10] = s11.toCharArray();
		probe[11] = s12.toCharArray();
		probe[12] = s13.toCharArray();
		probe[13] = s14.toCharArray();
		probe[14] = s15.toCharArray();
		probe[15] = s16.toCharArray();
		probe[16] = s17.toCharArray();
		probe[17] = s18.toCharArray();
		probe[18] = s19.toCharArray();
		probe[19] = s20.toCharArray();
		probe[20] = s21.toCharArray();
		
		return probe;
		//String[] s = new String[21];
		//s = {s01, s02,s03,s04,s05,s06,s07,s08,s09,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21};
	}
}
