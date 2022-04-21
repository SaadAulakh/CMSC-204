import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	Random ran = new Random();
	ArrayDeque<Integer> queue;

	public CarQueue() {

		queue = new ArrayDeque<Integer>();
		for (int i = 0; i < 7; i++) {
			queue.add(ran.nextInt(4));
		}
	}

	public void addToQueue() {
		class CarRunnable implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {

					try {
						int randomInt = new Random().nextInt(4);
						queue.add(randomInt);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
		Runnable r = new CarRunnable();
		Thread thread = new Thread(r);
		thread.start();
	}

	public Integer deleteQueue() {

		return queue.remove();
	}
}
