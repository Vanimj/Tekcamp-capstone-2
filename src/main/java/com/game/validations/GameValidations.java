package com.game.validations;

import java.awt.event.KeyEvent;

import com.game.exceptions.GameException;

public class GameValidations {

	public static void validateUserInput(int input) throws GameException {
		if(!(KeyEvent.VK_LEFT==input || KeyEvent.VK_RIGHT==input || KeyEvent.VK_UP==input || KeyEvent.VK_DOWN==input))
			throw new GameException("User provided invalid input");
		//return (input=='L'||input=='R'||input=='U'||input=='D') ? true : false;
	}
	
}
