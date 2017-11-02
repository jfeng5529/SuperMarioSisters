package caveExplore;

public class Princess extends NPC {
	
	public Princess() {
		super();
	}
	
	public void act() {
		if(isActive()) {
			CaveExplorer.print("Far off in the distance, you hear a damsel in distress");
		}
		else {
			CaveExplorer.print("HI");
		}
		
	}
}
