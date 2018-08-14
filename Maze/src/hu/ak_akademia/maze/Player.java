package hu.ak_akademia.maze;

public class Player extends Movable {
	private String name;
	private char symbolInMaze = '$';
	private boolean useableWeapon;
	
	public Player() {
		super.coorX = 1;
		super.coorY = 0;
	}
	public String getName() {
		return name;
	}
	@Override
	public char getSymbolInMaze() {
		return symbolInMaze;
	}
	public boolean isUseableWeapon() {
		return useableWeapon;
	}
	public void setUseableWeapon(boolean useableWeapon) {
		this.useableWeapon = useableWeapon;
	}
	public void pickUpWeapon() {
		useableWeapon = true;
		
	}
	
}
