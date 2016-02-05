package newGUI;

import java.awt.event.ActionListener;


public class AkariLook extends gameChangeListener implements ActionListener {

	public AkariLook(GamePuzzle an) {
		super(an);
	}

	public void specialDo() {
		an.init2();
	}
}