package com.·Ç×èÈû¶ÓÁÐ.ConcurrentLinkedDeque;

public class ThreadB extends Thread{
	
	private MyService service;
	
	public ThreadB(MyService service) {
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
