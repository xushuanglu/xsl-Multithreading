package com.·Ç×èÈû¶ÓÁÐ.ConcurrentHashMap.hashtable_remove;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		MyService4 myService4 = new MyService4();
		ThreadA a = new ThreadA(myService4);
		a.start();
		Thread.sleep(1000);
		
		ThreadB b = new ThreadB(myService4);
		b.start();
	}
}
