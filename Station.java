public class Station extends Railway {
	final int length = 100;

	public Station(String n, int c) {
		super(n, c);
	}// End of constructor

	/*
	 * Getter
	 */
	public int getLength() {
		return length;
	}

}// End of Station