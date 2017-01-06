import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGravBody {
    //Test Helpers
    @Test
    public void testGetDistanceTo(){
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(-4, -2, 0, 0, rgb0, 0);
	GravBody gb1 = new GravBody(2, 2, 0, 0, rgb0, 0);
	GravBody gb2a = new GravBody(0, 0, 0, 0, rgb0, 0);
	GravBody gb2b = new GravBody(0, 0, 0, 0, rgb0, 0);
	
	double delta = 0.00001;
	assertEquals(7.21110, gb0.getDistanceTo(gb1), delta);
	assertEquals(2.82842, gb1.getDistanceTo(gb2a), delta);
	assertEquals(0, gb2a.getDistanceTo(gb2b), delta);
    }

    @Test
    public void testGetAngle(){
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(0, 0, 0, 0, rgb0, 0);
	GravBody gb1 = new GravBody(3, 3, 0, 0, rgb0, 0);
	GravBody gb2 = new GravBody(5, 2, 0, 0, rgb0, 0);

	double delta = 0.00001;
	assertEquals(Math.PI/4, gb0.getAngle(gb1), delta);
	assertEquals(.38051, gb0.getAngle(gb2), delta);
    }
    
    @Test
    public void testGetForceFrom(){
	int[] rgb0 = {0, 0, 0};
	GravBody earth = new GravBody(0, 0, 0, 0, rgb0, 5.972E24);
	GravBody moon = new GravBody(3.84E8, 0, 0, 0, rgb0, 7.348972E22);
	GravBody gb0 = new GravBody(0, 0, 0, 0, rgb0, 10);
	GravBody gb1 = new GravBody(10, 0, 0, 0, rgb0, 10);

	double delta0 = 1E15;
	assertEquals(1.98523E20, earth.getForceFrom(moon), delta0);
	double delta1 = 1E-9;
	assertEquals(6.67E-11, gb0.getForceFrom(gb1), delta0);
    }

    @Test
    public void testGetXForce(){
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(0, 0, 0, 0, rgb0, 1000000);
	GravBody gb1 = new GravBody(1000000, 2000000, 0, 0, rgb0, 1000000);
	GravBody gb2 = new GravBody(3000000, 5000000, 0, 0, rgb0, 10000000);
	
	double delta = 0.00000000000001;
	double c = gb0.getForceFrom(gb1);
	//System.out.println("F: " + c);
	double theta = gb0.getAngle(gb1);
	//System.out.println("Theta: " + theta);
	//System.out.println("xForce: " + c * Math.cos(theta));
	assertEquals(5.965830E-12, gb0.getXForce(gb1), delta);

	double c1 = gb0.getForceFrom(gb2);
	//System.out.println("F: " + c1);
	double theta1 = gb0.getAngle(gb2);
	//System.out.println("Theta: " + theta1);
	//System.out.println("xForce: " + c1 * Math.cos(theta1));
	assertEquals(1.009320E-11, gb0.getXForce(gb2), delta);
    }

    @Test
    public void testGetYForce(){
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(0, 0, 0, 0, rgb0, 1000000);
	GravBody gb1 = new GravBody(1000000, 2000000, 0, 0, rgb0, 1000000);
	GravBody gb2 = new GravBody(3000000, 5000000, 0, 0, rgb0, 10000000);
	
	double delta = 0.00000000000001;
	
	double c = gb0.getForceFrom(gb1);
	//System.out.println("F: " + c);
	double theta = gb0.getAngle(gb1);
	//System.out.println("Theta: " + theta);
	//System.out.println("yForce: " + c * Math.sin(theta));
	assertEquals(1.193166E-11, gb0.getYForce(gb1), delta);

	assertEquals(1.682199E-11, gb0.getYForce(gb2), delta);
    }
    
    @Test
    public void testGetXCoord() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);
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
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	double delta = 0.00001;
	
	assertEquals(2032.0983, gb0.getYCoord(), delta);
	assertEquals(4012.3236, gb1.getYCoord(), delta);
	assertEquals(8982.3511, gb2.getYCoord(), delta);
    }

    @Test
    public void testGetXVel() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	double delta = 0.00001;
	
	assertEquals(-132.2345, gb0.getXVel(), delta);
	assertEquals(1203.8753, gb1.getXVel(), delta);
	assertEquals(-1329.2145, gb2.getXVel(), delta);
    }

    @Test
    public void testGetYVel() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	double delta = 0.00001;
	
	assertEquals(214.9004, gb0.getYVel(), delta);
	assertEquals(7462.4217, gb1.getYVel(), delta);
	assertEquals(-1248.3326, gb2.getYVel(), delta);
    }

    //TO DO
    @Test
    public void testGetRadius() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	double delta = 0.00001;
    }

    @Test
    public void testGetRGB() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	assertEquals(true, Arrays.equals(rgb0, gb0.getRGB()));
	assertEquals(true, Arrays.equals(rgb1, gb1.getRGB()));
	assertEquals(true, Arrays.equals(rgb2, gb2.getRGB()));
    }

    @Test
    public void testGetMass() {
	int[] rgb0 = {0, 0, 0};
	GravBody gb0 = new GravBody(1986.1203, 2032.0983, -132.2345, 214.9004,
				    rgb0, 90321348.7326);
	int[] rgb1 = {255, 255, 255};
	GravBody gb1 = new GravBody(5325.6743, 4012.3236, 1203.8753, 7462.4217,
				    rgb1, 984212524.8921);
	int[] rgb2 = {10, 20, 30};
	GravBody gb2 = new GravBody(4437.7241, 8982.3511, -1329.2145,
				    -1248.3326, rgb2, 50.0);

	double delta = 0.00001;
	
	assertEquals(90321348.7326, gb0.getMass(), delta);
	assertEquals(984212524.8921, gb1.getMass(), delta);
	assertEquals(50.0, gb2.getMass(), delta);
    }

    @Test
    public void testAddForceFrom(){
	// HINT: The physics coursework/homework you did is helpful here

	GravBody gbA = null; // TODO: Replace null w/ call to GravBody cons
	GravBody gbB = null; // TODO: Replace null w/ a call to GravBody cons
	GravBody gbC = null; // TODO: Replace null w/ a call to GravBody cons
	              

	// TODO: Assert that the x and y component of force on gbA are 0
	// HINT: There's no method on the Body to get the forces--but gbA is
	// a GravBody. So you can add methods to gravBody that isnt' on the
	// interface to get the forces you need solely for testing purposes.

	gbA.addForceFrom(gbB);
	gbA.addForceFrom(gbC);

	// TODO: Assert that the x and y components of force on gbA are correct


	// TODO: Assert that the x and y components of force on gbB are 0

	gbB.addForceFrom(gbA);
	gbB.addForceFrom(gbC);

	// TODO: Assert that x and y components of force on gbB are correct

	
	// TODO: Write test ensuring that forces can be calculated correctly
	// for gbC
	// HINT: It's the same as the last two test cases you wrote.
    }

    @Test
    public void testMove(){
	// HINT: The physics coursework/homework you did her is helpful.

	// TODO: Create 3 GravBody objects

	// TODO: For each GravBody object, add force from other two
	
	// TODO: Move each GravBody object for some time delta

	// TODO: For each GravBody object, assert that new x and y coordinates
	// are correct after movement

	// TODO: For each GravBody object, assert that x and y components of
	// force are now 0

	
	// TODO: Repeat the above process on the same 3 GravBody objects once
	// more.
    }

    
}