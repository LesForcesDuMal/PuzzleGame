package newGUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;





public class GamePuzzle {

	private String nameOfGame; 
	private JFrame frame = new JFrame(nameOfGame);
    private JPanel menuButtons;
	private JPanel mainPanel;
	private int[] skyscraperPuzzleValues = new int[] {-1,2,1,3,2,-1,2,0,0,0,0,2,3,0,0,0,0,1,2,0,0,0,0,2,1,0,0,0,0,3,-1,1,3,2,3,-1}; 
	private int[] akariPuzzleValues = new int[] {0,0,0,0,0,-1,0,0,0,0,1,0,1,0,0,0}; 
	
	
	private static int[]kakurasuPuzzleValues; 
	//this from a file
	//private int[] kakurasuPuzzleValues = new int[] {-1,1,2,3,4,5,-1,1,0,0,0,0,0,15,2,0,0,0,0,0,10,3,0,0,0,0,11,4,0,0,0,0,0,2,5,0,0,0,0,0,3,-1,1,10,8,4,6,-1};
	
	
	private String[] buttonNames = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifthteen","sixteen",
			"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
	private SpotHandler[] spotHandlers; 
	private static gameButton[] buttons;
	private theGame game; 
	
	//private static int numberOfButtons = 16; 
    
    public GamePuzzle(){
    	
	    
		// the frame that contains the components

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // set the size of the frame
	    frame.setSize(900, 600);
	    
	    // set the rows and cols of the grid, as well the distances between them
	    							//	r	c  b  b
	    GridLayout grid = new GridLayout(3, 2, 1, 1);//was 5, 3, 5, 5
	    //JPanel majorLayout = new JPanel(new GridLayout(1, 1));
	    JPanel gameText = new JPanel(new GridLayout(1, 2)); 
	    menuButtons = new JPanel(new GridLayout(1, 3));
	    mainPanel = new JPanel(new GridLayout(7, 3));
	    
	    // This adds the stuff onto the screen in the order I want
	    frame.setLayout(grid);
	    frame.add(menuButtons);
	    frame.add(gameText);
		 frame.add(mainPanel);
		 
	    
	    // add a text field with a specified text to the frame
	    JTextArea gameName = new JTextArea();
	    gameName.setText(nameOfGame);
	    gameName.setEditable(false);
	    gameText.add(gameName);
        //	    
        JTextArea status = new JTextArea();
        status.setText("Instructions: click the zeros to reset the values, click solve to solve the puzzle.");
        status.setEditable(false);
        gameText.add(status);
	    
        
	    //initally it'll be init1 (skyscraper, then it'll be changed by the player
        init1();

    	
    }
    
    public void rePaint(){
    	frame.revalidate(); 
    	frame.repaint();
    	System.out.println("Pressed");
    }
	
	//public static void main(String[] args) {
//
	//	GamePuzzle gui=new GamePuzzle();
	//	try {
	//		setKakurasuPuzzleValues();
	//	} catch (Exception e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	} 

	//}
	
	public void init1(){
		
		nameOfGame = "Skyscraper";
		
		createSpotsAndHandlers(35, skyscraperPuzzleValues); //stuff for 
	    frame.setVisible(true);

        // add buttons to the frame
        JButton akari = new JButton("Akari");
        akari.setPreferredSize(new Dimension(2,2));
        menuButtons.add(akari);
        akari.addActionListener(new AkariLook(this));
        akari.addActionListener(new gameChangeListener(this));
        //need to add listener
        
        JButton kakurasu = new JButton("kakurasu");
        kakurasu.setPreferredSize(new Dimension(2,2));
        kakurasu.addActionListener(new kakurasuLook(this));
        kakurasu.addActionListener(new gameChangeListener(this));
        menuButtons.add(kakurasu);
        //need to add listener
        
        JButton solve = new JButton("Solve");
        solve.setPreferredSize(new Dimension(2,2));
        menuButtons.add(solve);
        
        solve.addActionListener(new solverListener());
        
	    
	    game = new skyscraperGame(nameOfGame, 0); 
	    
        
	}
	
	public void init2(){
		
		nameOfGame = "Akari";
		
		createSpotsAndHandlers(16, akariPuzzleValues); //stuff for 
	    frame.setVisible(true);
	    
        
        JButton kakurasu = new JButton("kakurasu");
        kakurasu.setPreferredSize(new Dimension(2,2));
        menuButtons.add(kakurasu);
        kakurasu.addActionListener(new kakurasuLook(this));
        //need to add listener
        
        JButton solve = new JButton("Solve");
        solve.setPreferredSize(new Dimension(2,2));
        menuButtons.add(solve);
        
        
      //solve.addActionListener(solverListener);
        
		game = new akariGame(nameOfGame, 0); 
	}
	
	public void init3() throws Exception{
		
		nameOfGame = "Kakurasu";
		
		//game = new kakurasuGame(nameOfGame, 0); 
		
		createSpotsAndHandlers(48, getKakurasuPuzzleValues()); //stuff for 
	    frame.setVisible(true);
	    
        
        JButton akari = new JButton("akari");
        akari.setPreferredSize(new Dimension(2,2));
        menuButtons.add(akari);
        //need to add listener
        
        JButton solve = new JButton("Solve");
        solve.setPreferredSize(new Dimension(2,2));
        menuButtons.add(solve);
        
      //solve.addActionListener(solver);
        
        
        
        game = new kakurasuGame(nameOfGame, 0); 
	}
	
	public void createSpotsAndHandlers(int buttonNumber, int[] gameNumbers){
		
		//Create spots and handlers!!!
				buttons=new gameButton[buttonNumber+1]; //wasJButton
				spotHandlers=new SpotHandler[buttonNumber];
				
				for(int i=0; i<buttonNumber; i++)
				{
					
					//naming variables
					buttons[i]=new gameButton(buttonNames[i], gameNumbers[i]);
					spotHandlers[i]=new SpotHandler();
					
					//if value is 0, then add listener so value can be changed by user
					//listener will do nothing to spots with the static values of the puzzle
					if(gameNumbers[i] == 0){
					buttons[i].addActionListener(spotHandlers[i]);
					buttons[i].setButton(true); 
					}

				}
				
				
				//Initialize text in buttons
				for(int i=0; i<buttonNumber; i++)
				{			
					if(gameNumbers[i] == -1){
						//If set text to x
						buttons[i].setText("x");
					}
					else{
					buttons[i].setText(Integer.toString(gameNumbers[i]));
					}
				}
				
				//Add elements to the grid content pane
				for(int i=0; i<buttonNumber; i++)
				{
					mainPanel.add(buttons[i]);

				}
				
	}
	
	//need to increment
	public void changeValue(){
		
		solver.getNewSpots(); 
		
	}
	
	public static gameButton[] getButtons(){
		return buttons;
	}
	
	
	
	
	public static int[] setKakurasuPuzzleValues() throws Exception
	{

	      Scanner inFile = new Scanner(new File("values.dat"));
	      int i = 0;
	      while (inFile.hasNextLine()) {
	    	  kakurasuPuzzleValues[i] = inFile.nextInt();
	    	  System.out.println(kakurasuPuzzleValues[i]);

	       ++i;
	      }
	
	      
	      return kakurasuPuzzleValues;
	  
	}
	
	public static int[] getKakurasuPuzzleValues(){
		return kakurasuPuzzleValues; 
	}


	
}//end of class
