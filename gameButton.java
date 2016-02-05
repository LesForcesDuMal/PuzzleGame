package newGUI;


import javax.swing.JButton;

public class gameButton extends JButton {
	
	private int value = -1;
	private String name; 
	boolean set;
	
	public gameButton(String n, int v){ //int v) {
		//this.value = v;
		this.name = n; 
		this.value = v; 
	}
	
	//public static String getButtonInfo(){
	//	String info = "Name is " + n + " and value is " + value; 
	//	return info; 
	//}
	
	
	public boolean setStatus(){
		return set; 
	}
	
	public void incrementValue(){
		value++; 
	}
	
	public void setValue(int n){
		value = n;
	}
	
	public int getValue(){
		return value; 
	}
	
	public String getName(){
		return name; 
	}

	public void setButton(boolean b) {
		
		set = b; 
		
	}

}
