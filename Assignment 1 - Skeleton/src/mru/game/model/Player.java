package mru.game.model;

public class Player {
	
	public Player(String name, int numberOfWin, int balance) {
		this.name = name;
		this.balance = balance;
		this.numberOfWin = numberOfWin;
	}
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	String name; 
	int numberOfWin;
	int balance;
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public char[] format() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getNumberOfWin() {
		return numberOfWin;
		// TODO Auto-generated method stub
		
	}
	
	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
	
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setNumberOfWin(int numberOfWin) 
	{
		this.numberOfWin = numberOfWin;
	}
	
	
}

