package com.·Ç×èÈû¶ÓÁÐ.CopyOnWriteArraySet.set;

public class ThreadA extends Thread{

	private MyServiceA service;
	
	public ThreadA(MyServiceA service) {
		super();
		this.service = service;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			service.set.add(Thread.currentThread().getName() + "anyString" + ( i + 1));
		}
	}
	
}
