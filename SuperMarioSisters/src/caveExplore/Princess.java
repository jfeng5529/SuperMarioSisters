package caveExplore;

public class Princess extends NPC {
	 private String content;
	public Princess() {
		super();
		content = "P";
	}
	
	public void act() {
		if(isActive()) {
<<<<<<< HEAD
			CaveExplorer.print("Far off in the distance, you hear a Prince in distress.");
=======
			CaveExplorer.print("Far off in the distance, you hear a prince in distress.");
>>>>>>> refs/heads/master
		}
		else {
			CaveExplorer.print("HI");//
		}
		
	}
	public String getSymbol() {
		return content;
	}
}
