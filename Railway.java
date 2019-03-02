import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * RailwayComponent is the parent of
 * Station and Track
 */

public class Railway extends Controller {

	public ArrayList<Integer> activeTrains = new ArrayList<Integer>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	Train train = new Train(0);

	protected String name; // Used for this constructor
	protected int capacity; // Used for this constructor
	protected int length; // Used in train

	protected String trainName;

	public Railway(String n, int c) {
		name = n;
		capacity = c;
	}

	/*
	 * Create random numbers from 0 to 1. 0 = localTrain 1 = expressTrain
	 */
	@SuppressWarnings("boxing")
	public Train assignTrainModel() {

		Random rand = new Random();
		int n = rand.nextInt(2);

		if (n == 0) {
			activeTrains.add(Train.trainID);
//			System.out.println(Train.trainID);
			trainsInStation[0].add(Train.trainID);
			LocalTrain localTrain = new LocalTrain(Train.trainID);
			localTrain.current = 0;
			return localTrain;
		} else if (n == 1) {
			activeTrains.add(Train.trainID);
			trainsInStation[0].add(Train.trainID);
			ExpressTrain expressTrain = new ExpressTrain(Train.trainID);
			expressTrain.current = 0;
			return expressTrain;
		} // End of else-if
		return null;
	}// End of assignTrainModel()

	/*
	 * Remove train from route indicated value
	 */
	public void removeTrain(Train train) {
		lock.lock();
		try {
			condition.await();
			trainsInStation[train.getCurrent() - 1].remove(new Integer(Train.trainID));
			route[0].setCapacity(capacity + 1);
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}
	}

	/*
	 * Add a train to the indicated value
	 */
	@SuppressWarnings("boxing")
	public void addTrain(Train train) {
		lock.lock();
		if (trainsInStation[1].size() > route[1].getCapacity()) {
			trainsInStation[(train.getCurrent() + 1)].add(Train.trainID);
			condition.signalAll();
		}
		lock.unlock();
		train.setCurrent(train.current + 1);
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

}