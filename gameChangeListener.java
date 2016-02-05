package newGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gameChangeListener implements ActionListener {

	GamePuzzle an;

	public gameChangeListener(GamePuzzle an) {
		this.an = an;
	}

	public void specialDo() {
		an.init1();
	}

	// removes all the components are reinitializes the Frame
	public void actionPerformed(ActionEvent e) {
		//an.getContentPane().removeAll();
		specialDo();
		
		//an.revalidate();
		an.rePaint(); 
		//an.validate();
		//an.repaint();
	}

}
