package newGUI;

//Natasha Culbreth

public class runThePuzzle {
	
	
	public static void main(String[] args) {
		
		GamePuzzle gui=new GamePuzzle();
		try {
			GamePuzzle.setKakurasuPuzzleValues();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

