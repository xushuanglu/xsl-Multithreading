package com.����������.ConcurrentHashMap.concurrenthashmap;


public class Test {

	public static void main(String[] args) {
		MyService3 service = new MyService3();
		//ConcurrentHashMap֧�ֶ��߳�
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
