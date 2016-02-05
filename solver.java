package newGUI;

//theGame g = new Skyscraper();
//constraints will be linked thru gam class

public class solver {

	
	private static int spots[][]; 
	private static String gameType;
	private static theGame game; 

	static int[][] newSpots = game.getGameSpots();
	
	
	private static boolean gameStatus;

	// MASTER CHECK METHOD - just to see what has been helped
	public static boolean checkGameStatus() {

	//Need a if(gameIsSkyscraper){
	if(theGame.getGameName().equals("Skyscraper")){
			if (skyscraperConstraints.allSkyscraperConstraint() == false) {
				gameStatus = false;
				System.out
						.println("checkGameStatus: Skyscraper's constraints are not met");
			} else {
				gameStatus = true;
				System.out.println("checkGameStatus: Skyscraper is ok to go");
			}
		}
	
	if(theGame.getGameName().equals("Akari")){
		if (akariConstraints.allAkariConstraint() == false) {
			gameStatus = false;
			System.out
					.println("checkGameStatus: Akari's constraints are not met");
		} else {
			gameStatus = true;
			System.out.println("checkGameStatus: Akari is ok to go");
		}
	}
	
	if(theGame.getGameName().equals("kakurasu")){
		if (kakurasuConstraints.allKakurasuConstraint() == false) {
			gameStatus = false;
			System.out
					.println("checkGameStatus: kakurasu's constraints are not met");
		} else {
			gameStatus = true;
			System.out.println("checkGameStatus: kakurasu is ok to go");
		}
	}

	return gameStatus;
			
	}//END OF MASTERCHECK
	
	
	

	//THE LABELER
	public boolean checking() {
		
		//when you hit the end of the row of the array, start check if values are alright and then change if needed
	
		for (int r = 0; r < newSpots[0].length + 1; r++) { // goes through rows?
			for (int c = 0; c < newSpots[r].length; c++) {
				int value = 0;
				System.out.println("[" +r + "]" + "[" + c + "]" + " with value " + newSpots[r][c]);
					
				}

					//needs recursion step, unfortunately it was constructed but did not compile
			}
		
		
		return true; 
		
	}//end of checking
	  


public static void printFormat(){
  	 
  	 for (int c = 0; c < spots.length; c++) {//col
  		    for (int k = 0; k < spots.length-1; k++) {//row
  		    	
  		        System.out.print(spots[c][k] + " ");
  		    }
  		    System.out.print("\n");
  		}
	}

//traverse through the spots
public static void goThrough(){

		for (int j = 0; j<spots[0].length+1; j++){
		     for (int i = 0; i<spots[j].length; i++){

	   		 int value = 1; 
	   		 
		    	 if(spots[j][i] == 0){
		    		 
		    		  spots[j][i] = value++;

		    	 }
	
		     }
		}
		
		
		
		
	}



		public theGame getGameType(String name){
			
			if(name.equals("Skyscrapers")){
				spots = skyscraperGame.getGameSpots(); 
				//gameType = skyscraperConstraints; 
				String cat = "cat";
				theGame gameType = new skyscraperGame(cat, 32); 
			}
			else if(name.equals("Akari")){
				akariGame.getGameSpots(); 
			}
			else if(name.equals("Kakurasu")){
				kakurasuGame.getGameSpots();
			}
			else
			{
				System.out.println("Issue with getGameType"); 
			}
			return null;
			
		}
		
		//make a copy of spots to use
		public static int[][] getNewSpots(){
			
			return spots; 
		}


}
