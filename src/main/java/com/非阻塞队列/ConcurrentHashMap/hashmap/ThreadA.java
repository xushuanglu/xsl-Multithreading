package com.·Ç×èÈû¶ÓÁĞ.ConcurrentHashMap.hashmap;

public class ThreadA extends Thread{
	
	private MyService1 myService1;
	
	public ThreadA(MyService1 myService1) {
		super();
		this.myService1 = myService1;
	}
	
	public void run() {
		for (int i = 0; i < 50000; i++) {
			myService1.map.put("ThreadA" + (i + 1), "ThreadA" + i + 1);
			System.out.println("ThreadA" + (i + 1));
		}
	}

}
