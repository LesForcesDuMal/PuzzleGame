//this is a copy, not original 

package newGUI;


public class allDifferent {
	
	//take in game
	
	//public boolean allDifferent(){
		//checks some array to make sure everything being put into the row and col is different
		
	//}
	
	//public boolean rowAllDiff(){
		
	//}
	
	//public boolean colAllDiff(){
		
	//}
	
	//IF spot[row][col] == 0.
	//		set spot to a value (declare value inside recursion so it will be new for each spot
	
	//change 0's to numbers:
	//going thru each row - which will be each value of array
	// going thru each col - vertical values thru cols
	// print out numbers with "success"
	//else print out "fail"
	 
	//                           [row][col]
	static int[][] spots2 = new int[][]{
		 // 0  1  2  3   4  5
		  {-1, 2, 1, 3, 2,-1}, //0
		  { 2, 0, 10, 0, 0, 2}, //1
		  { 2, 0, 0, 0, 0, 2},//2
		  { 3, 0, 0, 0, 0, 1},//3
		  { 2, 0, 0, 0, 0, 2},//4
		  { 1, 0, 0, 0, 0, 3},//5
		  {-1, 1, 3, 2, 3,-1}}; //6 
	
	static int[][] spots = new int[][]{
		 // 0  1  2  3   4  5
		
		  {0, 0, 0, 0},//1
		  {0, 0, 0, 0},//2
		  {0, 0, 0, 0},//3
		  {0, 0, 0, 0},//4
		  {0, 0, 0, 0},//5
		  }; //6 
	
	//public static int value = 0; //for real version this CAN'T BE STATIC, IT HAS TO BE UNIQUE TO SPOT
	
	
	//game only seeks out 0's as being unset
	
	//col 1 is [0][allrows] it's a lableing col
	//col 2 is [1][rows 1-5]
	//col 3 is [2][rows 1-5]
	//col 4 is [3][rows 1-5]
	//col 5 is [4][rows 1-5]
	//col 6 is [5][0-6] it's a labling col
	//row 1 is [cols 0-6][0] it's a lableing row
	//row 2 is [cols 1-5][1]
	//row 2 is [cols 1-5][2]
	//row 2 is [cols 1-5][3]
	//row 2 is [cols 1-5][4]
	//row 2 is [cols 1-5][5]
	//row 2 is [cols 0-6][6] it's a lableing row
	
	public static void main(String[] args) {
		
		//System.out.println("Neo's at " + multi[0][3]);
		int col = 0;
		int row = 0; //these will be place holders
		
		//for(int i = 0; i < spots.length; i++){
			
			//System.out.println("Neo's at " + spots[0][3]);
			
		//if(spots[col][row] == 0){ //it's unset
			
			//System.out.println("We're at spot[" +col+"]");
			//col++;
			//row++; 
		
		
		
		
		
		//new matrix
		
		//System.out.println("YYAYAAAAAAA");
		
		makeMatrixDiff();
		//makeMatrixDiff(); 
		
		
	}

	public static void makeMatrixDiff(){
		 //int value = 0; //this works		
		for (int j = 0; j<spots[0].length+1; j++){ // goes through rows?
		     for (int i = 0; i<spots[j].length; i++){
		    	 //System.out.println("We're here " + spots[j][i]);
	    		 int value = 1; 
	    		 
		    	 if(spots[j][i] == 0){
		    		 
		    		  spots[j][i] = value++;
		    		  
		    		  if(allDiffCol(value,j,i)==false){
		    			  spots[j][i] = value++;
		    			  System.out.println("changed " + "[" + j + "]" + "[" + i + "]" + " to " + spots[j][i]);
		    		  }
		    	 }
		    	 
		    	
		    	 //System.out.println("Spot " + spots[j][i] + " at col " + j + " and row " + i + " is now " + value);
 
			     
		    	 }
		}
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
	
	
	
	public static void setToTen(){
		for (int j = 0; j<spots[0].length+1; j++){ // goes through cols
			    for (int i = 0; i<spots[j].length; i++){
				   	 System.out.println("Neo's at here " + spots[j][i]);
				    	 
			    	 if(spots[j][i] == 0){
				    		 spots[j][i] = 10; 
				    		 
			    	 }
			    	 
			    	 System.out.println("GLITCH IN MATRIX " + spots[j][i]);
					     
				    	 }
				}
				
	}
	
	public static void printFormat(){
   	 
   	 for (int c = 0; c < spots.length; c++) {//col
   		    for (int k = 0; k < spots.length-1; k++) {//row
   		    	
   		        System.out.print(spots[c][k] + " ");
   		    }
   		    System.out.print("\n");
   		}
	}
	
	
	
	
	//method for grabbing constraints
	public static void happyTowersLeft(){
		//make an array of the towers?
		int highest; 
		//is it happy looking left
	}
	
	public static void happyTowersRight(){
		//make an array of the towers?
		
		//is it happy looking right
	}
	
	public static void happyTowersTop(){
		//make an array of the towers?
		
		//is it happy looking up?
	}
	
	public static void happyTowersButtom(){
		//make an array of the towers?
	}
	
	
	
	//public int changeValue(){
		//return value++; 
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void printMatrix(){
		
		
		for (int j = 0; j<spots[0].length+1; j++){ // goes through cols
		     for (int i = 0; i<spots[j].length; i++){
		    	 
		    	 System.out.println("New Matrix " + spots[j][i]);
		     }
		     
		}
		
	}
	
	
	
	

}
