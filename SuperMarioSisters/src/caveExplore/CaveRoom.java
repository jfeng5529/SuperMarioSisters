package caveExplore;

import janeLubnaGame.BooNPC;
import janeLubnaGame.JanePipeRoom;
import janeLubnaGame.LubnaFlashLights;
import janeLubnaGame.LubnaToadAdvise;
import jessiMimiGame.Bowser;
import jessiMimiGame.JessiMerchantRoom;
import jessiMimiGame.MimiRoom;

public class CaveRoom {

	private String description; // tells what the room looks like
	private String direction;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organize by direction, "null" signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	private int[] currentPlot;
	private boolean row;

	//constants
	public static final int NORTH=0;
	public static final int EAST=1;
	public static final int SOUTH=2;
	public static final int WEST=3;

	public CaveRoom(String description) {
		row=true;
		currentPlot= new int[2];
		this.description=description;
		setDefaultContents(" ");
		contents=defaultContents;
		//difference between default content and content is 'content" becomes a x when you are inside this room
		//when you leave, it goes back to the defaultcontent

		//by default, arrays will populate with 'null', meaning theres no directions
		borderingRooms=new CaveRoom[4];
		doors=new Door[4];
		setDirections();
	}

	/**
	 * For every door in the door array, appends a string to "direction" describing the access
	 * for example:
	 * "There is a door to the north"
	 * "there is a door to the south"
	 * if there are no doors at the all, direction should say:
	 * "There are no doors, you are trapped in here"
	 */
	private void setDirections() {
		direction="";
		boolean doorFound=false;
		for(int i=0; i<doors.length; i++) {
			if(doors[i]!=null) {
				doorFound=true;
				direction+="\n  There is a "+doors[i].getDescription()+" to "+
						toDirection(i)+ "." +doors[i].getDetails();
			}
		}
		if(!doorFound) {
			direction+="There are no doors, you are trapped in here";
		}

	}

	/**
	 * converts an int into a direction
	 * toDirection(0) -> "the north"
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] arr= {"the North", "the East", "the South", "the West"};
		return arr[dir];

	}

	public void enter() {
		contents="x";

	}
	public void leave() {
		contents=defaultContents;
	}

	/**
	 * gives this room access to anotherRoom(and vice-versa and sets a door between them,
	 * updating the direction
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppsiteDirection(direction), this, door);
	}
	public static int oppsiteDirection(int direction) {
		return (direction+2)%4;
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction]=cave;
		doors[direction]=door;
		setDirections();

	}

	public void interpretInput(String input) {
		while(!isValid(input)) {
			printAllowedEntry();
			input=CaveExplorer.in.nextLine();
		}
		//convert user input into a direction		
		String dir=validKeys();
		respondToKey(dir.indexOf(input));
	}

	//override to add more keys
	public String validKeys() {
		return "wdsa";
	}
	//override to print a custom string describing what the keys do
	public void printAllowedEntry() {
		System.out.println("You can only enter w, a, s, d");
	}

	public boolean isValid(String input) {
		String validEntries=validKeys();
		return validEntries.indexOf(input)>-1&&input.length()==1;
	}

	public void respondToKey(int direction) {
		//first protect against null pointer exception(user cannot go through non-existent door
		if(direction <4) {
			if(borderingRooms[direction]!=null&&doors[direction]!=null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom=borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}
		else {
			performAction(direction);
		}
	}

	/**
	 * Override to give response to keys other than wasd
	 * @param direction
	 */
	public void performAction(int direction) {
		System.out.println("That key does nothing");

	}

	/**
	 * This will be where your group sets up all the caves and all the connections 
	 */
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. decide hoe bog your cave should be
		CaveExplorer.caves=new NPCRoom[6][10]; // everyroom now is a NPC room can be changed later
		//2. Populate with caves with a default descriptions: when starting use coordinates
		for(int row =0; row<CaveExplorer.caves.length; row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE
			for(int col=0; col<CaveExplorer.caves[row].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col]=new NPCRoom("this cave has coords("+row+","+col+")");
			}
		}
		//3.replace default room with custom room
		//DO LATER
		CaveExplorer.npcs =new NPC[2];
		CaveExplorer.npcs[0] = new Princess();
		CaveExplorer.npcs[0].setPosition(5, 9);
		CaveExplorer.npcs[1] = new BooNPC();
		CaveExplorer.npcs[1].setPosition(2, 7);
		CaveRoom customRoom = new JanePipeRoom("Room");
		CaveExplorer.caves[4][9] = customRoom;
				CaveRoom customRoom2 = new LubnaFlashLights("Room");
				CaveExplorer.caves[3][3] = customRoom2;
				CaveRoom customRoom3 = new JessiMerchantRoom("Room");
				CaveExplorer.caves[3][1] = customRoom3;
				CaveRoom customRoom4 = new MimiRoom("Room");
				CaveExplorer.caves[3][4] = customRoom4;
				CaveRoom customRoom6 = new BowserRoom("Room");
				CaveExplorer.caves[5][8] = customRoom6;
		CaveRoom customRoom5 = new LubnaToadAdvise("Room");
		CaveExplorer.caves[1][1] = customRoom5;
		//4.set your starting room:
		CaveExplorer.currentRoom=CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//set up doors
		CaveRoom[][]c=CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		c[1][2].setConnection(EAST, c[1][3], new Door());
		c[1][3].setConnection(SOUTH, c[2][3], new Door());
		c[2][3].setConnection(SOUTH, c[3][3], new Door());
		c[3][4].setConnection(EAST, c[3][5], new Door());
		c[3][5].setConnection(EAST, c[3][6], new Door());
		c[3][6].setConnection(EAST, c[3][7], new Door());
		c[3][7].setConnection(EAST, c[3][8], new Door());
		c[3][8].setConnection(EAST, c[3][9], new Door());
		c[4][8].setConnection(EAST, c[4][9], new Door());
		c[3][8].setConnection(SOUTH, c[4][8], new Door());
		c[4][8].setConnection(SOUTH, c[5][8], new Door());
		c[3][4].setConnection(SOUTH, c[4][4], new Door());
		c[4][4].setConnection(SOUTH, c[5][4], new Door());
		c[5][4].setConnection(EAST, c[5][5], new Door());
		c[5][5].setConnection(EAST, c[5][6], new Door());
		c[5][6].setConnection(EAST, c[5][7], new Door());
		c[5][7].setConnection(EAST, c[5][8], new Door());
		c[1][1].setConnection(WEST, c[1][0], new Door());
		c[1][3].setConnection(EAST, c[1][4], new Door());
		c[1][4].setConnection(SOUTH, c[2][4], new Door());
		c[2][4].setConnection(SOUTH, c[3][4], new Door());
		c[2][3].setConnection(EAST, c[2][4], new Door());
		c[1][1].setConnection(SOUTH, c[2][1], new Door());
		c[2][1].setConnection(EAST, c[2][2], new Door());
		c[2][2].setConnection(SOUTH, c[3][2], new Door());
		c[3][2].setConnection(EAST, c[3][3], new Door());
		c[3][3].setConnection(SOUTH, c[4][3], new Door());
		c[3][3].setConnection(EAST, c[3][4], new Door());
		c[4][3].setConnection(EAST, c[4][4], new Door());
		c[1][4].setConnection(NORTH, c[0][4], new Door());
		c[1][4].setConnection(EAST, c[1][5], new Door());
		c[1][5].setConnection(EAST, c[1][6], new Door());
		c[1][6].setConnection(NORTH, c[0][6], new Door());
		c[1][6].setConnection(EAST, c[1][7], new Door());
		c[2][7].setConnection(EAST, c[2][8], new Door());
		c[4][7].setConnection(EAST, c[4][8], new Door());
		c[2][7].setConnection(SOUTH, c[3][7], new Door());
		c[1][7].setConnection(SOUTH, c[2][7], new Door());
		c[2][8].setConnection(SOUTH, c[3][8], new Door());
		c[3][7].setConnection(SOUTH, c[4][7], new Door());
		c[4][7].setConnection(SOUTH, c[5][7], new Door());
		c[4][9].setConnection(SOUTH, c[5][9], new Door());
		c[5][8].setConnection(EAST, c[5][9], new Door());


		for(int col=0; col<4; col++) {
			c[col+1][col].setConnection(SOUTH, c[col+2][col], new Door());
			c[col+2][col].setConnection(EAST, c[col+2][col+1], new Door());
		}


		for(int col=6; col<9; col++) {
			c[col-6][col+1].setConnection(SOUTH, c[col-5][col+1], new Door());
			c[col-6][col].setConnection(EAST, c[col-6][col+1], new Door());
		}

	}
	
	public String getDescription() {
		return description+"\n"+direction;//
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public Door getDoor(int direction) {
		if(direction>=0&& direction < doors.length) {
			return doors[direction];
		}
		else {
			return null;
		}
	}



}