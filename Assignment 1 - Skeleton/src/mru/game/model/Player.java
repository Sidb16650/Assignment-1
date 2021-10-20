package mru.game.model;

public class Player {
	
	public Player(String name, String id, int numOfWins) {
		this.name = name;
		this.id = id;
		this.numOfWins = numOfWins;
	}
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	String name;
	String id; 
	int numOfWins;
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] format() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

