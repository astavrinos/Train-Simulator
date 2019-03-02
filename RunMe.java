//import java.util.ArrayList;

/*
 * Adamos Stavrinos
 * Advance Programming, Asset Exercise 1, 2019
 * 
 * Simulation of Trains and Tracks
 */
public class RunMe {

	public static void main(String[] args) {

		// Create controller
		Controller controller = new Controller();
		// Create thread
		Thread t = new Thread(controller);
		// Start thread
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
