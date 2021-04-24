package cs1301.cityescape;

public class Driver {

    public static double simulate(Simulation s, int trials) {

	int successes = 0;
	
	for (int t = 0; t < trials; t++) {
	    // System.out.println("Trial " + (t + 1) + ": \n");
	    if (s.run()) successes++;

	} // for
	
	return (double)successes / (double) trials;
	
    } // getSuccessProbability
    
    public static void main(String[] args) {

	Simulation s = new Simulation(100, 100);
	System.out.println("Success rate: " + Driver.simulate(s, 100));

    } // main

} // Driver
