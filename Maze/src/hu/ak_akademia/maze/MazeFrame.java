package hu.ak_akademia.maze;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MazeFrame extends KeyAdapter implements ActionListener {
	Timer timer;
	JFrame frame;
	Maze maze;
	TextArea mazeOnScreen;

	public MazeFrame(char[][] mazeInChar) {
		frame = new JFrame("A&K - Maze");
		timer = new Timer(1000, this);
		maze = new Maze();
		maze.setMaze(mazeInChar);
		maze.placeWeapon();
		maze.setFrame(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mazeOnScreen = new TextArea();
		mazeOnScreen.setFont(new Font("Monospaced", 0, 12));
		frame.add(mazeOnScreen);
		timer.start();
		mazeOnScreen.setText(maze.toString());
		frame.addKeyListener(this);
		frame.setSize(1024, 768);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
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
	public void keyTyped(KeyEvent e) {
		if (e == null) {
			return;
		}
		switch (e.getKeyChar()) {
		case 'a':
			maze.movePlayer("left");
			mazeOnScreen.setText(maze.toString());
			break;
		case 's':
			maze.movePlayer("down");
			mazeOnScreen.setText(maze.toString());
			break;
		case 'd':
			maze.movePlayer("right");
			mazeOnScreen.setText(maze.toString());
			break;
		case 'w':
			maze.movePlayer("up");
			mazeOnScreen.setText(maze.toString());
			break;
		case ' ':
			if(maze.getPlayer().isUseableWeapon()) {
				for(Enemy enemy : maze.getEnemies()) {
					enemy.setOnFlee(true);
				}
			}
			break;
		default:
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void stopTimer() {
		timer.stop();
	}

}
