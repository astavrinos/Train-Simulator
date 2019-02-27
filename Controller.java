import java.util.Random;

/*
 * The controller will manage all the objects together
 */
public class Controller implements Runnable {
	Thread threadList = new Thread();
	protected String trainName;
	protected int trainID;

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

		// create multiple threads with while loop
		while (true) {
			threadList = new Thread();
			threadList.setName("Train" + trainID);
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
			trainID++;
		} // End of while loop
	}// End of createThreads()

	/*
	 * Assign the train model randomly
	 */
	public void assignTrainModel() {

		/*
		 * Create random numbers from 0 to 1. 0 = localTrain 1 = expressTrain
		 */
		Random rand = new Random();
		int n = rand.nextInt(2);

		if (n == 0) {
			System.out.println("Local train is here.");
			LocalTrain localTrain = new LocalTrain(getTrainName(), getTrainID());

		} else if (n == 1) {
			System.out.println("Express train is here.");
			ExpressTrain expressTrain = new ExpressTrain(getTrainName(), getTrainID());
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

	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
	}

}