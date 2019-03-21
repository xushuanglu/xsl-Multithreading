package com.非阻塞队列.ConcurrentHashMap.hashtable;

public class Test_HashTable {

	public static void main(String[] args) {
		MyService2 service = new MyService2();
		//HashTable在多线程环境下不会出错
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
