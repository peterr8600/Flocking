/**
 * Class for representating two dimensional circular bodies for
 * physics simulations
 * @author Sean Stern
 * @version 1.0
 */
public class ColBody implements Body{
    //Instance variables
    double x;
    double y;
    double xVel;
    double yVel;
    
    double tempXVel;
    double tempYVel;
    
    int r;
    int g;
    int b;
    //int[] rgb;
    double mass;
    double radius;

    final double G = 6.674E-11;

    //Constructor
    //Usage: X coordinate, Y coordinate, X initial velocity, Y initial velocity
    //red value, green value, blue value, mass, radius.
    public ColBody(double xc, double yc, double xv, double yv,
		   int red, int gre, int blu, double m, double rad){
	x = xc;
	y = yc;
	xVel = xv;
	yVel = yv;
	r = red;
	g = gre;
	b = blu;
	mass = m;
	radius = rad;
    }

    //Part 1 methods
    //Returns true if this Body is touching another Body, body.
    //distance between two bodies is <= sum of their radii.
    public boolean isTouching(Body body){
	double distance = this.getDistanceTo(body);
	double sumRadii = this.getRadius() + body.getRadius();
	return distance <= sumRadii;
    }

    //Returns true if this Body is moving towards another Body, body.
    //the dot product of the relative difference in the bodies' positions and 
    //the relative difference in the bodies' velocities is negative.
    public boolean isMovingTowards(Body body){
	double deltaX = (body.getXCoord() - this.getXCoord());
	double deltaVX = (body.getXVel() - this.getXVel());
	double deltaY = (body.getYCoord() - this.getYCoord());
	double deltaVY = (body.getYVel() - this.getYVel());
	return (deltaX * deltaVX) + (deltaY * deltaVY) < 0;
    }

    //Returns true if this Body is both touching and moving towards another
    //Body body.
    public boolean isCollidingWith(Body body){
	return this.isTouching(body) && this.isMovingTowards(body);
    }

    //Methods
    //Returns current X coordinate.
    public double getXCoord(){
	return x;
    }

    //Returns current Y coordinate.
    public double getYCoord(){
	return y;
    }

    //Returns current X velocity.
    public double getXVel(){
	return xVel;
    }

    //Returns current Y velocity.
    public double getYVel(){
	return yVel;
    }

    //Returns radius of this Body.
    public double getRadius(){
	return radius;
    }

    //Returns the RGB values of this Body.
    public int[] getRGB(){
	int[] rgb = new int[3];
	rgb[0] = r; rgb[1] = g; rgb[2] = b;
	return rgb;
    }

    //Returns mass of this body.
    public double getMass(){
	return mass;
    }

    //Handles changes in X and Y velocities when this Body collides with 
    //Body, b.
    public void addForceFrom(Body b){
	if(isCollidingWith(b)){
	    tempXVel += this.calcVXPEC(b);
	    tempYVel += this.calcVYPEC(b);
	}
    }

    //Moves this Body by (xyVel * tDelta).
    public void move(double tDelta){
	xVel = xVel + tempXVel;
	yVel = yVel + tempYVel;
	x += xVel * tDelta;
	y += yVel * tDelta;

	tempXVel = 0;
	tempYVel = 0;
    }

    //Part 1
    //Returns the X component of velocity after a perfectly elastic collision.
    public double calcVXPEC(Body body){
	//First parenthesis
	double massRatio =
	    (2 * body.getMass())/(this.getMass() + body.getMass());
	
	//Second parenthesis
	double xDiff = (body.getXCoord() - this.getXCoord());
	
	//Third parenthesis
	double p3num = (((body.getXCoord() - this.getXCoord()) * (body.getXVel() - this.getXVel())) + ((body.getYCoord() - this.getYCoord()) * (body.getYVel() - this.getYVel())));
	
	double p3denom = ((Math.pow(body.getXCoord() - this.getXCoord(), 2)) + (Math.pow(body.getYCoord() - this.getYCoord(), 2)));
	return massRatio * xDiff * (p3num/p3denom);
    }

    //Returns the Y component of velocity after a perfectly elastic collision.
    public double calcVYPEC(Body body){
	//First parenthesis
	double massRatio = 
	    (2 * body.getMass())/(this.getMass() + body.getMass());
	
	//Second parenthesis
	double yDiff = (body.getYCoord() - this.getYCoord());
	
	//Third parenthesis
	double p3num = (((body.getXCoord() - this.getXCoord()) * (body.getXVel() - this.getXVel())) + ((body.getYCoord() - this.getYCoord()) * (body.getYVel() - this.getYVel())));
	
	double p3denom = ((Math.pow(body.getXCoord() - this.getXCoord(), 2)) + (Math.pow(body.getYCoord() - this.getYCoord(), 2)));
	return massRatio * yDiff * (p3num/p3denom);
    }
    
    //Helper methods
    public double getXDiff(Body body){
        return body.getXCoord() - this.getXCoord();
    }

    public double getYDiff(Body body){
        return body.getYCoord() - this.getYCoord();
    }

    public double  getDistanceTo(Body body){
        double a = this.getXDiff(body);
        double b = this.getYDiff(body);
        double c = Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), .5);
        return c;
    }
    
    public String toString(){
	String s = "";
	s = s + x + " " + y + " " + xVel + " " + yVel + " " + mass + " " +
	    radius + " " + r + " " + g + " " + b + " ";
	/*for(int i = 0; i < 3; i++){
	    s = s + rgb[i] + " ";    
	    }*/
        return s;
    }
}