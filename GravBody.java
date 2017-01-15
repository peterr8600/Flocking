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
    int r;
    int g;
    int b;
    double mass;

    double xForce;
    double yForce;

    double xAccel;
    double yAccel;

    final double G = 6.67E-11;

    //Constructor
    public GravBody(double xc, double yc, double xv, double yv,
		    int red, int gre, int blu, double m){
	x = xc;
	y = yc;
	xVel = xv;
	yVel = yv;
	r = red;
	g = gre;
	b = blu;
	mass = m;

	xForce = 0;
	yForce = 0;
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

    public double getXForce(){
	return xForce;
    }

    public double getYForce(){
	return yForce;
    }

    public double getRadius(){
	return 0.0;
    }

    public int[] getRGB(){
	int[] rgb = new int[3];
	rgb[0] = r; rgb[1] = g; rgb[2] = b;
	return rgb;
    }

    public double getMass(){
	return mass;
    }

    public void addForceFrom(Body b){
	/*if(this.getXCoord() < b.getXCoord()){
	    xForce += this.getXForce(b);
	    //System.out.println("x +");
	}
	else{
	    xForce -= this.getXForce(b);
	    //System.out.println("x -");
	}
	if(this.getYCoord() < b.getYCoord()){
	    yForce += this.getYForce();
	    //System.out.println("y +");
	}
	else{
	    yForce -= this.getYForce();
	    //System.out.println("y -");
	    }*/
	xForce += this.getXForce(b);
	yForce += this.getYForce(b);
    }

    public void move(double tDelta){
	xAccel = xForce/mass;
	yAccel = yForce/mass;
	xVel = xVel + (xAccel * tDelta);
	yVel = yVel + (yAccel * tDelta);
	x += xVel * tDelta;
	y += yVel * tDelta;

	xForce = 0;
	yForce = 0;
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
    
    public double getAngle(Body body){
	double a = this.getXDiff(body);
	double b = this.getYDiff(body);
       	//double c = this.getDistanceTo(body);
       	double theta = Math.atan2(b, a);
       	//double theta = Math.acos(a/c);
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
	double xF = c * Math.cos(theta);
	return xF;
    }

    public double getYForce(Body body){
	double c = this.getForceFrom(body);
	double theta = this.getAngle(body);
	double yF = c * Math.sin(theta);
	return yF;
    }

    public String toString(){
	String s = "";
	s = s + x + " " + y + " " + xVel + " " + yVel + " " + mass + " " +
r + " " + g + " " + b + " ";
	/*for(int i = 0; i < 3; i++){
	    s = s + rgb[i] + " ";    
	    }*/
        return s;
    }
}