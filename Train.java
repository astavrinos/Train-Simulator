
public class Train implements Runnable {

	public static Railway[] route;
	Controller controller = new Controller();
	/*
	 * create a variable for CURRENT station for THIS train
	 */
	
	protected int speed;
	protected int time;
	protected int trainID;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		/*
		 * 
		 */
		
	}

	

}
