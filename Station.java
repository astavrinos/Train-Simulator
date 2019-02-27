/*
 * Requirements:
 * 
 * Station 1 can have capacity of 3.
 * Station 2 can have capacity of 2.
 * Station 3 can have capacity of 2.
 * 
 * Each stop in the stations can last up to 5 seconds.
 */
public class Station extends RailwayComponent {

	final int length = 100;

	public Station(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		// TODO Auto-generated constructor stub
	}

}