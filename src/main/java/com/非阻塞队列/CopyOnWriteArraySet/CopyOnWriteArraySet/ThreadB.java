package com.����������.CopyOnWriteArraySet.CopyOnWriteArraySet;

public class ThreadB extends Thread{

	private MyServiceB service;
	
	public ThreadB(MyServiceB service) {
		super();
		this.service = service;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			service.set.add(Thread.currentThread().getName() + "anyString" + ( i + 1));
		}
	}
	
}
