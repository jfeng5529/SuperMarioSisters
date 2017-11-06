package caveExplore;

public class Inventory {
	private String map;
	private int money;
	private int life;
	
	public Inventory() {
		money=0;
		updateMap();
		life = 0;
		//
	}

	public void updateMap() {
		map=" ";
		//create line across the top
		for(int i=0; i<CaveExplorer.caves[0].length-1; i++) {
			map+="____";//4 underscores
		}
		map+="___\n"; // 3 underscores
		for(CaveRoom[]row: CaveExplorer.caves) {
			//3 row of text
			for(int i=0; i<3; i++) {
				String text ="";
				for(CaveRoom cr: row) {
					//if the door is open, leave open
					if(cr.getDoor(CaveRoom.WEST)!=null&&
						 cr.getDoor(CaveRoom.WEST).isOpen()) {
						text+=" ";
					}
					else {
						text+="|";
					}
					//content of room depend on what row this is
					if(i==0) {
						text+="   "; //3 spaces
					}
					else if(i==1) {
						text+=" "+cr.getContents()+" ";
					}
					else if(i==2) {
						if(cr.getDoor(CaveRoom.SOUTH)!=null&&cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text+="   ";// 3 spaces
						}
						else {
							text+="___";// 3 underscores
						}
					}
				}
				text+="|";
				map+=text+"\n";
				
			}
		}
	}

	public String getDescription() {
		return map;
	}
	public int getMoney() {
		return money;
	}
	public  int addLife() {
		return life++;
	}
	

}