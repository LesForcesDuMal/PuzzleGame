package newGUI;


public class kakurasuConstraints extends gameConstraints {

	public kakurasuConstraints(int a, int b) {
		super(a, b);
	}



	private static boolean success;
	private static boolean allDiff;
	private static boolean topConstraints;
	private static boolean bottomConstraints;
	private static boolean leftConstraints;
	private static boolean rightConstraints;

	private static int[] spots = GamePuzzle.getKakurasuPuzzleValues(); 
	private static int[] topConstraintValues;
	private static int[] rightConstraintValues;
	private static int[] leftConstraintValues;
	private static int[] bottomConstraintValues;
	
	

	
	// SKYSCRAPER MASTER CHECK METHOD
	public static boolean allKakurasuConstraint() {
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


	public static void makeMatrixDiff(){

  	 printFormat();
		
	}//end of makematrixdiff
	
	
	//checking column will mean that row spot will be the same and col number will change
	public static boolean allDiffRow(int value, int col, int row){
		
		boolean test = true; 
		
		//passing in value to check for in col
		for (int j = 0; j<spots.length; j++){
			
			if(spots[col] == value){ //if anything in the area is deemed the same, false
				
				System.out.println("*inside alldiffcol " + spots[row] + " at " + row + " " + j + " is the same as value " + value + " so return false"); 
				 test = false; // false; 
				 break; 
			}
			else
			{
				System.out.println("**inside alldiffcol, " + spots[row] + " at " + row + " " + j + " is not " + value + " so it's fine so true"); 
				 test = true; //return true; 
			}
	
		}
		return test; 
		
	}//end of alldiff
	
	
	
	//check if just created thing is satisfied. 
	public static boolean allDiffColCheck(){
		return false; 
	}
	
	
	

	
	public static void printFormat(){
  	 
  	 for (int c = 0; c < spots.length; c++) {//col
  		    for (int k = 0; k < spots.length-1; k++) {//row
  		    	
  		        System.out.print(spots[c] + " ");
  		    }
  		    System.out.print("\n");
  		}
	}

	//checking top constraints to see if they are met, and resetting according
	public static void happyTowersTop(){
		int highest = 0; 
		//starting from the top
		for (int j = 0; j<spots.length; j++){ //going thru the rows of col
			
			//initalize an array of size of the number of skyscrapers that should be in view according to the value in an index of topConstraintValues.
			int inView[] = new int[topConstraintValues[j]]; 
				if(spots[j]>highest){
					highest = spots[j];
					inView[j] = highest;
					
					//if it continues to be larger, reset
					if(spots[j+1]>highest){
						highest = spots[j];
						inView[j] = highest;
					}
					if(spots[j+3]>highest){
						highest = spots[j];
						inView[j] = highest;
					}
				}
		}
	}
	

	
//get the topConstraints for the puzzle
	public void setTopConstraints(){
		int counter = 0;
	while(counter < 6)
		for (int i = 0; i < spots.length; i++) {
			topConstraintValues[i] = spots[i];
			counter++; 
	    }
	}
	
}
