package mru.game.model;

import java.util.Scanner;

public class HiLowSameGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	
	CardDeck playersDeck = new CardDeck();
	CardDeck bankersDeck = new CardDeck();
	
	public HiLowSameGame()
	{
		runGame();
	}
	
	public String option()
	{
		System.out.println("What is your bet on dealer's card?");
		System.out.println("\t(H) Higher");
		System.out.println("\t(L) Lower");
		System.out.println("\t(S) Same");
		
		System.out.print("Enter your choice: ");
		
		Scanner kb = new Scanner(System.in);
		
		String option = kb.nextLine().toUpperCase();
		
		while (!"H".equals(option) && !"L".equals(option) && !"S".equals(option)) {
			System.out.println("Invalid input! Please Try Again!");
			System.out.print("Enter a choice: ");
			option = kb.nextLine().toUpperCase();
		}
	
		return option;

	}
	
	public int bet()
	{
		int betAmount;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("How much do you want to bet this round? ");
		
		betAmount = kb.nextInt();
		
		return betAmount;
	}
		
	public void runGame()
	{		
		Scanner kb = new Scanner(System.in);
		

		
		String option = option();
		
		int betAmount = bet();
		
		System.out.println("\t\t --------High Low Same----");
		System.out.println("+------------------------------------------------------------+");
		System.out.println("\t Player \t   |\t  Dealer");
		System.out.println("+------------------------------------------------------------+");
		
		Card playCard = playersDeal(playersDeck);
		Card bankCard = bankersDeal(bankersDeck);
		
		String bankSuit = bankCard.getSuit();
		String playSuit = playCard.getSuit();
		
		int playRank = playCard.getRank();
		int bankRank = bankCard.getRank();
		
		System.out.println("+------------------------------------------------------------+");
		
		printGameResult(playRank, bankRank, option, bankSuit, playSuit, betAmount);

		playAgain();
		
	}
	
	
	
	public void playAgain()
	{
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Do you want to play again (Y/N)?");
		String again = kb.nextLine().toUpperCase();
		
		while(!"Y".equals(again) && !"N".equals(again))
		{
			System.out.println("Unknown option! Y/N?");
			again = kb.nextLine().toUpperCase();
		}
		
		switch(again)
		{
		case "Y":
			runGame();
			break;
		case "N":
			System.out.println("Bye!");
			break;
		}
		
		
	}
	
	public Card playersDeal(CardDeck playersDeck)
	{ 
		Card playCard; 
		
		playCard = playersDeck.getDeck().remove(0); 

		System.out.print(playCard);

		return playCard;
		
	}
	
	public Card bankersDeal(CardDeck bankersDeck)
	{
		Card bankCard; 

		bankCard = bankersDeck.getDeck().remove(0);

		System.out.println("\t\t\t" + bankCard);
			
		return bankCard;	
		
	}
	
	public void printGameResult(int playRank, int bankRank, String option, String bankSuit, String playSuit, int betAmount)
	{
		
		if (option.equals("H") && bankRank > playRank)
		{
			System.out.println("Congratulation! Player won " + betAmount);
			
		}
		else if(option.equals("L") && bankRank < playRank)
		{
			System.out.println("Congratulation! Player won " + betAmount);
		}
		else if(option.equals("S") && bankRank == playRank)
		{
			System.out.println("Congratulation! Player won " + 2 * betAmount);
		}
		else if(bankRank == playRank && bankSuit.equals(playSuit))
		{
			System.out.println("No one won or lost, TIE!");
		}
		else {
			System.out.println("Player lost " + betAmount);
		}
	}
	
	

}