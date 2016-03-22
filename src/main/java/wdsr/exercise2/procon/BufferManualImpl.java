package wdsr.exercise2.procon;

import java.util.ArrayDeque;
import java.util.Queue;


public class BufferManualImpl implements Buffer {
	
	Queue<Order> listOfOrder = new ArrayDeque(100000);
	
	public void submitOrder(Order order) throws InterruptedException {
		listOfOrder.add(order);
	}
	
	public Order consumeNextOrder() throws InterruptedException {
		
		return listOfOrder.remove();
	}
}
