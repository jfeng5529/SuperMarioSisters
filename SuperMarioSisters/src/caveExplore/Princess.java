package caveExplore;

public class Princess extends NPC {
	 private String content;
	public Princess() {
		super("The prince has been waiting for you to rescue him. \nMaria I knew I could depend on you! I shall love you forever~");
		content = "P";
	}
	
	public void act() {//
		if(isActive()) {
			CaveExplorer.print("Far off in the distance, you hear a Prince in distress.");
		}
		
	}
	public String getSymbol() {
		return content;
	}
	
	public void interact() {
		super.setActive(false);
		CaveExplorer.print("I know. Bowser is nothing compare to your strength and our love. Thank you Maria!");
	}
	public void respondToKey(int direction) {
		CaveExplorer.print("You are not going anywere Maria. HAPPY ENDING!");
	}
}
