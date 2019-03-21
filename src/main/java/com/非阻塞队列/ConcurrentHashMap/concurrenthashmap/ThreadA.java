package com.·Ç×èÈû¶ÓÁĞ.ConcurrentHashMap.concurrenthashmap;

public class ThreadA extends Thread{
	
	private MyService3 service;
	
	public ThreadA(MyService3 service) {
		super();
		this.service = service;
	}
	
	public void run() {
		for (int i = 0; i < 50000; i++) {
			service.map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
			System.out.println("ThreadA" + (i + 1));
		}
	}

}
