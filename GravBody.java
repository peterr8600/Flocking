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

    double G = 6.67E-11;

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
    public double getXDiff(Body body){
	return Math.abs(this.getXCoord() - body.getXCoord());
    }

    public double getYDiff(Body body){
	return Math.abs(this.getYCoord() - body.getYCoord());
    }
    
    public double  getDistanceTo(Body body){
	double a = this.getXDiff(body);
	double b = this.getYDiff(body);
	double c = Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), .5);
	return c;
    }
    
    public double getAngle(Body body){
	double a = Math.toRadians(this.getXDiff(body));
	double c = Math.toRadians(this.getDistanceTo(body));
	double theta = Math.acos(a/c);
	return theta;
    }
    
    public double getForceFrom(Body body){
	double force;
	double m1 = this.getMass();
	double m2 = body.getMass();
	double r = this.getDistanceTo(body);
	force = (G * m1 * m2)/(Math.pow(r, 2));

	return force;
    }

    public double getXForce(Body body){
	double c = this.getForceFrom(body);
	double theta = this.getAngle(body);
	double xForce = c * Math.cos(theta);
	return xForce;
    }

    public double getYForce(Body body){
	double c = this.getForceFrom(body);
	double theta = this.getAngle(body);
	double yForce = c * Math.sin(theta);
	return yForce;
    }

    public String toString(){
	String s = "";
	s = s + x + " " + y + " " + xVel + " " + yVel + " " + mass + " ";
	for(int i = 0; i < 3; i++){
	    s = s + rgb[i] + " ";    
	}
        return s;
    }
}