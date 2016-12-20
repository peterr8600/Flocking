import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGravBody {
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