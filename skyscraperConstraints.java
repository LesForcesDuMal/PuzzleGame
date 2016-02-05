package newGUI;


public class skyscraperConstraints extends gameConstraints {

	public skyscraperConstraints(int a, int b) {
		super(a, b);
	}



	private static boolean success;
	private static boolean allDiff;
	private static boolean topConstraints;
	private static boolean bottomConstraints;
	private static boolean leftConstraints;
	private static boolean rightConstraints;

	private static int[] topConstraintValues = { 2, 1, 5, 2, 2 };
	private static int[] rightConstraintValues = { 2, 3, 1, 2, 3 };
	private static int[] leftConstraintValues = { 2, 1, 2, 4, 2 };
	private static int[] bottomConstraintValues = { 3, 4, 1, 2, 3 };
	
	
	
	static int[][] spots = new int[][]{
		 // 0  1  2  3   4  5
		
		  {0, 0, 0, 0},//1
		  {0, 0, 0, 0},//2
		  {0, 0, 0, 0},//3
		  {0, 0, 0, 0},//4
		  {0, 0, 0, 0},//5
		  }; //6 
	

	
	// SKYSCRAPER MASTER CHECK METHOD
	public static boolean allSkyscraperConstraint() {
		if (allDiff == false || topConstraints == false
							 || bottomConstraints == false 
							 || leftConstraints == false
							 || rightConstraints == false) {
			success = false;
		} else {
			success = true;
		}
		return success;
	}

/*
//TOWER CONSTRAINTS
		public boolean towersTop(int row, int col) {
			
			int highest = 0;
			int numOfVisable = 0;
	
			for (int r = 0; r < spots[0].length + 1; r++) { // goes through rows?
				if (spots[r][col] > highest) {
	
					System.out.println("New visible " + spots[r][col]);
					numOfVisable++;
					highest = spots[r][col];
	
				}
			}
	
			if (numOfVisable > topConstraintValues[row]
					|| numOfVisable < topConstraintValues[row]) {
				topConstraints = false;
				System.out.println("FALSE FOR BUTTOM " + topConstraintValues[col]);
			} else {
				topConstraints = true;
				System.out.println("TRUE FOR BUTTOM " + topConstraintValues[col]);
			}
	
			return topConstraints;
		}// end of happyTowersLeft
		
		*/
	
	
	
	public static void makeMatrixDiff(){

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
	
	
	
	//PreLabling spots depending on constraints
	public void preLabing(){
		
		//presetting values from the left. If the constraint is 1, then set the value to 4.
		//if constraint is 4, go 1-4 in cols of row
		for (int c = 0; c<spots[0].length+1; c++){	
			
			//to the left
			if(leftConstraintValues[c] == 1){
				spots[0][c]=4;
			}
			if(leftConstraintValues[c] == 4){
				spots[0][c]=1;
				spots[0][c]=2;
				spots[0][c]=3;
				spots[0][c]=4;
			}
		
		}
		
		//presetting values from the right. If the constraint is 1, then set the value to 4.
		//if constraint is 4, go 1-4 in cols of row
		for (int c = 4; c>spots[0].length+1; c--){	
			
			//to the right
			if(rightConstraintValues[c] == 1){
				spots[0][c]=4;
			}
			if(rightConstraintValues[c] == 4){
				spots[0][c]=1;
				spots[0][c]=2;
				spots[0][c]=3;
				spots[0][c]=4;
			}
		
		}
		
		//presetting values from the top. If the constraint is 1, then set the value to 4.
		//if constraint is 4, go 1-4 in rows of cols
		for (int r = 0; r<spots[r].length; r++){	
			
			//to the right
			if(topConstraintValues[r] == 1){
				spots[r][0]=4;
			}
			if(topConstraintValues[r] == 4){
				spots[r][0]=1;
				spots[r][0]=2;
				spots[r][0]=3;
				spots[r][0]=4;
			}
		
		}
		
		
		//presetting values from the bottom. If the constraint is 1, then set the value to 4.
		//if constraint is 4, go 1-4 in rows of col
		for (int r = 0; r<spots[r].length; r++){	
			
			//to the right
			if(bottomConstraintValues[r] == 1){
				spots[r][0]=4;
			}
			if(bottomConstraintValues[r] == 4){
				spots[r][0]=1;
				spots[r][0]=2;
				spots[r][0]=3;
				spots[r][0]=4;
			}
		
		}
		
		
	}
	
	
	//method for grabbing constraints
	public static void happyTowersLeft(){
		int highest = 0; 

		
		//starting from the left
		for (int j = 0; j<spots[0].length+1; j++){ //going thru the columns of row
			
			//initalize an array of size of the number of skyscrapers that should be in view according to the value in an index of leftConstraintValues.
			int inView[] = new int[leftConstraintValues[j]]; 
				if(spots[0][j]>highest){
					highest = spots[0][j];
					inView[j] = highest;
				}
		}


	}//end of left
	
	public static void happyTowersRight(){
		int highest = 0; 
		//starting from the left
		for (int j = -4; j<spots[0].length+1; j--){ //going thru the columns of row
			
			//initalize an array of size of the number of skyscrapers that should be in view according to the value in an index of rightConstraintValues.
			int inView[] = new int[rightConstraintValues[j]]; 
				if(spots[0][j]>highest){
					highest = spots[0][j];
					inView[j] = highest;
				}
		}
		
	}
	
	public static void happyTowersTop(){
		int highest = 0; 
		//starting from the top
		for (int j = 0; j<spots[0].length+1; j++){ //going thru the rows of col
			
			//initalize an array of size of the number of skyscrapers that should be in view according to the value in an index of topConstraintValues.
			int inView[] = new int[topConstraintValues[j]]; 
				if(spots[0][j]>highest){
					highest = spots[0][j];
					inView[j] = highest;
				}
		}
	}
	
	public static void happyTowersButtom(){
		int highest = 0; 
		//starting from the bottom
		for (int j = 0; j<spots[0].length+1; j++){ //going thru the rows of col
			
			//initalize an array of size of the number of skyscrapers that should be in view according to the value in an index of bottomConstraintValues.
			int inView[] = new int[bottomConstraintValues[j]]; 
				if(spots[0][j]>highest){
					highest = spots[0][j];
					inView[j] = highest;
				}
		}
	}
	

	
	public static void printMatrix(){
		
		
		for (int j = 0; j<spots[0].length+1; j++){ // goes through cols
		     for (int i = 0; i<spots[j].length; i++){
		    	 
		    	 System.out.println("New Matrix " + spots[j][i]);
		     }
		     
		}
		
	}
	
}
