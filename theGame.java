package newGUI;

public class theGame {


	private static String name; // will need to change
	private int num;
	private int[] theGameButtons;
	private static int[][] spots; 


	//public static int[][] getGameSpots() {
	//	return gameSpots;
	//}

	//public static String getGameType() {
	//	return "Skyscraper";
	//}

	// private static String name = "cat";

	// the Bicycle class has one constructor
	public theGame(String gameName, int buttonNumber) {
		name = gameName;
		num = buttonNumber;
		// speed = startSpeed;
	}


	// here we will have the game set up stuff
	//
	// - how many buttons we need
	// - which init layout to use
	// -
	//

	// what will not be here - constraints?

	public static String getGameName() {
		return name;
	}
	
	public static int[][] getGameSpots(){
		return spots; 
	}

	// arbitrary right now, just getting it to work.
	//public static int getNumberGameButtons() {
	//	return 14;
	//}

	// if have time, add a clear ability to this

}
