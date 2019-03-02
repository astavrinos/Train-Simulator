/*
 * Requirements:
 * 
 * Local trains can go 10 meters per second.
 */
public class LocalTrain extends Train {

	private final int speed = 100; // change later

	public LocalTrain(int trainID) {
		super(10);
		Train.trainID = trainID;
	}

	public void asignToStation() {

	}

	/*
	 * Getters and Setters
	 */
	public int getLocalTrainSpeed() {
		return speed;
	}

}
