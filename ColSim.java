/**
 * Class for running a gravity simulation. This class uses
 * {@link GravUniverseReader} to read in data from a text file and a
 * {@link GravEngine} to run the simulation.
 *
 * @author Sean Stern
 * @version 1.0
 */
public class ColSim{

    /**
     * Runs a gravity simulation
     * Required command line argument: fileName
     * Optional command line arguments: timeDelta r-value b-value g-value 
     */
    public static void main(String[] args){
	if(args.length == 0){
	    System.out.println("usage: java ColSim fileName [timeDelta] " +
			       "[r-value] [b-value] [g-value]");
	    return;
	}
	UniverseReader ur = new ColUniverseReader(args[0]);
	double timeDelta = 0.001;
	if(args.length > 1){
	    timeDelta = Double.parseDouble(args[1]);
	}   
	int r = 0, b = 0, g = 0;
	if(args.length > 4){
	    r = Integer.parseInt(args[2]);
	    b = Integer.parseInt(args[3]);
	    g = Integer.parseInt(args[4]);
	}
	PhysicsEngine pe = new ColEngine(ur.getBodies(), timeDelta,
					  ur.getUniverseRadius(),
					  r, b, g);
	//System.out.println(ur.getBodies()[0].getRGB()[1]);
	pe.run();
    }
}