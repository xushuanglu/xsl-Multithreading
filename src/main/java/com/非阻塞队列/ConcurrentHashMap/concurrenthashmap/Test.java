package com.非阻塞队列.ConcurrentHashMap.concurrenthashmap;


public class Test {

	public static void main(String[] args) {
		MyService3 service = new MyService3();
		//ConcurrentHashMap支持多线程
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
