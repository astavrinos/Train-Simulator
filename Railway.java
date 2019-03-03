import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Railway {

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	protected String name;
	protected int capacity;
	protected int length;

	public Railway(String n, int c) {
		name = n;
		capacity = c;
	}// End of constructor

	/*
	 * Create random numbers from 0 to 1. 0 = localTrain 1 = expressTrain and add
	 * train to the first station
	 */
	@SuppressWarnings("boxing")
	public Train assignTrainModel(int IDcounter) {
		Random rand = new Random();
		int n = rand.nextInt(2);

		if (n == 0) {
			Controller.trainsInStation[0].add(IDcounter);
			LocalTrain localTrain = new LocalTrain(IDcounter);
			localTrain.setCurrent(0);
			return localTrain;
		} else if (n == 1) {
			Controller.trainsInStation[0].add(IDcounter);
			ExpressTrain expressTrain = new ExpressTrain(IDcounter);
			expressTrain.setCurrent(0);
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
			Controller.trainsInStation[train.getCurrent() - 1].remove(Integer.valueOf(train.trainID));
			Controller.route[train.current - 1].setCapacity(capacity++);
			condition.signalAll();
		} finally {
			lock.unlock();
		} // End of try/finally
	}// End of removeTrain()

	/*
	 * Add a train to the indicated value
	 */
	@SuppressWarnings("boxing")
	public void addTrain(Train train) {
		lock.lock();
		try {
			while (Controller.trainsInStation[train.getCurrent()].size() == Controller.route[train.getCurrent()]
					.getCapacity()) {
				condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			Controller.trainsInStation[(train.getCurrent())].add(train.trainID);
		} // End of try/catch/finally
	}// End of addTrain()

	/*
	 * Getters and Setters
	 */
	public String getName() {
		return name;
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

}// End of Railway
