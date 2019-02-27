import java.util.Random;

/*
 * The controller will manage all the objects together
 */
public class Controller implements Runnable {
	Thread threadList = new Thread();

	int[] stationCapacity = new int[] { 3, 2, 2 };
	String[] stationName = new String[] { "Glasgow", "Stirling", "Inverness" };

	protected String trainName;	
	
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
		int i = 0;

		// create multiple threads with while loop
		while (true) {
			threadList = new Thread();
			threadList.setName("Train" + i);
			// Set the assigned name of the train
			setTrainName(threadList.getName());
			// Print the name just to make sure
			System.out.println(threadList.getName());
			// Now go to run()
			threadList.start();
			// No go to assignTrainModel()
			assignTrainModel();
			// Sleep thread for 2 seconds
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // End of try-catch
			// Increment i by one
			i++;
		} // End of while loop
	}// End of createThreads()

	/*
	 * Assign the train model randomly
	 */
	public void assignTrainModel() {

		RailwayComponent[] route = new RailwayComponent[5];
		route[0] = new Station("Glasgow", 3);
		route[1] = new Track();
		route[2] = new Station("Stirling", 2);
		route[3] = new Track();
		route[4] = new Station("Iverness", 2);
		Train.route = route;
		
		/*
		 * Create random numbers from 0 to 1. 0 = localTrain 1 = expressTrain
		 */
		Random rand = new Random();
		int n = rand.nextInt(2);

		if (n == 0) {
			System.out.println("Local train is here.");
			LocalTrain localTrain = new LocalTrain(getTrainName());
			
		} else if (n == 1) {
			System.out.println("Express train is here.");
			ExpressTrain expressTrain = new ExpressTrain(getTrainName());
		} // End of else-if
	}// End of assignTrainModel()

	/*
	 * Setters and Getters
	 */
	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

}