/*
 * Requirements:
 * 
 * Local trains can go 10 meters per second.
 */
public class LocalTrain extends Train {

	private final int speed = 10;
	private String localTrainName;
	private int trainID;

	public LocalTrain(String localTrainName, int trainID) {
		this.setLocalTrainName(localTrainName);
		this.setTrainID(trainID);
	}

	/*
	 * Getters and Setters
	 */
	public String getLocalTrainName() {
		return localTrainName;
	}

	public void setLocalTrainName(String localTrainName) {
		this.localTrainName = localTrainName;
	}

	public int getLocalTrainSpeed() {
		return speed;
	}

	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
	}

}
