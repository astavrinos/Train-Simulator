public class Train implements Runnable {

	public int current;
	protected int speed;
	protected int time;
	protected int trainID;

	public Train(int speed) {
		this.speed = speed;
	}// End of constructor

	@Override
	public void run() {
		try {
			while (true) {
				if (Controller.route[current].getLength() == 1000) {
					Thread.sleep((Controller.route[current].getLength() / speed) * 1000);
				} else if (Controller.route[current].getLength() == 100) {
					Thread.sleep((Controller.route[current].getLength() / speed + 5) * 1000);
				}// End of if else if
				current++;
				if (current == 7) {
					Controller.route[getCurrent() - 1].removeTrain(this);
					break;
				}// End of if
				Controller.route[getCurrent()].addTrain(this);
				Controller.route[getCurrent() - 1].removeTrain(this);
			}// End of while loop
		} catch (InterruptedException e) {
			e.printStackTrace();
		}// End of try/catch
	}// End of run()

	/*
	 * Getters and Setters
	 */
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}// End of Train
