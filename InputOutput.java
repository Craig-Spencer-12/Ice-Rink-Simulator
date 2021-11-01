package physicsSimulator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Creates the input window and sends the information to the IceRink object
public class InputOutput extends JFrame {
	
	//private instance variables
	private JLabel label;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;
	private JButton button;
	
	//Constructor that sets up the input window
	public InputOutput() {
		//Gives the JFrame a standard layout
		setLayout(new FlowLayout());
		
		//creates label for puck 1 inputs
		label = new JLabel("Puck 1");
		add(label);
		
		//Creates Text Boxes for Puck 1
		tf1 = new JTextField("Mass" , 10);
		add(tf1);
		tf2 = new JTextField("X-Position" , 10);
		add(tf2);
		tf3 = new JTextField("Y-Position" , 10);
		add(tf3);
		tf4 = new JTextField("X-Velocity" , 10);
		add(tf4);
		tf5 = new JTextField("Y-Velocity" , 10);
		add(tf5);
		
		//Writes label from puck 2 inputs
		label = new JLabel("Puck 2");
		add(label);
		
		//Creates Text Fields for Puck 2
		tf6 = new JTextField("Mass" , 10);
		add(tf6);
		tf7 = new JTextField("X-Position" , 10);
		add(tf7);
		tf8 = new JTextField("Y-Position" , 10);
		add(tf8);
		tf9 = new JTextField("X-Velocity" , 10);
		add(tf9);
		tf10 = new JTextField("Y-Velocity" , 10);
		add(tf10);
		
		//Draws the physical button
		button = new JButton("Create Simulation");
		add(button);

		//Defines the action of pressing the button
		event e = new event();
		button.addActionListener(e);
	}
	
	//Action will be performed once the button is pressed
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				
				//Takes the input of each text field and converts it to a double
				double m1 = Double.parseDouble(tf1.getText());
				double xp1 = Double.parseDouble(tf2.getText());
				double yp1 = Double.parseDouble(tf3.getText());
				double xv1 = Double.parseDouble(tf4.getText());
				double yv1 = Double.parseDouble(tf5.getText());
				double m2 = Double.parseDouble(tf6.getText());
				double xp2 = Double.parseDouble(tf7.getText());
				double yp2 = Double.parseDouble(tf8.getText());
				double xv2 = Double.parseDouble(tf9.getText());
				double yv2 = Double.parseDouble(tf10.getText());
				
				//creates an array of type double to store the values of the text field
				double[] arr = {m1, xp1, yp1, xv1, yv1, m2, xp2, yp2, xv2, yv2};
				
				//creates and IceRink object to draw the physical rink
				//with the array above as its input
				IceRink rink = new IceRink(arr);
				
				//creates the JFrame that the rink object will be drawing on
				JFrame f = new JFrame();
				f.add(rink);
				
				//Basic operations to set up the JFrame
				f.setVisible(true);
				f.setSize(1400, 800);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("Hockey Rink");
				
			} catch (Exception ex) {}
		}
	}
}
