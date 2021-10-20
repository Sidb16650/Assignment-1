package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class MenuOptions {
	
	Scanner input;
	
	public MenuOptions() {
		input = new Scanner(System.in);
	}

	public char showOptionsMenu() {
		
		System.out.println("Select one of these options:");
		System.out.println("\t(P) Play game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit");
		System.out.println("Enter a choice:");
		char option = input.next().toLowerCase().charAt(0);
		return option; 
		
	}
	public char showSubMenu() {
		
		System.out.println("Select one of these options:");
		System.out.println("\t(T) Top player most number of wins");
		System.out.println("\t(L) Looking for a name");
		System.out.println("\t(B) Back to Main menu");
		System.out.println("Enter a choice:");
		char option = input.next().toLowerCase().charAt(0);
		return option;
		
	}
	
	public String promtName() {
		System.out.println("Enter name here");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showPlayer(Player ply) {
		
		System.out.println(ply);
		
	}
	
}
