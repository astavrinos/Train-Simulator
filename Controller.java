import java.util.ArrayList;

/*
 * The controller will manage all the objects together
 */
public class Controller implements Runnable {

	@SuppressWarnings("unchecked")
	public static ArrayList<Integer>[] trainsInStation = new ArrayList[7];
	public static Railway[] route = new Railway[7];

	public void run() {
		route[0] = new Station("Glasgow", 3);
		route[1] = new Track("Track", 1);
		route[2] = new Station("Stirling", 2);
		route[3] = new Track("Track", 1);
		route[4] = new Station("Perth", 2);
		route[5] = new Track("Track", 1);
		route[6] = new Station("Inverness", 2);
		Train.route = route;
		fillArray();
		createThreads();
	}

	/*
	 * Create threads
	 */
	public void createThreads() {

		// create multiple threads with while loop
		while (trainsInStation[0].size() < route[0].getCapacity()) {
			Train train = route[0].assignTrainModel();
			Thread thread = new Thread();
			thread = new Thread(train);
			// Now go to run() in the Train
			thread.start();
			// Now show the route
			routeView();
			// Sleep thread for 2 seconds
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End of try-catch
			Train.trainID++;
		} // End of while loop

	}// End of createThreads()

	/*
	 * Fill the trainsInStation Array to not throw null exception
	 */
	public void fillArray() {
		for (int i = 0; i < trainsInStation.length; i++) {
			trainsInStation[i] = new ArrayList<Integer>();
		}
	}

	/*
	 * Print out the view of the route
	 */
	private void routeView() {
		String leftAlignFormat = "|---%-7s---||---%-5s---||---%-8s---||---%-5s---||---%-5s---||---%-5s---||---%-8s---|%n";
		System.out.format(leftAlignFormat, route[0].getName() + "--" + trainsInStation[0],
				route[1].getName() + "--" + trainsInStation[1], route[2].getName() + "--" + trainsInStation[2],
				route[3].getName() + "--" + trainsInStation[3], route[4].getName() + "--" + trainsInStation[4],
				route[5].getName() + "--" + trainsInStation[5], route[6].getName() + "--" + trainsInStation[6]);
	}

}