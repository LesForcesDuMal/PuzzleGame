package newGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//rename this spot, for it is spothandler
class SpotHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
		//Get button pressed
		gameButton pressed=(gameButton)(e.getSource()); //was JButton in field before
		
		//Get text of button
		String text=pressed.getText();
		int valueOfButtonPressed = pressed.getValue();
		String nameOfButtonPressed = pressed.getName(); 
		System.out.println("  Name of button is " + nameOfButtonPressed);
		pressed.incrementValue(); 
		System.out.print(" Value of button is " + valueOfButtonPressed); 
		

		pressed.setText(Integer.toString(valueOfButtonPressed)); //PuzzleFrame.getValue()));// +" at spot " + (JButton)e.getSource());
		//System.out.println(gameButton.getButtonInfo());
		//System.out.println("location " + pressed);
		
		

		}
	
	//still need to construct something like this
	//public static void setPuzzleValue(){
	//	GridLayoutTest.setValue();
	//}
	

	
	}


