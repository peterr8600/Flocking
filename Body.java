/**
 * Interface for representating two dimensional circular bodies for
 * physics simulations
 * @author Sean Stern
 * @version 1.0
 */
public interface Body{

    /**
     * Gets the x-coordinate of the two dimensional body. This method is useful
     * for visualizing the simluation.
     * 
     * @return the x-coordinate of the two dimensional body.
     */
    public double getXCoord();


    /**
     * Gets the y-coordinate of the two dimensional body. This method is useful
     * for visualizing the simulation.
     *
     * @return the y-coordinate of the two dimensional body.
     */
    public double getYCoord();

    /**
     * Gets the x component of the velocity of the dimensional body.
     * 
     * @return the x component of the velocity of the two dimensional body.
     */
    public double getXVel();


    /**
     * Gets the y component of the velocity  of the two dimensional body. 
     *
     * @return the y component of the velocity of the two dimensional body..
     */
    public double getYVel();

    /**
     * Gets the radius of the two dimensional body. This method is useful for
     * visualizing the simulation.
     *
     * @return the radius of the two dimensional body.
     */
    public double getRadius();


    /**
     * Gets the color (red, green, and blue values on a 0-255 scale) of the
     * body. This method is useful for visualizing the simulation.
     *
     * @return an array of length 3 representing the color of the body; the
     *         value at 0th index represents red on a 0-255 scale, the value
     *         at the 1st green on a 0-255 scale, and the value at 2nd blue
     *         on a 0-255 scale 
     */
    public int[] getRGB();


    /**
     * Gets the mass of two dimensional body.
     *
     * @return the mass of the two dimensional body.
     */
    public double getMass();


    /**
     * Calculates the force exterted on this two dimensional body by another
     * two dimensional body.
     *
     * @param otherBody the {@link TwoDimBody} exterting a force on this two
     *        two dimensional body
     */
    public void addForceFrom(Body otherBody);


    /**
     * Based on the forces exterted on this two dimensional body and the 
     * existing position of the two dimensional body, determines the new
     * position of the body after moving for the provided amount of time.
     * Also should reset the forces on the {@link Body} to 0.
     *
     * @param timeDelta the amount of time the body moves
     */
    public void move(double timeDelta);
}