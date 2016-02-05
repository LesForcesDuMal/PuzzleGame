package newGUI;

import java.awt.event.ActionListener;


public class kakurasuLook extends gameChangeListener implements ActionListener {

	public kakurasuLook(GamePuzzle an) {
		super(an);
	}

	public void specialDo() {
		try {
			an.init3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
