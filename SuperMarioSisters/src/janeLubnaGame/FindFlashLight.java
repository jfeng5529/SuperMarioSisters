package janeLubnaGame;

import caveExplore.NPCRoom;

public class FindFlashLight extends NPCRoom {

	public FindFlashLight(String description) {
		super(description);
		 getLife();
	}
	public void getLife() {
		 life = 0;
		if(containsNPC() == true) {
			life++;
		}
		}
		}
		
}	
