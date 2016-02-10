package implementation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProductFactory {

	public static synchronized ProductFactory getInstance() {
		if (null == instance) {
			instance = new ProductFactory();
		}
		return instance;
	}

	private static ProductFactory instance = new ProductFactory();
	private BlockingQueue<LineDTO> queue;
	// private Lock lock;

	private ProductFactory() {
		queue = new LinkedBlockingQueue<>();
		// lock = new ReentrantLock();
	}

	public void add(LineDTO data) {
		synchronized (queue) {
			queue.add(data);
			queue.notify();
		}
	}

	public LineDTO get() {
		synchronized (queue) {
			if (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return queue.poll();
		}
	}
}
