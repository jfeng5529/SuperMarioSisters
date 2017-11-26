package caveExplore;

import java.util.Scanner;

public class CaveExplorer {
	
	public static CaveRoom[][] caves; //every room in the cave.
	public static Scanner in; // for user input
	public static CaveRoom currentRoom; // changes based on how the user navigate
	public static Inventory inventory; // where all objects found in the cave are kept
	public static boolean playing =true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();

	}

	private static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("what would you like to do?");
			String input= in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}
	private static void npcActions() {
		for(NPC n: npcs) {
		if(n != null) {
				n.act();
			}
			
		}
		inventory.updateMap();
		
	}

	public static void print(String s) {
		//NOTE LATER YOU CAN REPLACE THIS LINE WITH THE MORE SOPHISCATED "MULTILINE" IN CHATBOT
		System.out.println(s);
	}
}