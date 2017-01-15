/**
 * Class for reading in a file of two dimensional circular bodies for
 * gravity simulations.
 * @author Sean Stern
 * @version 1.0
 */
public class GravUniverseReader extends UniverseReader{

    /**
     * Reads a gravitational simulation universe from a file.
     *
     * @param fileName the file that contains the gravity simulation data in
     *        the following format:
     *
     * [integer n representing number of bodies in universe]\n
     * [real number r representing the radius of the universe]\n
     * [real number x-coordinate of body]
     * [real number y-coordinate of body]
     * [real number x-velocity of body] 
     * [real number y-velocity of body]
     * [real number mass of body]
     * [integer red-value using 0-255 RGB color scale]
     * [integer green-value using 0-255 RGB color scale]
     * [integer blue-value using 0-255 RGB color scale]\n
     */ 
    int numBodies;

    public GravUniverseReader(String fileName){
	In input = new In(fileName);
	double rad;

	numBodies = input.readInt();
	rad = input.readDouble();

	Body[] b = new Body[numBodies];

	double tempX;
	double tempY;
	double tempXVel;
	double tempYVel;
	double tempMass;
	int tempR;
	int tempG;
	int tempB;
	//int[] tempRGB = new int[3];

	for(int i = 0; i < numBodies; i++){
	    tempX = input.readDouble();
	    tempY = input.readDouble();
	    tempXVel = input.readDouble();
	    tempYVel = input.readDouble();
	    tempMass = input.readDouble();

	    tempR = input.readInt();
	    tempG = input.readInt();
	    tempB = input.readInt();

	    //tempRGB[0] = tempR;
	    //tempRGB[1] = tempG;
	    //tempRGB[2] = tempB;

	    b[i] = new GravBody(tempX, tempY, tempXVel, tempYVel, tempR, tempG, 
				tempB, tempMass);
	}

	universeRadius = rad;
	bodies = b;
	// TODO: Read in data from file according to format
	
	// TODO: Initialize parent class's protected instance variables
	// with data read from file
    }


    public static void main(String[] args){
	UniverseReader universe = new GravUniverseReader("gravdata/planets.txt");
	Body[] bodies = universe.getBodies();
	System.out.println(bodies.length);
	System.out.println(universe.getUniverseRadius());
	for(int i = 0; i < bodies.length; i++){
	    System.out.println(bodies[i]);
	}
	// TODO: Write simple test of GravUniverseReader here by
	// constructing a GravUniverseReader object and calling
	// the two inherited methods on the GravUniverseReader object.
        // Then print out the information returned from these methods
	// to verify that they worked correctly.
    }
}