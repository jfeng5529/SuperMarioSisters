package caveExplore;

public class Princess extends NPC {
	 private String content;
	 private String interactDescription;
	public Princess() {
		super("You finally rescue the prince has been waiting for you! \nMaria I knew I could depend on you! I shall love you forever~ \n Press 'e' to talk to me.");
		content = "P";
		interactDescription="\"Uh um honey. You are not going anywere Maria. press 'e' for HAPPY ENDING!";
	}
	
	public String getInteractDescription(){
		return interactDescription;
	}
	
	public void act() {
		if(isActive()) {
			CaveExplorer.print("Far off in the distance, you hear a Prince in distress.");
		}
		else {
			CaveExplorer.print("HI");
		}
		
	}
	public String getSymbol() {
		return content;
	}
	
	public void interact() {
		super.setActive(false);
		CaveExplorer.print("I know. Bowser is nothing compare to your strength and our love. Thank you Maria! \n");
		CaveExplorer.playing=false;
	}

}