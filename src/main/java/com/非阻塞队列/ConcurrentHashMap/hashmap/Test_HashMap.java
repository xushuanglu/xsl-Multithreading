package com.����������.ConcurrentHashMap.hashmap;

public class Test_HashMap {

	public static void main(String[] args) {
		MyService1 service = new MyService1();
		//���߳�
//		ThreadA a = new ThreadA(service);
//		a.start();
		//���߳�   ���ּ������̲߳���ȫ
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
