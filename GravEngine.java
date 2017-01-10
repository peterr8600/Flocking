/**
 * Class for gravity simulation engine. This class implements a gravity
 * simulation by implementing the method {@link #computeForces() computeForces}
 *
 * @author Sean Stern
 * @version 1.0
 */
public class GravEngine extends PhysicsEngine{
    
    /**
     * Constructs a {@link SimpGravEngine}
     *
     * @param bodies an array of {@link Body} objects; this represents
     *        all the bodies in the universe
     * @param timeDelta the quantum of time over which the engine applies
     *        forces; similar in concept to a frame rate
     * @param universeRadius the radius of the universe being simulated; the
     *        radius is the minimum distance from the center to an edge of the
     *        universe
     * @param bgRed determines the r-value of the background; should be 0-255
     * @param bgBlue determines the b-value of the background; should be 0-255
     * @param bgGreen determines the g-value of the background; should be 0-255
     */
    public GravEngine(Body[] bodies, double timeDelta, double universeRadius,
		      int bgRed, int bgBlue, int bgGreen){
	super(bodies, timeDelta, universeRadius, bgRed, bgBlue, bgGreen);
    }

    /**
     * For each body, computes the sum of all the gravitational foces acting
     * on that body.
     */
    protected void computeForces(){
	// TODO: 
        // For each body:
        //     compute the forces of all other bodies on that body
	for(int i = 0; i < i < bodies.length; i++){
	    for(int x = 0; x < bodies.length; x++){
		if(x != i){
		    bodies[i].addForceFrom(bodies[x]);
		}
	    }
	}
    }
}