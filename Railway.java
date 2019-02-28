import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * RailwayComponent is the parent of
 * Station and Track
 */

public class Railway {

	ArrayList<Integer>[] iliketrains = new ArrayList[7];
	ArrayList<Integer> activeTrains = new ArrayList<Integer>();
	
	protected String name;
	protected int capacity;
	protected int length;
	
	protected String trainName;
	protected int trainID = 0;
	
	public Railway(String n, int c) {
		name = n;
		capacity = c;
	}

	public Train assignTrainModel() {

		/*
		 * Create random numbers from 0 to 1. 0 = localTrain 1 = expressTrain
		 */
		Random rand = new Random();
		int n = rand.nextInt(2);

		if (n == 0 && (iliketrains[0] == null || iliketrains[0].size() < RunMe.route[0].capacity)) {
			activeTrains.add(trainID);
			iliketrains[0].add(trainID);
			LocalTrain localTrain = new LocalTrain(trainName, trainID);
			return localTrain;
			
		} else if (n == 1 && (iliketrains[0] == null || iliketrains[0].size() < RunMe.route[0].capacity)) {
			activeTrains.add(trainID);
			iliketrains[0].add(trainID);
			ExpressTrain expressTrain = new ExpressTrain(trainName, trainID);
			return expressTrain;
		} // End of else-if
		return null;
	}// End of assignTrainModel()
	
	public void foua() {
		for (int i = 0; i < iliketrains.length; i++) {
			iliketrains[i] = new ArrayList<Integer>();
		}
	}
	
	/*
	 * Getters and Setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	/*
	 * method for ADDING A TRAIN
	 */
	
	/*
	 * method for TRAIN LEAVING
	 */

}
