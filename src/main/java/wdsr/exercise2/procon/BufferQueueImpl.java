package wdsr.exercise2.procon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BufferQueueImpl implements Buffer {
	
	BlockingQueue<Object> queue = new ArrayBlockingQueue<>(100000);
	
	public void submitOrder(Order order) throws InterruptedException {
		queue.put(order);
	}
	
	public Order consumeNextOrder() throws InterruptedException {
		
		return (Order) queue.take();
	}
}
