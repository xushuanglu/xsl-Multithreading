package com.·Ç×èÈû¶ÓÁÐ.ConcurrentHashMap.hashtable_remove;

public class ThreadB extends Thread{
	
	private MyService4 service;
	
	public ThreadB(MyService4 service) {
		super();
		this.service = service;
	}
	
	public void run() {
		service.map.put("z", "zValue");
	}

}
