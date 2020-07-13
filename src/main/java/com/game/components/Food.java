package com.game.components;

import java.awt.Color;

import com.game.constants.GameConstants;

public class Food extends Pixel implements GameActions{

	private static Food foodInstance = null;	// SingleTon food object
	
	// Used to keep food at random location
	private final int RANDOM_POSITION = 30;
	
	private Snake snakeObj;	// Has a relationship

	private Food() {
		xCoordinate = new int[1];
		yCoordinate = new int[1];	
	}

	public static Food getInstance() {
		if(foodInstance==null)
			foodInstance = new Food();
		return foodInstance;
	}
	
	/**
	 * createFoodForSnake method creates food for snake at random location
	 */
	public void createFoodForSnake() {
	    // Set our food's x & y position to a random position
	    int location = (int) (Math.random() * RANDOM_POSITION);
	    int foodX = ((location * GameConstants.PIXEL_SIZE));
	    this.setFoodX(foodX);

	    location = (int) (Math.random() * RANDOM_POSITION);
	    int foodY = ((location * GameConstants.PIXEL_SIZE));
	    this.setFoodY(foodY);
	    Snake snakeHead = this.getSnakeObj();
	    if ((foodX == snakeHead.getSnakeX(0)) && (foodY == snakeHead.getSnakeY(0))) {
	    	createFoodForSnake();
	    }
	}
	/**
	 * initializeFoodObject method initializes defines Food properties
	 */
	public void initializeFoodObject() {
		this.createFoodForSnake();
		this.setColor(Color.ORANGE);
	}
	
	/**
	 * checkForCollisions method to check food collision with snake
	 */
	@Override
	public boolean checkForCollisions() {
		Snake snakeHead = this.getSnakeObj();
	    if ((proximity(snakeHead.getSnakeX(0), this.getFoodX(0), 20))
	            && (proximity(snakeHead.getSnakeY(0), this.getFoodY(0), 20))) {
	        System.out.println("intersection");
	        // Create new food
	        this.createFoodForSnake();
	        return true;
	    }
	   return false;
	}
	
	/**
	 * proximity method takes X & Y coordinates of snake head object to match 
	 * closeness to food location point.
	 * @param a
	 * @param b
	 * @param closeness
	 * @return
	 */
	private boolean proximity(int a, int b, int closeness) {
	    return Math.abs((long) a - b) <= closeness;
	}
	
	public int getFoodX(int index) {
	    return xCoordinate[index];
	}

	public int getFoodY(int index) {
	    return yCoordinate[index];
	}

	public void setFoodX(int i) {
	    xCoordinate[0] = i;
	}

	public void setFoodY(int i) {
	    yCoordinate[0] = i;
	}
	
	public Snake getSnakeObj() {
		return snakeObj;
	}

	public void setSnakeObj(Snake snakeObj) {
		this.snakeObj = snakeObj;
	}
}
