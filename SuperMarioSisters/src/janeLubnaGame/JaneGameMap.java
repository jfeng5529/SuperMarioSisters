package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.CaveRoom;
import caveExplore.NPC;
import caveExplore.NPCRoom;
import caveExplore.Princess;
import jessiMimiGame.JessiMerchantRoom;
import jessiMimiGame.MimiRoom;

public class JaneGameMap extends CaveRoom {
	
	private Candy candy;
	
	public JaneGameMap(String description) {
		super(description);
		candy= new Candy();
	}
	
	public static void setUpCaves() {
		CaveExplorer.caves=new NPCRoom[6][10];
		for(int row =0; row<CaveExplorer.caves.length; row++) {
			for(int col=0; col<CaveExplorer.caves[row].length; col++) {
				CaveExplorer.caves[row][col]=new NPCRoom("Room");
			}
		}
		
		CaveExplorer.npcs =new NPC[2];
		CaveExplorer.npcs[0] = new Princess();
		CaveExplorer.npcs[0].setPosition(5, 9);
		CaveExplorer.npcs[1] = new BooNPC();
		CaveExplorer.npcs[1].setPosition(1, 3);//
		CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//set up doors
		setUpDoors();
		
		
	}
	
	public static void setUpDoors() {
		CaveRoom[][] =CaveExplorer.caves;
	}
	
	public void enter() {
		super.enter();
		LubnaFrontEnd.bag.addPoints();
	}
}
