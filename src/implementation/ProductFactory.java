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
	private boolean areProducersDone;

	private ProductFactory() {
		queue = new LinkedBlockingQueue<>();
		areProducersDone = false;
	}

	public void add(LineDTO data) {
		synchronized (queue) {
			queue.add(data);
			queue.notify();
		}
	}

	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public LineDTO get() {
		synchronized (queue) {
			while (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return queue.poll();
		}
	}
	
	public boolean isProducingFinished() {
		return areProducersDone;
	}
	
	public void setFinished() {
		this.areProducersDone = true;
	}
}
