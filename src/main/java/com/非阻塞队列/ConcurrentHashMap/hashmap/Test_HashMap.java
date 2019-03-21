package com.非阻塞队列.ConcurrentHashMap.hashmap;

public class Test_HashMap {

	public static void main(String[] args) {
		MyService1 service = new MyService1();
		//单线程
//		ThreadA a = new ThreadA(service);
//		a.start();
		//多线程   出现假死，线程不安全
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
