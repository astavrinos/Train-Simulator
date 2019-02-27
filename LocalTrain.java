/*
 * Requirements:
 * 
 * Local trains can go 10 meters per second.
 */
public class LocalTrain extends Train {

	private final int localTrainSpeed = 10;
	private String localTrainName;

	public LocalTrain(String localTrainName) {
		this.setLocalTrainName(localTrainName);
		assignLocalTrainToStation(getLocalTrainName(), localTrainSpeed);
	}

	public void assignLocalTrainToStation(String localTrainName, int localTrainSpeed) {
		// TODO ASSIGN STATION
	}

	public String getLocalTrainName() {
		return localTrainName;
	}

	public void setLocalTrainName(String localTrainName) {
		this.localTrainName = localTrainName;
	}

	public int getLocalTrainSpeed() {
		return localTrainSpeed;
	}

}
