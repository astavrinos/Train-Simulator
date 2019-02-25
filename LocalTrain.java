/*
 * Requirements:
 * 
 * Local trains can go 10 meters per second.
 */
public class LocalTrain extends Train {

	private final int distanceMeters = 10;
	private final int time = 1;
	
	public void createLocalTrain() {
		System.out.println("Local train created: " + distanceMeters + " meters per " + time + " second.");
	}
	
}
