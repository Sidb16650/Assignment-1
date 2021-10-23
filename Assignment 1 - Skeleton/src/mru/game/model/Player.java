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
	public int getBalance;
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public char[] format() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getNumberOfWin() {
		return numOfWins;
		// TODO Auto-generated method stub
		
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

