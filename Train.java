public class Train implements Runnable {

	public static Railway[] route;
	public int current = getCurrent();
	protected int speed;
	protected int time;
	protected static int trainID;

	public Train(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {

		try {
			boolean status = true;
			while (status) {
				Controller.route[current + 1].addTrain(this);
//				System.out.println("Added");
				Controller.route[current].removeTrain(this);
//				System.out.println("removed");
				Thread.sleep((int) (1000 * countdown()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int countdown() {
		while (current < Controller.route.length) {
			// move the train forward in each iteration
			time = Controller.route[current].getLength() / speed + 5;
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return time;
	}

	/*
	 * Getters and Setters
	 */
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

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
