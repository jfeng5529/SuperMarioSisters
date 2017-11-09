package caveExplore;

public class Princess extends NPC {
	 private String content;
	public Princess() {
		super();
		content = "P";
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
}
