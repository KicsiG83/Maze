package hu.ak_akademia.maze;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Ez az osztály figyeli a billentyűzetet.
 * @author balag
 *
 */

public class MoveListener extends KeyAdapter {
	TextField textFiled = new TextField();
	String direction;
	
	public String getDirection() {
		return direction;
	}
	@Override
	public void keyPressed(KeyEvent e){
		//System.out.println("Key Pressed: " + e.getKeyChar());
	}
	@Override
	public void keyReleased(KeyEvent e){
		//System.out.println("Key Released: " + e.getKeyChar());
	}
	@Override
	public void keyTyped(KeyEvent e){
		if(e == null) {
			return;
		}
		switch(e.getKeyChar()) {
		case 'a':
			textFiled.setText("Go left! ");
			direction = "left";
			break;
		case 's':
			textFiled.setText("Go down! ");
			direction = "down";
			break;
		case 'd':
			textFiled.setText("Go right! ");
			direction = "right";
			break;
		case 'w':
			textFiled.setText("Go up! ");
			direction = "up";
			break;
		default:
		}
	}
}
