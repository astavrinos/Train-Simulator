//import java.util.ArrayList;

/*
 * Adamos Stavrinos
 * Advance Programming, Asset Exercise 1, 2019
 * 
 * Simulation of Trains and Tracks
 */
public class RunMe {

	public static void main(String[] args) {

		RailwayComponent[] route = new RailwayComponent[5];
		route[0] = new Station("Glasgow", 3);
		route[1] = new Track();
		route[2] = new Station("Stirling", 2);
		route[3] = new Track();
		route[4] = new Station("Iverness", 2);
		Train.route = route;

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
