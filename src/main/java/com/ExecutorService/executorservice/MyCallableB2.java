package com.ExecutorService.executorservice;

import java.util.concurrent.Callable;

public class MyCallableB2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("MyCallable begin  " + System.currentTimeMillis());
		for (int i = 0; i < 223456; i++) {
			if(Thread.currentThread().isInterrupted() == false) {
				Math.random();
				Math.random();
				Math.random();
				System.out.println("MyCallableA  " + (i + 1));
			}else {
				System.out.println("************************抛出异常中断了");
				throw new InterruptedException();
			}
		}
		System.out.println("MyCallableA   end " + System.currentTimeMillis());
		return "returnB";
	}

}
