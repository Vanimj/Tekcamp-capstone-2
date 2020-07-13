package com.game.exceptions;

public class GameException extends Exception {

	private String exception = null;

	public GameException(String exception) {
		this.exception = exception;
	}
	
	public GameException() {
		super();
	}
	
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	
	public String toString () {
		return getException();
	}
}
