package caveExplore;

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}
	
	/** 
	 * can enter the room is theres no other NPC in the room
	 * @return
	 */
	public boolean canEnter() {
		return presentNPC==null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC =m;
	}
	
	public void leaveNPC() {
		presentNPC= null;
	}
	
	/** 
	 * very similar to the canEnter method but it is more logical to refer to this function
	 * especially if I decide to change the rules of 'canEnter"
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}

	
	//The above methods are NEW features to a CaveRoom,
	//The methods below REPLACE CaveRoom methods(Overrides)
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		System.out.println("You can only enter w, a, s, d to move or you can type 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction ==4) {
		 if(containsNPC()&&presentNPC.isActive) {
			 presentNPC.interact();
		 }
		 else {
			 CaveExplorer.print("There is nothing to interact with");
		 }
		}
		else {
		System.out.println("That key does nothing");
		}
		
	}
	
	public String getContents() {
		if(containsNPC()&& !presentNPC.isActive) {
			return "M";
		}
		else {
			//return what whould be returned otherwise
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC()&& !presentNPC.isActive) {
		return super.getDescription()+"\n"+presentNPC.getInactiveDescription();
		}
		else {
			String npcDescription="";
			if(presentNPC!=null) {
				npcDescription = presentNPC.getActiveDescription();
			}
			return super.getDescription()+"\n"+npcDescription;
		}
	}

	
}