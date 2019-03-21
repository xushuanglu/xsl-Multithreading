package com.×èÈû¶ÓÁĞ.SynchronousQueue;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		ThreadPut threadPut = new ThreadPut(service);
		ThreadTake threadTake = new ThreadTake(service);
		
		threadTake.start();
		Thread.sleep(2000);
		
		threadPut.start();
		
	}
}
