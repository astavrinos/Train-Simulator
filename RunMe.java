//import java.util.ArrayList;

/*
 * Adamos Stavrinos
 * Advance Programming, Asset Exercise 1, 2019
 * 
 * Simulation of Trains and Tracks
 */
public class RunMe {

	public static void main(String[] args) {

		Controller controller = new Controller();
		Thread t = new Thread(controller);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
