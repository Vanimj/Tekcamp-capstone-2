package com.game.constants;

public interface GameConstants {

	public static final int BOARD_WIDTH = 1000; 	// Represents board width
    public static final int BOARD_HEIGHT = 980; 	// Represents board height
    public static final int START_X = BOARD_WIDTH / 2;  // Represents Center X-Coordinate
    public static final int START_Y = BOARD_HEIGHT / 2; // Represents Center Y-Coordinate
    
    // Represents Pixel size for Food & Snake
    public static final int PIXEL_SIZE = 25;
    
    // Represents total number of pixels on board (screen)
    public static final int TOTAL_PIXELS = (BOARD_WIDTH * BOARD_HEIGHT)
            / (PIXEL_SIZE * PIXEL_SIZE);
    
    /**
     * getTotalPixels returns total pixel length on board
     * @return
     */
    public static int getTotalPixels() {
    	return TOTAL_PIXELS;
    }
    
    /**
     * getPixelSize returns pixel size
     * @return
     */
    
    public static int getPixelSize() {
    	return PIXEL_SIZE;
    }
}
