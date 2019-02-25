//import java.util.ArrayList;

/*
 * Adamos Stavrinos
 * Advance Programming, Asset Exercise 1, 2019
 * 
 * Simulation of Trains and Tracks
 */
public class RunMe {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Thread threadList = new Thread();
		int i = 0;

		// create multiple threads with while loop
		while (true) {
			threadList = new Thread(controller);
			threadList.setName("Train" + i);
//			System.out.println(threadList.getName());
			threadList.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

	}

}
