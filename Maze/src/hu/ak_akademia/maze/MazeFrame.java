package hu.ak_akademia.maze;


import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MazeFrame extends KeyAdapter implements ActionListener  {
	Timer timer;
	JFrame frame;
	Maze maze;
	TextArea mazeOnScreen;
	TextField tf = new TextField();
	
	public MazeFrame(char[][] mazeInChar) {
		frame = new JFrame("A&K - Maze");
		timer = new Timer(1000,this);
		maze = new Maze();
		maze.setMaze(mazeInChar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mazeOnScreen = new TextArea();
		mazeOnScreen.setFont(new Font("Monospaced",0,12));
		frame.add(mazeOnScreen);
		timer.start();
		mazeOnScreen.setText(maze.toString());
		frame.addKeyListener(this);
		frame.setSize(500, 650);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		frame.add(tf,"South");
	}

	public Maze getMaze() {
		return maze;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		maze.moveEnemies();
		mazeOnScreen.setText(maze.toString());
		
	}
	@Override
	public void keyTyped(KeyEvent e){
		if(e == null) {
			return;
		}
		switch(e.getKeyChar()) {
		case 'a':
			 tf.setText("balra");
			 maze.movePlayer("left");
			 mazeOnScreen.setText(maze.toString());
			break;
		case 's':			
			tf.setText("le"); 
			maze.movePlayer("down");
			 mazeOnScreen.setText(maze.toString());
			break;
		case 'd':
			tf.setText("jobbra");
			 maze.movePlayer("right");
			 mazeOnScreen.setText(maze.toString());
			break;
		case 'w':
			tf.setText("fel");
			maze.movePlayer("up");
			mazeOnScreen.setText(maze.toString());
			break;
		default:
		}
	}
}
