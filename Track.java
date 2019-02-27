/*
 * Requirements:
 * 
 * Tracks can have 1 train only at a time.
 */
public class Track extends RailwayComponent{

	final int trackLength = 1000;
	final int trackCapacity = 1;
	
	public Track(String stationName, int stationCapacity) {
		super(stationName, stationCapacity);
		// TODO Auto-generated constructor stub
	}

	private void checkIfThereIsTrain() {
		// TODO
	}

}
