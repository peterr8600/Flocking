/**
 * Class for representating two dimensional circular bodies for
 * physics simulations
 * @author Sean Stern
 * @version 1.0
 */
public class GravBody implements Body{
    //Instance variables
    double x;
    double y;
    double xVel;
    double yVel;
    double radius;
    int[] rgb;
    double mass;

    //Constructor
    public GravBody(double xc, double yc, double xv, double yv, double r,
		    int[] color, double m){
	x = xc;
	y = yc;
	xVel = xv;
	yVel = yv;
	radius = r;
	rgb = color;
	mass = m;
    }

    //Methods
    public double getXCoord(){
	return x;
    }

    public double getYCoord(){
	return y;
    }

    public double getXVel(){
	return xVel;
    }

    public double getYVel(){
	return yVel;
    }

    public double getRadius(){
	return radius;
    }

    public int[] getRGB(){
	return rgb;
    }

    public double getMass(){
	return mass;
    }

    public void addForceFrom(Body b){
	
    }

    public void move(double tDelta){
	
    }
    
    // TODO: Implment any additional methods for testing (i.e. methods
    // not listed on the Body interface). Look at TestGravBody for ideas
    // of helper methods you might need.
}