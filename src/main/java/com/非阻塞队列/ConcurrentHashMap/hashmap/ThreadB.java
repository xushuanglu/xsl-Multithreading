package com.·Ç×èÈû¶ÓÁĞ.ConcurrentHashMap.hashmap;

public class ThreadB extends Thread{
	
	private MyService1 myService1;
	
	public ThreadB(MyService1 myService1) {
		super();
		this.myService1 = myService1;
	}
	
	public void run() {
		for (int i = 0; i < 50000; i++) {
			myService1.map.put("ThreadB" + (i + 1), "ThreadB" + i + 1);
			System.out.println("ThreadB" + (i + 1));
		}
	}

}
