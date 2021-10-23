package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.MenuOptions;

public class GameManager {
	
	/* In this class you will need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	MenuOptions optionsMen;
	Scanner input;
	

	public GameManager()  {
		players = new ArrayList<>();
		optionsMen = new MenuOptions();
		input = new Scanner(System.in);
		
	}
	
	public void run() throws FileNotFoundException {
		loadData();
		launchApplication();
	}

	private void launchApplication() throws FileNotFoundException {
		
		boolean flag = true;
		char option; 
		
		while (flag) {
			option = optionsMen.showOptionsMenu();
			
			switch (option) {
			
			case 'p':
				playGame();
				break;
			case 's':
				Search();
				break;
				
			case 'e':
				Save();
				flag = false;
				break;
				
			}
		}
	}

	private void playGame() {
		// TODO Auto-generated method stub
		
	}

	private void Search() throws FileNotFoundException {
		// TODO Auto-generated method stub
		char option = optionsMen.showSubMenu();
		
		switch (option) {
		
		case 't':
			showTopPlayer();
			
			break;
		case 'l':
			System.out.print("Enter name:");
			String lookForName = input.nextLine().trim().toUpperCase();
			lookingForName(lookForName);
			break;
			
			
		case 'b':
			launchApplication();
			break;
		}
			
		
	}
		

	private Player lookingForName(String lookForName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner nameScan  = new Scanner(System.in);
	
		
		String name = lookForName;
		int balance = 0;
		int win = 0;
		//optionsMen.promptName();
		Player ply = null;
		
		for (Player p: players) {
			if (p.getName().equals(lookForName)) {
				ply = p;
				name = ply.getName();
				win = ply.getNumberOfWin();
				balance = ply.getBalance();
				break;
			}
			
			else {
				name = "Player not found";
				win = 0;
				balance = 0;
			}
		}
		

		System.out.println("\t \t  - PLAYER INFO -");
		System.out.println("+====================+===============+====================+"); 
		System.out.println("| NAME               | # WINS        | BALANCE            |");
		System.out.println("+====================+===============+====================+");
		System.out.printf("%s%-19s%s%-14d%s%s%-17d%s", "| ", name , "| ", win , "| ", "$ ", balance , "|");
		System.out.print("\n");
		System.out.println("+--------------------+---------------+--------------------+ \n\n");
		System.out.println("Press 'Enter' to continue...");
		String enter = input.nextLine();
		while (enter != null) {
		if (enter.equals("")) {
		launchApplication();
		}
		}
		return ply;
		
	}

	
	private void Save() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
	for (Player p:players) {
		pw.println(p.format());
		System.out.println("Saved");
		
	}
	
		pw.close();
	}
	

	private void loadData() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if (db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while (fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player p = new Player(splittedLine[0],Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				players.add(p); 
			}
			fileReader.close();
		}
	}
	
	
	private void showTopPlayer() throws FileNotFoundException {
		Player topPlayer;
		String player;
		int win;
		int highestWin = Integer.MIN_VALUE;
		ArrayList<Integer> numberOfWin = new ArrayList<Integer>(); // create separate arraylist for number of wins of each players
		for (Player p: players) {
		numberOfWin.add(p.getNumberOfWin()); // add # wins into the list numberOfWin
		
			}
		System.out.println("\t \t - TOP PLAYER - ");
		System.out.println("+====================+=====================+");
		System.out.println("| NAME               | # WINS              |");
		System.out.println("+====================+=====================+");
		for (Player p: players) { // for each player in the playerList
		highestWin = Collections.max(numberOfWin); // highestWin = maximum value of #win in the previous numberofWin list
		if (p.getNumberOfWin() >= highestWin) { // if player's #wins >= highestWin
		if (p.getNumberOfWin() > highestWin) { // if player's #win > highest
		highestWin = p.getNumberOfWin(); // that #wins of player will be the new highest win
		}
		String topPlayerName = p.getName(); // get name of that highest wins player
		System.out.printf("%s%-19s%s%-20d%s","| ",topPlayerName,"| ", highestWin ,"|\n");
		System.out.println("+--------------------+---------------------+");
		}
		}
		System.out.println("\n");
		System.out.println("Press 'Enter' to continue...");
		String enter = input.nextLine();
		while (enter != null) {
		if (enter.equals("")) {
		launchApplication();
	
		
		}
	
	
		}

	}
}
	



