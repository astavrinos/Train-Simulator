public class Track extends Railway {

	final int length = 1000;
	final int capacity = 1;

	public Track(String n, int c) {
		super(n, c);
		c = 1;
	}// End of constructor

	/*
	 * Getter
	 */
	public int getLength() {
		return length;
	}

}// End of Track
