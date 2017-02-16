import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestColBody {
    //Test Helpers
    @Test
    public void testGetDistanceTo(){
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(-4.0, -2.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.0);
	ColBody gb1 = new ColBody(2.0, 2.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.0);
	ColBody gb2a = new ColBody(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.0);
	ColBody gb2b = 
	    new ColBody(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.0);
	
	double delta = 0.00001;
	assertEquals(7.21110, gb0.getDistanceTo(gb1), delta);
	assertEquals(2.82842, gb1.getDistanceTo(gb2a), delta);
	assertEquals(0, gb2a.getDistanceTo(gb2b), delta);
    }
    
    @Test
    public void testGetXCoord() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);
	// It is NEVER a good idea to check if floating point numbers are
        // ==. To represent floating point numbers using binary, the
	// computer must ROUND when it does math. 
	// For example, System.out.println(0.7 + 0.1 == 0.9 - 0.1);
	// will print false.
	//
	// Instead, it's a good idea to see if floating point numbers are
	// really really CLOSE. So we need to specify how close they should
        // be to basically count as equal. That's this number below:
	double delta = 0.00001;

	assertEquals(1986.1203, gb0.getXCoord(), delta);
	assertEquals(5325.6743, gb1.getXCoord(), delta);
	assertEquals(4437.7241, gb2.getXCoord(), delta);
    }


    @Test
    public void testGetYCoord() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);

	double delta = 0.00001;
	
	assertEquals(2032.0983, gb0.getYCoord(), delta);
	assertEquals(4012.3236, gb1.getYCoord(), delta);
	assertEquals(8982.3511, gb2.getYCoord(), delta);
    }

    @Test
    public void testGetXVel() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);

	double delta = 0.00001;
	
	assertEquals(-132.2345, gb0.getXVel(), delta);
	assertEquals(1203.8753, gb1.getXVel(), delta);
	assertEquals(-1329.2145, gb2.getXVel(), delta);
    }

    @Test
    public void testGetYVel() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);

	double delta = 0.00001;
	
	assertEquals(214.9004, gb0.getYVel(), delta);
	assertEquals(7462.4217, gb1.getYVel(), delta);
	assertEquals(-1248.3326, gb2.getYVel(), delta);
    }

    //TO DO
    @Test
    public void testGetRadius() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 1000);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 100);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0);

	double delta = 0.00001;

	assertEquals(1000, gb0.getRadius(), delta);
	assertEquals(100, gb1.getRadius(), delta);
	assertEquals(0, gb2.getRadius(), delta);
    }

    @Test
    public void testGetRGB() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);

	assertEquals(true, Arrays.equals(rgb0, gb0.getRGB()));
	assertEquals(true, Arrays.equals(rgb1, gb1.getRGB()));
	assertEquals(true, Arrays.equals(rgb2, gb2.getRGB()));
    }

    @Test
    public void testGetMass() {
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				  0, 0, 0, 90321348.7326, 0.0);
	int[] rgb1 = {255, 255, 255};
	ColBody gb1 = new ColBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				  255, 255, 255, 984212524.8921, 0.0);
	int[] rgb2 = {10, 20, 30};
	ColBody gb2 = new ColBody(4437.7241, 8982.3511, -1329.2145,
				  -1248.3326, 10, 20, 30, 50.0, 0.0);

	double delta = 0.00001;
	
	assertEquals(90321348.7326, gb0.getMass(), delta);
	assertEquals(984212524.8921, gb1.getMass(), delta);
	assertEquals(50.0, gb2.getMass(), delta);
    }

    @Test
    public void testAddForceFrom(){
	//Test Case 0 - Two ColBodies not touching.
	ColBody cb00 = new ColBody(0.0, 0.0, 0.0, 1.0, 0, 0, 0, 1.0, 1.0);
	ColBody cb01 = new ColBody(0.0, 5.0, 0.0, -1.0, 0, 0, 0, 1.0, 1.0);
    
	//addForceFrom call
	cb00.addForceFrom(cb01);
	cb01.addForceFrom(cb00);
	
	//move call
	cb00.move(1.0);
	cb01.move(1.0);
	
	//Test cb00 and cb01 x and y velocities are equal to initial velocities
	assertEquals(0.0, cb00.getXVel(), 0.0);
	assertEquals(1.0, cb00.getYVel(), 0.0);
	assertEquals(0.0, cb01.getXVel(), 0.0);
	assertEquals(-1.0, cb01.getYVel(), 0.0);

	//Test Case 1 - Two ColBodies touching, moving away.
	ColBody cb10 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 5.0);
	ColBody cb11 = new ColBody(0.0, 5.0, -1.0, 0.0, 0, 0, 0, 1.0, 4.0);
	
	//addForceFrom call
	cb10.addForceFrom(cb11);
	cb11.addForceFrom(cb10);
	
	//move call
	cb10.move(1.0);
	cb11.move(1.0);

	//Test cb10 and cb11 x and y velocities are equal to initial velocities
	assertEquals(1.0, cb10.getXVel(), 0.0);
	assertEquals(0.0, cb10.getYVel(), 0.0);
	assertEquals(-1.0, cb11.getXVel(), 0.0);
	assertEquals(0.0, cb11.getYVel(), 0.0);

	//Test Case 2 - Two ColBodies colliding.
	ColBody cb20 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 3.0);
	ColBody cb21 = new ColBody(5.0, 0.0, -1.0, 0.0, 0, 0, 0, 1.0, 3.0);
	
	//addForceFrom call
	cb20.addForceFrom(cb21);
	cb21.addForceFrom(cb20);
	
	//move call
	cb20.move(1.0);
	cb21.move(1.0);

	//Test cb20 and cb21 x and y velocities are correct according to PEC
	//velocities.
	assertEquals(-1.0, cb20.getXVel(), 0.0);
	assertEquals(0.0, cb20.getYVel(), 0.0);
	assertEquals(1.0, cb21.getXVel(), 0.0);
	assertEquals(0.0, cb21.getYVel(), 0.0);
	
	//Test Case 3 - 3 Body collision.
	ColBody cb30 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 1.0);
	ColBody cb31 = new ColBody(2.0, 0.0, -1.0, 0.0, 0, 0, 0, 2.0, 2.0);
	ColBody cb32 = new ColBody(5.0, 0.0, -2.0, 0.0, 0, 0, 0, 3.0, 3.0);

	//addForceFrom call
	cb30.addForceFrom(cb31);
	cb30.addForceFrom(cb32);
	cb31.addForceFrom(cb30);
	cb31.addForceFrom(cb32);
	cb32.addForceFrom(cb30);
	cb32.addForceFrom(cb31);
	
	//move call
	cb30.move(1.0);
	cb31.move(1.0);
	cb32.move(1.0);
	
	//Test x and y velocities are correct according to PEC
	assertEquals(-5.0/3.0, cb30.getXVel(), .00001);
	assertEquals(0.0, cb30.getYVel(), 0.0);
	assertEquals(-13.0/15.0, cb31.getXVel(), .00001);
	assertEquals(0.0, cb31.getYVel(), 0.0);
	assertEquals(-1.2, cb32.getXVel(), .00001);
	assertEquals(0.0, cb32.getYVel(), 0.0);
    }

    @Test
    public void testMove(){
	//Test Case 0 - Two ColBodies not touching.
	ColBody cb00 = new ColBody(0.0, 0.0, 0.0, 1.0, 0, 0, 0, 1.0, 1.0);
	ColBody cb01 = new ColBody(0.0, 5.0, 0.0, -1.0, 0, 0, 0, 1.0, 1.0);
	
	//addForceFrom call
	cb00.addForceFrom(cb01);
	cb01.addForceFrom(cb00);
	
	//move call
	cb00.move(1.0);
	cb01.move(1.0);

	//Test cb00 and cb01 x and y positions are correct according to PEC
	//equations.
	assertEquals(0.0, cb00.getXCoord(), 0.0);
	assertEquals(1.0, cb00.getYCoord(), 0.0);
	assertEquals(0.0, cb01.getXCoord(), 0.0);
	assertEquals(4.0, cb01.getYCoord(), 0.0);

	//Test Case 1 - Two ColBodies touching, moving away.
	ColBody cb10 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 5.0);
	ColBody cb11 = new ColBody(0.0, 8.0, -1.0, 0.0, 0, 0, 0, 1.0, 4.0);
	
	//addForceFrom call
	cb10.addForceFrom(cb11);
	cb11.addForceFrom(cb10);
	
	//move call
	cb10.move(1.0);
	cb11.move(1.0);
	
	//Test cb10 and cb11 x and y positions are correct according to PEC
	//equations.
	assertEquals(1.0, cb10.getXCoord(), 0.0);
	assertEquals(0.0, cb10.getYCoord(), 0.0);
	assertEquals(-1.0, cb11.getXCoord(), 0.0);
	assertEquals(8.0, cb11.getYCoord(), 0.0);
	
	//Test Case 2 - Two ColBodies colliding.
	ColBody cb20 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 3.0);
	ColBody cb21 = new ColBody(5.0, 0.0, -1.0, 0.0, 0, 0, 0, 1.0, 3.0);
	
	//addForceFrom call
	cb20.addForceFrom(cb21);
	cb21.addForceFrom(cb20);
	
	//move call
	cb20.move(1.0);
	cb21.move(1.0);

	//Test cb20 and cb21 x and y positions are correct according to PEC
	//equations.
	assertEquals(-1.0, cb20.getXCoord(), 0.0);
	assertEquals(0.0, cb20.getYCoord(), 0.0);
	assertEquals(6.0, cb21.getXCoord(), 0.0);
	assertEquals(0.0, cb21.getYCoord(), 0.0);

	//Test Case 3 - 3 Body collision.
	ColBody cb30 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 1.0, 1.0);
	ColBody cb31 = new ColBody(2.0, 0.0, -1.0, 0.0, 0, 0, 0, 2.0, 2.0);
	ColBody cb32 = new ColBody(5.0, 0.0, -2.0, 0.0, 0, 0, 0, 3.0, 3.0);

	//addForceFrom call
	cb30.addForceFrom(cb31);
	cb30.addForceFrom(cb32);
	cb31.addForceFrom(cb30);
	cb31.addForceFrom(cb32);
	cb32.addForceFrom(cb30);
	cb32.addForceFrom(cb31);
	
	//move call
	cb30.move(1.0);
	cb31.move(1.0);
	cb32.move(1.0);
	
	//Test cb30, cb31, cb32 x and y positions are correct according to PEC
	//equations.
	assertEquals(-5.0/3.0, cb30.getXCoord(), 0.00001);
	assertEquals(0.0, cb30.getYCoord(), 0.0);
	assertEquals(17.0/15.0, cb31.getXCoord(), 0.00001);
	assertEquals(0.0, cb31.getYCoord(), 0.0);
	assertEquals(19.0/5.0, cb32.getXCoord(), 0.00001);
	assertEquals(0.0, cb32.getYCoord(), 0.0);
    }

    @Test
    public void testIsTouching(){
	ColBody cb0 = new ColBody(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb1 = new ColBody(1.0, 0.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb2 = new ColBody(10, 0.0, 0.0, 0.0, 0, 0, 0, 0.0, 0.5);
	
	assertEquals(true, cb0.isTouching(cb1));
	assertEquals(false, cb0.isTouching(cb2));
    }

    @Test
    public void testIsMovingTowards(){
	ColBody cb0 = new ColBody(10.0, 0.0, -1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb1 = new ColBody(-10.0, 0.0, 1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb2 = new ColBody(15.0, 0.0, 1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	
	assertEquals(true, cb0.isMovingTowards(cb1));
	assertEquals(false, cb0.isMovingTowards(cb2));
    }
    
    @Test
    public void testIsCollidingWith(){
	ColBody cb0 = new ColBody(0.0, 0.0, 1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb1 = new ColBody(1.0, 0.0, -1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb2 = new ColBody(1.0, 0.0, 1.0, 0.0, 0, 0, 0, 0.0, 0.5);
	ColBody cb3 = new ColBody(10.0, 0.0, 1.0, 0.0, 0, 0, 0, 0.0, 0.5);

	assertEquals(true, cb0.isCollidingWith(cb1));
	assertEquals(false, cb0.isCollidingWith(cb2));
	assertEquals(false, cb0.isCollidingWith(cb3));
    }

    @Test
    public void testCalcVXPEC(){
	ColBody bA = new ColBody(-10.0, 10.0, 10.0, 0, 0, 0, 0, 10.0, 10.0);
	ColBody bB = new ColBody(10.0, 10.0, -10.0, 0, 0, 0, 0, 10.0, 10.0);
	double delta = 1;
	
	assertEquals(-20, bA.calcVXPEC(bB), delta);
    }

    @Test
    public void testCalcVYPEC(){
	ColBody bA = new ColBody(10.0, 10.0, 0.0, -10.0, 0, 0, 0, 10.0, 10.0);
	ColBody bB = new ColBody(10.0, -10.0, 0.0, 10.0, 0, 0, 0, 10.0, 10.0);
	double delta = 1;
	
	assertEquals(20, bA.calcVYPEC(bB), delta);
    }
}