/*
 * Requirements:
 * 
 * The fast train can go 500 meters per second
 */
public class ExpressTrain extends Train {

	private final int expressTrainSpeed = 500;
	private String expressTrainName;

	public ExpressTrain(String trainName) {
		this.setExpressTrainName(trainName);
		assignExpressTrainToStation(getExpressTrainName(), expressTrainSpeed);
	}

	public void assignExpressTrainToStation(String expressTrainName, int expressTrainSpeed) {
		// TODO ASSIGN STATION
	}

	public String getExpressTrainName() {
		return expressTrainName;
	}

	public void setExpressTrainName(String expressTrainName) {
		this.expressTrainName = expressTrainName;
	}

	public int getExpressTrainSpeed() {
		return expressTrainSpeed;
	}

}