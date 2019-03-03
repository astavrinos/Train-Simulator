import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Controller extends Thread {

	@SuppressWarnings("unchecked")
	public static ArrayList<Integer>[] trainsInStation = new ArrayList[7];
	public static Railway[] route = new Railway[7];
	public int IDcounter = 0;
	private Lock lock = new ReentrantLock();

	public Controller() {
		route[0] = new Station("Glasgow", 3);
		route[1] = new Track("Track", 1);
		route[2] = new Station("Stirling", 2);
		route[3] = new Track("Track", 1);
		route[4] = new Station("Perth", 2);
		route[5] = new Track("Track", 1);
		route[6] = new Station("Inverness", 2);
		fillArray();
	}// End of constructor

	@SuppressWarnings("static-access")
	public void run() {
		while (true) {
			createThreads(IDcounter);
			routeView();
			try {
				this.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}// End of run()

	/*
	 * Create threads
	 */
	public void createThreads(int IDcounter) {

		// create multiple threads with while loop and assign them to Glasgow station
		if (trainsInStation[0].size() < route[0].getCapacity()) {
			Train train = route[0].assignTrainModel(IDcounter);
			Thread thread = new Thread();
			thread = new Thread(train);
			// Now go to run() in the Train
			thread.start();
			this.IDcounter++;
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
		lock.lock();
		String leftAlignFormat = "|---%-7s---||---%-5s---||---%-8s---||---%-5s---||---%-5s---||---%-5s---||---%-8s---|%n";
		System.out.format(leftAlignFormat, route[0].getName() + "--" + trainsInStation[0],
				route[1].getName() + "--" + trainsInStation[1], route[2].getName() + "--" + trainsInStation[2],
				route[3].getName() + "--" + trainsInStation[3], route[4].getName() + "--" + trainsInStation[4],
				route[5].getName() + "--" + trainsInStation[5], route[6].getName() + "--" + trainsInStation[6]);
		lock.unlock();
	}// End of routeView()

}// End of Controller