package com.����������.ConcurrentLinkedDeque;

public class ThreadA extends Thread{
	
	private MyService service;
	
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}
	
	public void run() {
		while(!service.queue.isEmpty()) {
			service.queue.pollFirst();
			System.out.println(service.queue.size());
		}
	}

}
