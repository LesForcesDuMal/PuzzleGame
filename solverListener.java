package newGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Need to do - refresh the screen once this is called



public class solverListener implements ActionListener {
	
	private gameButton pressed; 


	// removes all the components are reinitializes the Frame
	public void actionPerformed(ActionEvent e) {
		
		
		//this is just for the solver button, don't worry
		pressed=(gameButton)(e.getSource()); //was JButton in field before
		String text=pressed.getText();
		
			setSolvedValues(); 
			//GamePuzzle.rePaint();
			System.out.println("Solver is going to display");


	} 
	
	//increment buttons and get new names
	//if unset = true, reset them. 
	public void setSolvedValues(){
		

		
		int[][] newSpots = solver.getNewSpots();
		
		gameButton[] buttons = GamePuzzle.getButtons(); 
		
		//go thru button array in GamePuzzle
		
		//go thru spots
		
		for (int r = 0; r < newSpots[0].length + 1; r++) { // goes through rows?
			for (int c = 0; c < newSpots[r].length; c++) {

				for(int b = 0; b < buttons.length; b++){
				//need to change value of specific button and make sure it updates
					buttons[b].setText(Integer.toString(newSpots[r][c]));
				
				}
		
			}
		}
		
	}
	

}
