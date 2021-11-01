package physicsSimulator;

import java.awt.Point;

//Defines a puck object and contains methods that can
//manipulate the behavior of a puck
public class Puck {
	private int xP, yP;
	private double xVel, yVel, mass;
	
	//Default Constructor for a new puck object
	public Puck() {
		xP = 200;
		yP = 200;
		mass = 1;
		xVel = 1;
		yVel = 1;
	}
	
	//Regular Constructor for a new puck object
	public Puck(double m, double x, double y, double xv, double yv) {
		xP = (int) x;
		yP = (int) y;
		mass = m;
		xVel = xv;
		yVel = yv;
	}
	
	//Access Methods
	public int getXPos() {
		return xP;
	}
	
	public int getYPos() {
		return yP;
	}
	
	public double getXVelocity() {
		return xVel;
	}
	
	public double getYVelocity() {
		return yVel;
	}
	
	public double getMass() {
		return mass;
	}
	
	//Setter Methods
	public void setPosition(int x, int y) {
		xP = x;
		yP = y;
	}
	
	public void setXVelocity(double x) {
		xVel = x;
	}
	
	public void setYVelocity(double y) {
		yVel = y;
	}
	
	public void setMass(double m) {
		mass = m;
	}
	
	//moves the puck 1 frame forward
	public void movePuck() {
		xP += xVel;
		yP += yVel;
	}
	
	//Calculates and changes the velocity of the pucks after their collision
	public static void collision2(Puck p1, Puck p2) {
		
		double m1 = p1.getMass(), m2 = p2.getMass();
		double xv1 = p1.getXVelocity(), xv2 = p2.getXVelocity();
		double yv1 = p1.getYVelocity(), yv2 = p2.getYVelocity();
		double finalXV1, finalXV2, finalYV1, finalYV2;
		
		finalXV2 = (((2 * m1 * xv1) + (m2 * xv2) - (m1 * xv2)) / (m1 + m2));
		finalXV1 = (xv2 - xv1 + finalXV2);
		
		finalYV2 = (((2 * m1 * yv1) + (m2 * yv2) - (m1 * yv2)) / (m1 + m2));
		finalYV1 = (yv2 - yv1 + finalYV2);
		
		p1.setXVelocity(finalXV1);
		p1.setYVelocity(finalYV1);
		p2.setXVelocity(finalXV2);
		p2.setYVelocity(finalYV2);
	}
}