package com.����������.ConcurrentHashMap.hashtable;

public class Test_HashTable {

	public static void main(String[] args) {
		MyService2 service = new MyService2();
		//HashTable�ڶ��̻߳����²������
		ThreadA a = new ThreadA(service);
		ThreadB b = new ThreadB(service);
		a.start();
		b.start();
	}
}
