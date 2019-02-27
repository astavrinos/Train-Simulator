
public class RailwayComponent {

	private String stationName;
	private int stationCapacity;

	public RailwayComponent(String stationName, int stationCapacity) {
		setStationName(stationName);
		setStationCapacity(stationCapacity);
	}

	public void assignTrainToRoute() {

	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getStationCapacity() {
		return stationCapacity;
	}

	public void setStationCapacity(int stationCapacity) {
		this.stationCapacity = stationCapacity;
	}

}
