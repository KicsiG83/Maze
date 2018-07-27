package hu.ak_akademia.maze;

import java.awt.TextArea;

import javax.swing.JFrame;

public class MazeFrame {
	JFrame frame;
	
	public MazeFrame() {
		frame = new JFrame("A&K - Maze");
		Maze maze = new Maze();
		maze.setMaze(new TestMaze().test());
		MoveListener listen = new MoveListener();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextArea mazeOnScreen = new TextArea();
		frame.add(mazeOnScreen);
		mazeOnScreen.setText(maze.toString());
		frame.add(listen.textFiled,"South");
		frame.addKeyListener(listen);
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
	}
}
