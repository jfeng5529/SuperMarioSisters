package janeLubnaGame;

import caveExplore.CaveExplorer;
import caveExplore.Inventory;
import caveExplore.NPCRoom;

public class JaneBackEnd implements LubnaSupport {

		private int candy;
		private JaneSupport frontend;
		private int enemiesCount;
		
	public JaneBackEnd(JaneSupport frontend) {
		enemiesCount=4;
		this.frontend=frontend;
		this.candy=frontend.getCandy();
	
	}
	public void setUpPlot() {
		setUpMap();
		setUpEnemies();
		setUpDoors();
	}
	public void setUpEnemies() {
		JaneEnemies[] enemies= new JaneEnemies[4];
		for (int i =0; i <4; i++) {
			enemies[i]=new JaneEnemies();
			enemies[i].setPosition(i+1,i+1);
		}
		frontend.setEnemies(enemies);
		frontend.setCurrentRoom(frontend.getPlots()[0][1]);
		frontend.getCurrentRoom().enter("x");
		
	}

	public boolean enemiesPresent() {
		return frontend.getEnemies() != null;
		
	}
	
	public void setUpDoors() {
		int height=5; int width=9;
		for(int row=0; row<5; row++) {
			for(int col=0; col<width; col++) {
				frontend.getPlots()[row][col].setConnection(JaneGameMap.EAST, frontend.getPlots()[row][col+1], new Object());
			}
		}
		for(int col=0; col<width; col++) {
			for(int row=0; row<height; row++) {
				frontend.getPlots()[row][col].setConnection(JaneGameMap.SOUTH, frontend.getPlots()[row][col+1], new Object());
			}
		}
	}

	public void setUpMap() {
		JaneGameMap[][] plots= new JaneGameMap[6][10]; 
		
		for(int row =0; row<plots.length; row++) {
			for(int col=0; col<plots[row].length; col++) {
				if(row==0 && col==0|| row==6 && col==0 || row==0&& col==9|| row==6&& col==0) {
					plots[row][col]=new JaneGameMap();
				}
				else
				{
					if((int)(Math.random())>.3) {
						plots[row][col]=new JaneGameMap();
						plots[row][col].setPresentCandy(true);
					}
				}
			}
		}
		frontend.setPlots(plots);
	}

	public boolean stillPlaying() {
		if(!JaneEnemies.getResult().equals("lost")&&candy>=(getTotalCandy()*.8)) {
			return true;
		}
		return false;
	}
	
	private double getTotalCandy() {
		JaneGameMap[][] plots= frontend.getPlots(); 
		int candyCount=0; 
		for(int row=0; row<plots.length; row++) {
			for( int col=0; col<plots[row].length; col++) {
				if(plots[row][col].isPresentCandy()) {
					candyCount++;
				}
			}
		}
		return candyCount; 
	}

	public boolean isValid(String input) {
		return "wasde".indexOf(input)>-1&&input.length()==1;
	}

	public void respondToKey(int direction) {
		if(direction==-1) {
			frontend.printAllowedEntry();
		}
		if(direction <4) {
		if(LubnaFrontEnd.currentRoom.getConnection(direction)!=null) {
			LubnaFrontEnd.currentRoom.leave();
			LubnaFrontEnd.currentRoom=LubnaFrontEnd.currentRoom.getBorderingRooms(direction);
			LubnaFrontEnd.currentRoom.enter("x");
			frontend.updatePlot();
			if(LubnaFrontEnd.currentRoom.isPresentCandy()) {
				LubnaFrontEnd.currentRoom.setPresentCandy(false);
				candy++;
			}
		}
		}
		else {
			performAction(direction);
		}
	}
	
	private void performAction(int direction) {
		if(enemiesPresent()) {
			LubnaFrontEnd.enemies[enemiesCount].interaction();
			enemiesCount--;
		 }
		 else {
			 CaveExplorer.print("There is nothing to interact with");
		 }
		
	}

	public static int enemiesCount() {
		return enemiesCount;
	}

	public void enemiesAction() {
		for (int i =0; i <4; i++) {
			LubnaFrontEnd.enemies[i].act();
		}
	}
	
	public static JaneSupport getFrontend() {
		return frontend;
	}
	public int getCandy() {
		return candy;
	}







}
