/*
 * Requirements:
 * 
 * Tracks can have 1 train only at a time.
 */
public class Track extends Railway {

	final int length = 1000;
	final int capacity = 1;
	final String name = "Track";

	
	public String getName() {
		return name;
	}

}
