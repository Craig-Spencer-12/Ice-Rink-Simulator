package physicsSimulator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

//draws and manipulates the lines and pucks within the JFrame
public class IceRink extends JPanel implements ActionListener{

	//private instance variables
	private Timer t = new Timer(10, this);			//sets the speed (fps) of the program
	private Puck p1, p2;
	private boolean collide = false;

	//Receives the array from the InputOutput class and creates an IceRink object
	public IceRink(double[] arr) {
		p1 = new Puck(arr[0], arr[1], arr[2], arr[3], arr[4]);
		p2 = new Puck(arr[5], arr[6], arr[7], arr[8], arr[9]);
	}
	
	//draws what the user will actually see on the JFrame
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//creates the outer box of the arena
		g.drawLine(100,100,1300,100);
		g.drawLine(100,100,100,700);
		g.drawLine(1300,100,1300,700);
		g.drawLine(100,700,1300,700);
	
		//creates the two hockey pucks and fills them in
		Ellipse2D circle = new Ellipse2D.Double(p1.getXPos() ,p1.getYPos(), 40, 40);
		Ellipse2D circle2 = new Ellipse2D.Double(p2.getXPos() ,p2.getYPos(), 40, 40);
		g2.fill(circle);
		g2.fill(circle2);
		
		//runs the action performed method below and waits the amount of time specified
		t.start();	
	}
	
	public void actionPerformed (ActionEvent e) {
		
		//changes the pucks position and ensures it is in the boundaries
		p1.movePuck();
		inBounds(p1);
		
		p2.movePuck();
		inBounds(p2);
		
		//if the pucks get too close to each other they will "collide"
		if (!collide && p1.getXPos() - p2.getXPos() <= 35 && p1.getXPos() - p2.getXPos() >= -35
				&& p1.getYPos() - p2.getYPos() <= 35 && p1.getYPos() - p2.getYPos() >= -35) {
			Puck.collision2(p1, p2);
			collide = true;
		}
		
		//pucks can only collide once per time they are close to each other
		//and must separate before they can collide again
		else if (p1.getXPos() - p2.getXPos() >= 60 || p1.getXPos() - p2.getXPos() <= -60
				|| p1.getYPos() - p2.getYPos() >= 60 || p1.getYPos() - p2.getYPos() <= -60)
			collide = false;
		
		//reruns the paintComponent method
		//These two methods will run back and forth until the X is pressed
		repaint();
	}
	
	//if the puck is on or past the bounds it will point
	//its velocity inward until it is within the bounds
	public void inBounds(Puck p) {
		if (p.getXPos() >= 1260)
			p.setXVelocity(-1 * Math.abs(p.getXVelocity()));
			
		else if (p.getXPos() <= 100)
			p.setXVelocity(Math.abs(p.getXVelocity()));
		
		if (p.getYPos() >= 660)
			p.setYVelocity(-1 * Math.abs(p.getYVelocity()));
			
		else if (p.getYPos() <= 100)
			p.setYVelocity(Math.abs(p.getYVelocity()));
	}
}

