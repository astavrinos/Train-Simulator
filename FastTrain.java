/*
 * Requirements:
 * 
 * The fast train can go 500 meters per second
 */
public class FastTrain extends Train {

	private final int distanceMeters = 500;
	private final int time = 2;

	public void createFastTrain() {
		System.out.println("Fast train created: " + distanceMeters + " meters per " + time + " seconds.");
		
	}

}
