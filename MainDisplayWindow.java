package physicsSimulator;

import javax.swing.JFrame;

//Main Method class that when ran, will run the full program
public class MainDisplayWindow {

	public static void main(String[] args) {
		InputOutput gui = new InputOutput();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300,300);
		gui.setTitle("Hockey Simulator Inputs");
		gui.setVisible(true);	
	}
}
