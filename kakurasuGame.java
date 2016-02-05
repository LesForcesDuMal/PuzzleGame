package newGUI;

public class kakurasuGame extends theGame {
	
	static int[][] spots = new int[][]{
		 // 0  1  2  3   4  5
		
		  {0, 0, 0, 0},//1
		  {0, 0, 0, 0},//2
		  {0, 0, 0, 0},//3
		  {0, 0, 0, 0},//4
		  {0, 0, 0, 0},//5
		  }; //6 
	
	
	public kakurasuGame(String gameName, int value) {
		super(gameName, value);
		// TODO Auto-generated constructor stub
	}
	
	
	public static int[][] getGameSpots(){
		return spots; 
	}
	

}
