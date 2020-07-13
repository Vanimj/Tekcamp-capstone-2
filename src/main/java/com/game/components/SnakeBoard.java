package com.game.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.game.constants.Direction;
import com.game.constants.GameConstants;
import com.game.exceptions.GameException;
import com.game.validations.GameValidations;

//@SuppressWarnings("serial")
public class SnakeBoard extends JPanel implements ActionListener {

	// flag to check whether game is in progress
	private boolean checkGameFlag = true;
	
	// Timer used to record tick times
	private Timer timer;
	
	// to control speed of the game
	private static int SPEED = 150;

	// Snake & Food instances for their actions. Used singleton for creating these classes.
	private Snake snake = Snake.getInstance();
	private Food food = Food.getInstance();
	
	private static SnakeBoard snakeBoard = null;	// Snake Board singleTon Object

	private SnakeBoard() {
	    addKeyListener(new KeyIdentifier());
	    setBackground(Color.BLACK);
	    setFocusable(true);
	    setPreferredSize(new Dimension(GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT));
	    initializeGame();
	}
	
	// Snake Board SingleTon method
	public static SnakeBoard getInstance() {
		if(snakeBoard==null)
			snakeBoard = new SnakeBoard();
		return snakeBoard;
	}
	
	
	

	// Used to paint our components to the screen
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    draw(g);
	}

	// Draw our Snake & Food (Called on repaint()).
	void draw(Graphics g) {
	    // Only draw if the game is running / the snake is alive
	    if (checkGameFlag == true) {
	    	food.setColor(Color.ORANGE);
	        g.setColor(food.getColor());
	        g.fillRect(food.getFoodX(0), food.getFoodY(0), GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE); // food
	
	        
		     // Draw our snake.
		        for (int i = 0; i < snake.getNoOfCells(); i++) {
		            // Snake's head
		            if (i == 0) {
		            	g.setColor(snake.getColor());
		                g.fillOval(snake.getSnakeX(i), snake.getSnakeY(i),
		                        GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
		                // Body of snake
		            } else {
		                g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i),
		                        GameConstants.PIXEL_SIZE, GameConstants.PIXEL_SIZE);
		            }
		        }
	        // Sync our graphics together
	        Toolkit.getDefaultToolkit().sync();
	    } else {
	        // If we're not alive, then we end our game
	        endGame(g);
	    }
	}

	void initializeGame() {
	    snake.initializeSnakeObject();
	    food.setSnakeObj(snake);
	    // Generate our first 'food'
	    // food.createFoodForSnake();
	    food.initializeFoodObject();
	
	    // set the timer to record our game's speed / make the game move
	    timer = new Timer(SPEED, this);
	    timer.start();
	}


	void endGame(Graphics g) {
	
	    // Create a message telling the player the game is over
	    String message = "Game over";
	
	    // Create a new font instance
	    Font font = new Font("Times New Roman", Font.BOLD, 14);
	    FontMetrics metrics = getFontMetrics(font);
	
	    // Set the color of the text to red, and set the font
	    g.setColor(Color.red);
	    g.setFont(font);
	
	    // Draw the message to the board
	    g.drawString(message, (GameConstants.BOARD_WIDTH - metrics.stringWidth(message)) / 2,
	            GameConstants.BOARD_HEIGHT / 2);
	
	    System.out.println("Game Ended");
	
	}

	// Run constantly as long as we're in game.
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (checkGameFlag == true) {
	    	
	        if(food.checkForCollisions()) {
	        	snake.setNoOfCells(snake.getNoOfCells() + 1);
	        	food.createFoodForSnake();
	        }
	        if(snake.checkForCollisions()) {
	        	checkGameFlag = false;
	        	timer.stop();
	        }else {
	        	snake.move();
	        }
	    }
	    // Repaint or 'render' our screen
	    repaint();
	}

	private class KeyIdentifier extends KeyAdapter {
	
	    @Override
	    public void keyPressed(KeyEvent e) {
	
	        int key = e.getKeyCode();
	        try {
	        	GameValidations.validateUserInput(key);
	        } catch(GameException geEx) {
	        	JOptionPane.showMessageDialog(null, geEx.getException(), "Error Message", JOptionPane.INFORMATION_MESSAGE);
	        }
	        
	        if (key == KeyEvent.VK_LEFT)
	        		snake.setDirection(Direction.LEFT);
	        else if(key == KeyEvent.VK_RIGHT)
	        	snake.setDirection(Direction.RIGHT);
	        else if (key == KeyEvent.VK_UP)
	        	snake.setDirection(Direction.UP);
	        else if (key == KeyEvent.VK_DOWN)
	        	snake.setDirection(Direction.DOWN);
	        else if ((key == KeyEvent.VK_ENTER) && (checkGameFlag == false)) {
	            checkGameFlag = true;
	            initializeGame();
	        }
	    }
	}


}