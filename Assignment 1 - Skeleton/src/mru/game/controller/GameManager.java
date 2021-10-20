package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	

	public GameManager()  {
		players = new ArrayList<>();
		optionsMen = new MenuOptions();

		
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

	private void Search() {
		// TODO Auto-generated method stub
		char option = optionsMen.showSubMenu();
		
		switch (option) {
		
		case 'T':
			showTopPlayer();
			break;
		case 'L':
			Player ply = lookingForName();
			optionsMen.showPlayer(ply);
			break;
			
		case 'B':
			backToMenu();
			break;
		}
			
		
	}
		

	private void backToMenu() {
		// TODO Auto-generated method stub
		
	}

	private Player lookingForName() {
		// TODO Auto-generated method stub
		String name = optionsMen.promtName();
		Player ply = null;
		
		for (Player p: players) {
			if (p.getName().equals(name)) {
				ply = p;
				break;
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
				Player p = new Player(splittedLine[0],splittedLine[1], Integer.parseInt(splittedLine[2]));
				players.add(p); 
			}
			fileReader.close();
		}
	}
	
	
	private void showTopPlayer() {
		
	}
	


}
