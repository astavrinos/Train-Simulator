import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * The controller will manage all the objects together
 */
public class Controller implements Runnable {
	Thread threadList = new Thread();
	Railway rail = new Railway("mlm", 2);
	
	Railway[] thisRoute = RunMe.route;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		createThreads();
	}

	/*
	 * Create threads
	 */
	public void createThreads() {
		rail.foua();

		// create multiple threads with while loop
		while (true) {

//			trainName = "Train" + trainID;

			Train thomas = rail.assignTrainModel();
			// Train thomas = new Train();
			threadList = new Thread(thomas);

			// Now go to run()
			threadList.start();

			// Now show the route
			routeView();
			// Sleep thread for 2 seconds
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End of try-catch
				// Increment trainID by one
			rail.trainID++;
		} // End of while loop
	}// End of createThreads()

	/*
	 * Assign the train model randomly
	 */


	private void routeView() {
		String leftAlignFormat = "|---%-7s---||---%-5s---||---%-8s---||---%-5s---||---%-5s---||---%-5s---||---%-8s---|%n";
		System.out.format(leftAlignFormat, RunMe.route[0].getName() + "--" + rail.iliketrains[0], RunMe.route[1].getName(),
				RunMe.route[2].getName(), RunMe.route[3].getName(), RunMe.route[4].getName(), RunMe.route[5].getName(),
				RunMe.route[6].getName());
	}



	/*
	 * Setters and Getters
	 */
//	public String getTrainName() {
//		return trainName;
//	}
//
//	public void setTrainName(String trainName) {
//		this.trainName = trainName;
//	}
//
//	public int getTrainID() {
//		return trainID;
//	}
//
//	public void setTrainID(int trainID) {
//		this.trainID = trainID;
//	}

}