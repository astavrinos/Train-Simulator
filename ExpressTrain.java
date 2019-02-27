/*
 * Requirements:
 * 
 * The fast train can go 500 meters per second
 */
public class ExpressTrain extends Train {

	private final int expressTrainSpeed = 500;
	private String expressTrainName;
	Controller controller = new Controller();
	private int trainID;

	public ExpressTrain(String trainName, int trainID) {
		this.setExpressTrainName(trainName);
		this.trainID = trainID;
//		assignToStation();
	}

	public void assignToStation() {
		System.out.println(controller.activeTrains.get(controller.activeTrains.size()-1));
	}
	
	/*
	 * Getters and Setters
	 */
	public String getExpressTrainName() {
		return expressTrainName;
	}

	public void setExpressTrainName(String expressTrainName) {
		this.expressTrainName = expressTrainName;
	}

	public int getExpressTrainSpeed() {
		return expressTrainSpeed;
	}

	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
	}

}
