package com.game.components;

import java.awt.Color;
import java.util.ArrayList;

import com.game.constants.Direction;
import com.game.constants.GameConstants;

public class Snake extends Pixel implements GameActions{

private static Snake snakeInstance = null;  // Snake Object Single Ton
private final int SNAKE_INITIAL_LENGTH = 3; // Initial Snake Body Length

	private Snake() { 
		xCoordinate = new int[GameConstants.getTotalPixels()];
		yCoordinate = new int[GameConstants.getTotalPixels()];	
	}

	public static Snake getInstance() {
		if(snakeInstance==null)
			snakeInstance = new Snake();
		return snakeInstance;
	}
	// To track snake direction 
	private Direction direction;

	// To increase snake length by adding cells
	private int noOfCells = 0;

	public int getNoOfCells() {
		return noOfCells;
	}
	
	public void setNoOfCells(int noOfCells) {
		this.noOfCells = noOfCells;
	}
	
	// Returns X-Coordinate index value
	public int getSnakeX(int index) {
	    return xCoordinate[index];
	}

	// Returns Y-Coordinate index value
	public int getSnakeY(int index) {
	    return yCoordinate[index];
	}

	// Sets X-Coordindate location value to Snake
	public void setSnakeX(int i) {
	    xCoordinate[0] = i;
	}

	// Sets Y-Coordinate location value to Snake
	public void setSnakeY(int i) {
	    yCoordinate[0] = i;
	}
	
	/**
	 * move method to move snake in all directions
	 */
	public void move() {
		for (int i = this.getNoOfCells(); i > 0; i--) {
	        // Moving X & Y coordinate values of the snake
	        xCoordinate[i] = xCoordinate[(i - 1)];
	        yCoordinate[i] = yCoordinate[(i - 1)];
	    }
		// Set Snake head X & Y coordinates based on direction
	    switch(direction) {
		    case LEFT:
		    	xCoordinate[0]-=GameConstants.getPixelSize();
		    	break;
		    case RIGHT:
		    	xCoordinate[0]+=GameConstants.getPixelSize();
		    	break;
		    case UP:
		    	yCoordinate[0]-=GameConstants.getPixelSize();
		    	break;
		    case DOWN:
		    	yCoordinate[0]+=GameConstants.getPixelSize();
		    	break;
		    default:
		    	xCoordinate[0]+=GameConstants.getPixelSize();
		    	break;
	    }
	}
	
	/**
	 * getDirection returns enum Direction Object
	 * @return Direction
	 */
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * createSnakeBody method initializes snake body X & Y coordinates
	 */
	public void createSnakeBody() {
		for (int i = 0; i < this.getNoOfCells(); i++) {
	        this.setSnakeX(GameConstants.BOARD_WIDTH / 2);
	        this.setSnakeY(GameConstants.BOARD_HEIGHT / 2);
	    }
	}

	/**
	 * initializeSnakeObject method prepares snake Object for the game
	 */
	public void initializeSnakeObject() {
		this.setNoOfCells(SNAKE_INITIAL_LENGTH);
		createSnakeBody();
		this.setDirection(Direction.RIGHT);
		this.setColor(Color.CYAN);
		//this.setShape(shape);
	}
	
	/**
	 * checkForCollisions method checks and returns true, if snake collides to itself or board border,
	 * else returns false
	 * @return boolean
	 */
	public boolean checkForCollisions() {
		boolean isSnakeBodyCollisionHappen = false;
		
		// Check if snake collides with its body
	    for (int i = this.getNoOfCells(); i > 0; i--) {
	        // Minimum sanke length should be 5 to intersect itself
	        if ((i > 5)
	                && (this.getSnakeX(0) == this.getSnakeX(i) && (this
	                        .getSnakeY(0) == this.getSnakeY(i)))) {
	        	isSnakeBodyCollisionHappen = true; // if snake collides to itself, stop the game
	        }
	    }
		
	    return (!isSnakeBodyCollisionHappen) ? checkForSnakeBorderCollisions() : isSnakeBodyCollisionHappen;
	}
	
	/**
	 * checkForSnakeBorderCollisions check for board border collisions and returns true if it collides,
	 * else it returns false.
	 * @return boolean
	 */
	/*public boolean checkForSnakeBorderCollisions() {
		boolean isBoardCollisionHappen = false;
		
		if (this.getSnakeY(0) >= GameConstants.BOARD_HEIGHT) {
			isBoardCollisionHappen = true;
	    }

	    if (this.getSnakeY(0) < 0) {
	    	isBoardCollisionHappen = true;
	    }

	    if (this.getSnakeX(0) >= GameConstants.BOARD_WIDTH) {
	    	isBoardCollisionHappen = true;
	    }

	    if (this.getSnakeX(0) < 0) {
	    	isBoardCollisionHappen = true;
	    }
		return isBoardCollisionHappen;
	}*/
	
	public boolean checkForSnakeBorderCollisions() {
		return ((this.getSnakeY(0) >= GameConstants.BOARD_HEIGHT) || (this.getSnakeY(0) < 0) ||
				(this.getSnakeX(0) >= GameConstants.BOARD_WIDTH) || (this.getSnakeX(0) < 0)) ? true : false;
	}
	
 }