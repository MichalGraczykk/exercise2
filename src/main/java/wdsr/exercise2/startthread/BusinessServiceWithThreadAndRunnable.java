package wdsr.exercise2.startthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusinessServiceWithThreadAndRunnable {
	private NumericHelper helper;
	
	public BusinessServiceWithThreadAndRunnable(NumericHelper helper) {
		this.helper = helper;
	}

	/**
	 * Calculates Fibonacci number asynchronously and invokes the callback when result is available.
	 * This method returns immediately. 
	 * @param n Which Fibonacci number should be computed.
	 * @param callback Callback to be invoked when Fibonacci number is found.
	 */
	public void computeFibonacci(int n, FibonacciCallback callback) {
		// TODO Task: execute the logic below in a new Thread, use Runnable interface.
		ExecutorService task = Executors.newFixedThreadPool(2); 
		
		task.execute(() -> {
			long value = helper.findFibonacciValue(n);
			callback.fibonacciComputed(value);
		});
		task.shutdown();
	}
}
