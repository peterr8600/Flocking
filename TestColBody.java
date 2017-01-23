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
    public void testGetAngle(){
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(0, 0, 0, 0, 0, 0, 0, 0, 0);
	ColBody gb1 = new ColBody(3, 3, 0, 0, 0, 0, 0, 0, 0);
	ColBody gb2 = new ColBody(5, 2, 0, 0, 0, 0, 0, 0, 0);

	double delta = 0.00001;
	assertEquals(Math.PI/4, gb0.getAngle(gb1), delta);
	//assertEquals(.38051, gb2.getAngle(gb0), delta);
	//assertEquals(.38051, gb0.getAngle(gb2), delta);
    }
    
    @Test
    public void testGetForceFrom(){
	int[] rgb0 = {0, 0, 0};
	ColBody earth = new ColBody(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 5.972E24, 0.0);
	ColBody moon = new ColBody(3.84E8, 0.0, 0.0, 0.0, 0, 0, 0, 7.348972E22, 0.0);
	ColBody gb0 = new ColBody(0.0, 0.0, 0.0, 0.0, 0, 0, 0, 10.0, 0.0);
	ColBody gb1 = new ColBody(10.0, 0.0, 0.0, 0.0, 0, 0, 10, 0.0, 0.0);

	double delta0 = 1E18;
	assertEquals(1.98523E20, earth.getForceFrom(moon), delta0);
	double delta1 = 1E-9;
	assertEquals(6.67E-11, gb0.getForceFrom(gb1), delta0);
    }

    @Test
    public void testGetXForce(){
	int[] rgb0 = {0, 0, 0};
	ColBody gb0 = new ColBody(0, 0, 0, 0, 0, 0, 0, 1000000, 0.0);
	ColBody gb1 = new ColBody(1000000, 2000000, 0, 0, 0, 0, 0, 1000000, 0.0);
	ColBody gb2 = new ColBody(3000000, 5000000, 0, 0, 0, 0, 0, 10000000, 0.0);
	
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
	ColBody gb0 = new ColBody(0, 0, 0, 0, 0, 0, 0, 1000000, 0.0);
	ColBody gb1 = new ColBody(1000000, 2000000, 0, 0, 0, 0, 0, 1000000, 0.0);
	ColBody gb2 = new ColBody(3000000, 5000000, 0, 0, 0, 0, 0, 10000000, 0.0);
	
	double delta = 1E-13;
	
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
	int[] rgb0 = {255, 255, 255};
	
	ColBody gbSun = new ColBody(0, 0, 0, 0, 0, 0, 0, 1.989E30, 0.0);
	ColBody gbEarth = 
	    new ColBody(1.5E11, 0.0, 0.0, 3.0E4, 0, 0, 0, 5.972E24, 0.0);
	ColBody gbVenus = 
	    new ColBody(1E11, 0.0, 0.0, 3.5E4, 0, 0, 0, 04.87E24, 0.0);

	double delta = 1E19;

	assertEquals(0, gbSun.getXForce(), delta);
	assertEquals(0, gbSun.getYForce(), delta);
	assertEquals(0, gbVenus.getXForce(), delta);
	assertEquals(0, gbVenus.getYForce(), delta);
	assertEquals(0, gbEarth.getXForce(), delta);
	assertEquals(0, gbEarth.getYForce(), delta);

	gbSun.addForceFrom(gbVenus);
	gbVenus.addForceFrom(gbSun);

	//Sun + Venus	
	assertEquals(6.4647E22, gbSun.getXForce(), delta);
	assertEquals(0, gbSun.getYForce(), delta);
	//Venus + Sun
	assertEquals(-6.4647E22, gbVenus.getXForce(), delta);
	assertEquals(0, gbVenus.getYForce(), delta);

	gbSun.addForceFrom(gbEarth);
	gbEarth.addForceFrom(gbSun);

	//Sun + Venus + Earth
	assertEquals(9.9881E22, gbSun.getXForce(), delta);
	assertEquals(0, gbSun.getYForce(), delta);
	//Earth + Sun
	assertEquals(-3.5234E22, gbEarth.getXForce(), delta);
	assertEquals(0, gbEarth.getYForce(), delta);

	gbVenus.addForceFrom(gbEarth);
	gbEarth.addForceFrom(gbVenus);

	//Venus + Sun + Earth
	assertEquals(-6.4655E22, gbVenus.getXForce(), delta);
	assertEquals(0, gbVenus.getYForce(), delta);
	//Earth + Sun + Venus
	assertEquals(-3.52419E22, gbEarth.getXForce(), delta);
	assertEquals(0, gbEarth.getYForce(), delta);
	
	gbSun.move(0.1);
	gbVenus.move(0.1);
	gbEarth.move(0.1);

	assertEquals(0, gbSun.getXForce(), delta);
	assertEquals(0, gbSun.getYForce(), delta);
	assertEquals(0, gbVenus.getXForce(), delta);
	assertEquals(0, gbVenus.getYForce(), delta);
	assertEquals(0, gbEarth.getXForce(), delta);
	assertEquals(0, gbEarth.getYForce(), delta);
    }

    @Test
    public void testMove(){
       	ColBody gbSun = new ColBody(0, 0, 0, 0, 0, 0, 0, 1.989E30, 0.0);
	ColBody gbEarth = 
	    new ColBody(1.5E11, 0.0, 0.0, 3.0E4, 0, 0, 0, 5.972E24, 0.0);
	ColBody gbVenus = 
	    new ColBody(1E11, 0.0, 0.0, 3.5E4, 0, 0, 0, 04.87E24, 0.0);
	
	double deltaSun = 1E-13;
	double deltaEV = 1E10;

	//Calculations Round 1
	//Copy from here
	gbSun.addForceFrom(gbVenus);
	gbSun.addForceFrom(gbEarth);
	
	gbVenus.addForceFrom(gbEarth);
	gbVenus.addForceFrom(gbSun);
	
	gbEarth.addForceFrom(gbVenus);
	gbEarth.addForceFrom(gbSun);
	
	gbSun.move(0.1);
	gbVenus.move(0.1);
	gbEarth.move(0.1);
	//To here
	
	assertEquals(5.021669E-10, gbSun.getXCoord(), deltaSun);
	assertEquals(0, gbSun.getYCoord(), deltaSun);

	assertEquals(1E11, gbVenus.getXCoord(), deltaEV);
	assertEquals(3.5E3, gbVenus.getYCoord(), 1);

	assertEquals(1.5E11, gbEarth.getXCoord(), deltaEV);
	assertEquals(3E3, gbEarth.getYCoord(), 1);

	assertEquals(0, gbSun.getXForce(), 1);
	assertEquals(0, gbSun.getYForce(), 1);
	assertEquals(0, gbVenus.getXForce(), 1);
	assertEquals(0, gbVenus.getYForce(), 1);
	assertEquals(0, gbEarth.getXForce(), 1);
	assertEquals(0, gbEarth.getYForce(), 1);
	
	//Calculations Round 2
	gbSun.addForceFrom(gbVenus);
	gbSun.addForceFrom(gbEarth);
	
	gbVenus.addForceFrom(gbEarth);
	gbVenus.addForceFrom(gbSun);
	
	gbEarth.addForceFrom(gbVenus);
	gbEarth.addForceFrom(gbSun);
	
	//System.out.println("XForce: " + gbEarth.getXForce());
	//System.out.println("XVel: " + gbEarth.getXVel());
	//System.out.println("XCoord: " + gbEarth.getXCoord());
	//System.out.println("YForce: " + gbEarth.getYForce());
	//System.out.println("YVel: " + gbEarth.getYVel());
	//System.out.println("YCoord: " + gbEarth.getYCoord());

	gbSun.move(0.1);
	gbVenus.move(0.1);
	gbEarth.move(0.1);
	
	//System.out.println("XCoord: " + gbEarth.getXCoord());
	//System.out.println("YCoord: " + gbEarth.getYCoord());

	assertEquals(1.506516E-9, gbSun.getXCoord(), deltaSun);
	assertEquals(1.491885E-17, gbSun.getYCoord(), deltaSun);

	assertEquals(1E11, gbVenus.getXCoord(), deltaEV);
	assertEquals(7E3, gbVenus.getYCoord(), 1);

	assertEquals(1.5E11, gbEarth.getXCoord(), deltaEV);
	assertEquals(6E3, gbEarth.getYCoord(), 1);
	
	assertEquals(0, gbSun.getXForce(), 1);
	assertEquals(0, gbSun.getYForce(), 1);
	assertEquals(0, gbVenus.getXForce(), 1);
	assertEquals(0, gbVenus.getYForce(), 1);
	assertEquals(0, gbEarth.getXForce(), 1);
	assertEquals(0, gbEarth.getYForce(), 1);
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