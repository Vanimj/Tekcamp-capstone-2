package com.game.components;

import java.awt.Color;

public abstract class Pixel {
    
    private Color color;
    private int shape;
    int xCoordinate[];
    int yCoordinate[];
    
    public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		this.shape = shape;
	}
	
}