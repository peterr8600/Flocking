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
    int[] rgb;
    double mass;

    double g = 6.67E-11;

    //Constructor
    public GravBody(double xc, double yc, double xv, double yv,
		    int[] color, double m){
	x = xc;
	y = yc;
	xVel = xv;
	yVel = yv;
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
	return 0.0;
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
    
    //Helper methods
    public double  getDistanceTo(Body b){
	double a = Math.abs(0);
	return 0.0;
    }
}