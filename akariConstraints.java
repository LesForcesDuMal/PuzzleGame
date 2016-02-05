package newGUI;


public class akariConstraints extends gameConstraints {

	public akariConstraints(int a, int b) {
		super(a, b);
	}



	private static boolean success;
	private static boolean allDiff;
	private static boolean bulbNumberConstraint;
	private static boolean goodNumberOfBulbsConstraint; 
	private static boolean rowIlluminatedConstraint;
	private static boolean colIlluminatedConstraint;
	
	
	//values of game
	static int[][] spots = new int[][]{
		 // 0  1  2  3  
		  {0, 0, 0, -1},//1
		  {0, -1, 0, 0},//2
		  {0, 0, 1, 0},//3
		  {1, 0, 0, 0},//4
		  }; 
	

	
	// AKARI MASTER CHECK METHOD
	public static boolean allAkariConstraint() {
		if (allDiff == false || bulbNumberConstraint == false || goodNumberOfBulbsConstraint == false) {
			success = false;
		} else {
			success = true;
		}
		return success;
	}


	
	public static void makeMatrixDiff(){
		 //int value = 0; //this works		

  	 printFormat();
		
	}//end of makematrixdiff
	
	
	//checking column will mean that row spot will be the same and col number will change
	public static boolean allDiffCol(int value, int col, int row){
		
		boolean test = true; 
		
		//passing in value to check for in col
		for (int j = 0; j<spots[col].length; j++){
			
			if(spots[col][j] == value){ //if anything in the area is deemed the same, false
				
				System.out.println("*inside alldiffcol " + spots[row][j] + " at " + row + " " + j + " is the same as value " + value + " so return false"); 
				 test = false; // false; 
				 break; 
			}
			else
			{
				System.out.println("**inside alldiffcol, " + spots[row][j] + " at " + row + " " + j + " is not " + value + " so it's fine so true"); 
				 test = true; //return true; 
			}
	
		}
		return test; 
		
	}//end of alldiff
	
	public static boolean allDiffRow(int value, int row){
		
		//passing in value to check for in col
		for (int j = 0; j<spots[row].length-1; j++){
			
			//I want it to give it the row number
			//and then interate through all the cols
			
			if(spots[j][row] == value){
				return false; 
			}
			else
			{
				return true; 
			}
	
		}
		return true; 
		
	}//end of alldiff
	
	//check if just created thing is satisfied. 
	public static boolean allDiffColCheck(){
		return false; 
	}
	
	
	

	
	public static void printFormat(){
  	 
  	 for (int c = 0; c < spots.length; c++) {//col
  		    for (int k = 0; k < spots.length-1; k++) {//row
  		    	
  		        System.out.print(spots[c][k] + " ");
  		    }
  		    System.out.print("\n");
  		}
	}
	
	
	public static void printMatrix(){
		
		
		for (int j = 0; j<spots[0].length+1; j++){ // goes through cols
		     for (int i = 0; i<spots[j].length; i++){
		    	 
		    	 System.out.println("New Matrix " + spots[j][i]);
		     }
		     
		}
		
	}
	
	
	//public static void placing Values(){
	//	if()
	//}
	
	
	public boolean distanceConstraint(int r, int c){
		int constraint = spots[r][c];
		int counter = 0; 
		
		//check surrounding the area - increment counter if you see a value

			if(spots[r-1][c]!=0){
				counter++; 
			}
			if(spots[r][c-1]!=0){
				counter++; 
			}
			if(spots[1+r][c]!=0){
				counter++; 
			}
			if(spots[r][c+1]!=0){
				counter++; 
			}
			
			if(counter > constraint){
				
				//goes over number of bulbs required, needs to try again
				bulbNumberConstraint =false; 
			}
			else{
				//does not exceed number of bulbs needed, safe
				bulbNumberConstraint = true; 
			}
			
			return bulbNumberConstraint; 
	}
	
	
	public boolean numberOfBulbsMet(int r, int c){
		
		int constraint = spots[r][c];
		int counter = 0; 
		
		//check surrounding the area - increment counter if you see a value

			if(spots[r-1][c]!=0){
				counter++; 
			}
			if(spots[r][c-1]!=0){
				counter++; 
			}
			if(spots[1+r][c]!=0){
				counter++; 
			}
			if(spots[r][c+1]!=0){
				counter++; 
			}
			
			if(counter > constraint){
				//enough bulbs are placed, can continue
				goodNumberOfBulbsConstraint = true;
			}
			else{
				//not enough bulbs are placed, needs to try again
				goodNumberOfBulbsConstraint = false;
			}
			
			return goodNumberOfBulbsConstraint;
		
	}
	
	
	//used to see if a row is already being illuminated by a bulb.
	public boolean rowAlreadyIlluminated(int c){
		
		//go through row based on column given, see if it is safe to add bulb
		for (int j = 0; j<spots[c].length-1; j++){
			
			if(spots[j][c]!=0){
				return false; 
			}
		}
		return false;
	}
	
	//used to see if a col is already being illuminated by a bulb.
	public boolean colAlreadyIlluminated(int r){
		
		//go through column based on row given, see if it is safe to add bulb
		for (int j = 0; j<spots[r].length-1; j++){
			
			if(spots[r][j]!=0){
				return false; 
			}
		}
		return false;
		
	}
	
}
