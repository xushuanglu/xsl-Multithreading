package com.·Ç×èÈû¶ÓÁĞ.CopyOnWriteArrayList.Arraylist;

public class ThreadA extends Thread{
	
	private MyServiceA service;
	public ThreadA(MyServiceA service) {
		super();
		this.service = service;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			service.list.add("anyString");
		}
	}
}
