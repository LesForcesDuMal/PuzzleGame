package newGUI;

public class skyscraperGame extends theGame {
	

	public skyscraperGame(String gameName, int value) {
		super(gameName, value);
		// TODO Auto-generated constructor stub
	}


	static int[][] spots = new int[][]{
		 // 0  1  2  3   4  5
		
		  {0, 0, 0, 0},//1
		  {0, 0, 0, 0},//2
		  {0, 0, 0, 0},//3
		  {0, 0, 0, 0},//4
		  {0, 0, 0, 0},//5
		  }; //6 
	
	private int[] topRow = { 1, 2, 3, 4 };
	private int[] bottonRow = { 1, 2, 3, 4 };
	private int[] leftCol = { 1, 2, 3, 4 };
	private int[] rightCol = { 1, 2, 3, 4 };
	
	
	
	
	public static int[][] getGameSpots(){
		return spots; 
	}
	
	public void allDiffCol(){
		
		skyscraperConstraints.allDiffColCheck(); 
		
	}

}
