/*
 * Requirements:
 * 
 * Tracks can have 1 train only at a time.
 */
public class Track extends Railway {

	public Track(String n, int c) {
		super(n, c);
		c = 1;
		// TODO Auto-generated constructor stub
	}


	final int length = 1000;
	final int capacity = 1;

	
	public String getName() {
		return name;
	}

}
