package com.·Ç×èÈû¶ÓÁÐ.CopyOnWriteArrayList.CopyOnWriteArrayList;

public class ThreadB extends Thread{
	
	private MyServiceB service;
	public ThreadB(MyServiceB service) {
		super();
		this.service = service;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			service.list.add("anyString");
		}
	}
}
