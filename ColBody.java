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
    int r;
    int g;
    int b;
    //int[] rgb;
    double mass;
    double radius;

    double xForce;
    double yForce;

    double xAccel;
    double yAccel;

    final double G = 6.67E-11;

    //Constructor
    public ColBody(double xc, double yc, double xv, double yv,
		   int red, int gre, int blu, double m, double rad){
	x = xc;
	y = yc;
	xVel = xv;
	yVel = yv;
	r = red;
	g = gre;
	b = blu;
	//System.out.println("R" + rgb[0] + "G" + rgb[1] + "B" + rgb[2]);
	mass = m;
	radius = rad;

	xForce = 0;
	yForce = 0;
    }

    //Part 1 methods
    public boolean isTouching(Body body){
	double distance = this.getDistanceTo(body);
	double sumRadii = this.getRadius() + body.getRadius();
	return distance <= sumRadii;
    }

    public boolean isMovingTowards(Body body){
	double deltaX = (body.getXCoord() - this.getXCoord());
	double deltaVX = (body.getXVel() - this.getXVel());
	double deltaY = (body.getYCoord() - this.getYCoord());
	double deltaVY = (body.getYVel() - this.getYVel());
	return (deltaX * deltaVX) + (deltaY * deltaVY) < 0;
    }

    public boolean isCollidingWith(Body body){
	return this.isTouching(body) && this.isMovingTowards(body);
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
	return radius;
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
	xForce += this.getXForce(b);
	yForce += this.getYForce(b);
    }

    public void addVelPEC(Body b){
	if(isCollidingWith(b)){
	    xVel += this.calcVXPEC(b);
	    yVel += this.calcVYPEC(b);
	}
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

    //Part 1
    public double calcVXPEC(Body body){
	//First parenthesis
	double p1 = (2 * body.getMass())/(this.getMass() + body.getMass());
	//Second parenthesis
	double p2 = (body.getXCoord() - this.getXCoord());
	//Third parenthesis
	double p3num = (((body.getXCoord() - this.getXCoord()) * (body.getXVel() - this.getXVel())) + ((body.getYCoord() - this.getYCoord()) * (body.getYVel() - this.getYVel())));
	double p3denom = ((Math.pow(body.getXCoord() - this.getXCoord(), 2)) + (Math.pow(body.getYCoord() - this.getYCoord(), 2)));
	return p1 * p2 * (p3num/p3denom);
    }

    public double calcVYPEC(Body body){
	//First parenthesis
	double p1 = (2 * body.getMass())/(this.getMass() + body.getMass());
	//Second parenthesis
	double p2 = (body.getYCoord() - this.getYCoord());
	//Third parenthesis
	double p3num = (((body.getXCoord() - this.getXCoord()) * (body.getXVel() - this.getXVel())) + ((body.getYCoord() - this.getYCoord()) * (body.getYVel() - this.getYVel())));
	double p3denom = ((Math.pow(body.getXCoord() - this.getXCoord(), 2)) + (Math.pow(body.getYCoord() - this.getYCoord(), 2)));
	return p1 * p2 * (p3num/p3denom);
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
	    radius + " " + r + " " + g + " " + b + " ";
	/*for(int i = 0; i < 3; i++){
	    s = s + rgb[i] + " ";    
	    }*/
        return s;
    }
}