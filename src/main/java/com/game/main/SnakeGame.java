package com.game.main;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.game.components.SnakeBoard;

//@SuppressWarnings("serial")
public class SnakeGame extends JFrame {

	SnakeGame() {
	    add(SnakeBoard.getInstance());	// Single Ton SnakeBoard Object
	    setResizable(false);
	    pack();
	    setTitle("Snake Game");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		    // Creates a new thread so our GUI can process itself
			EventQueue.invokeLater(() -> {
				 JFrame frame = new SnakeGame();
		         frame.setVisible(true);
			});
	}
}