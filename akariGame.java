package newGUI;

public class akariGame extends theGame {
	
	static int[][] spots = new int[][]{
		 // 0  1  2  3   4  5
		
		  {0, 0, 0, -1},//1
		  {0, -1, 0, 0},//2
		  {0, 0, 1, 0},//3
		  {1, 0, 0, 0},//4
		  }; //6 
	
	public akariGame(String gameName, int value) {
		super(gameName, value);
		// TODO Auto-generated constructor stub
	}
	
	
	public static int[][] getGameSpots(){
		return spots; 
	}

}
