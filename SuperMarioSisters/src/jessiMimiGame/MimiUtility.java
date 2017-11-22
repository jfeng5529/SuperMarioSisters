package jessiMimiGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPCRoom;

public class MimiUtility {
	
	public static void print(String s){
		String printString = "";
		int cutoff = 55;
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			while(currentLine.length() + 
					nextWord.length() <= cutoff &&
					s.length() > 0){
				currentLine += nextWord;
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" ");
				if(endOfWord == -1){
					endOfWord = s.length() -1;
				}
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";

		}

		System.out.println(printString);
	}

	
	public static String waitForLetterInput(String letters){
		String input = CaveExplorer.in.nextLine();
		while(input.length() <1 || letters.toLowerCase().indexOf(input.toLowerCase().substring(0, 1))<0){
			System.out.print("That entry is not allowed. Please type on of the following: ");
			String list = "";
			for(int i = 0 ; i < letters.length()-1; i++){
				list += letters.substring(i, i+1)+",";
			}
			list += " or "+letters.substring(letters.length()-1); 
			System.out.println(list);
			input = CaveExplorer.in.nextLine();
		}
		return input.toLowerCase().substring(0, 1);
	}
}
	
