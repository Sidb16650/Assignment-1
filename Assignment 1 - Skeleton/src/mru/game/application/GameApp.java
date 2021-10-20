package mru.game.application;

import java.io.FileNotFoundException;

import mru.game.controller.GameManager;

public class GameApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		// This is the starting point of the project!
		// hint - It usually calls method from GameManager class to start the app, so only one or two lines will be written here
		System.out.println("Welcome to the HighLowSame Game!");
		new GameManager().run();
	}

}
