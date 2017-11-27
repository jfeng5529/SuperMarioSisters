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
			System.out.println(inventory.getDescription());
			print(currentRoom.getDescription());
			print("what would you like to do?");
			String input= in.nextLine();
			currentRoom.interpretInput(input);
		}
		System.out.println("                    SUPER HAPPY EVER AFTER !!!");
		System.out.println("                 __________Game Over__________\n");
		
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
		String printString = "";
		int cutoff = 100;
		//this while loop last as long as there are words left in the original String
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}
}