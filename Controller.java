import java.util.Random;

/*
 * The controller will manage all the objects together
 */
public class Controller implements Runnable {

	LocalTrain localTrain = new LocalTrain();
	FastTrain fastTrain = new FastTrain();

	public Controller() {
		// initialize();
	}

	public void assignTrainModel() {
		Random rand = new Random();
		int n = rand.nextInt(2);
//		System.out.println("Train Model: " + n);

		if (n == 0) {
			localTrain.createLocalTrain();
		} else if (n == 1) {
			fastTrain.createFastTrain();
		}
	}

	public void run() {
		assignTrainModel();
	}

}