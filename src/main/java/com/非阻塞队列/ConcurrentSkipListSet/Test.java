package com.����������.ConcurrentSkipListSet;

/**
 * �ɹ����򵫲�֧���ظ�����
 * @author Administrator
 */
public class Test {
	public static void main(String[] args) {
		MyService1 service1 = new MyService1();
		ThreadA a = new ThreadA(service1);
		ThreadA b = new ThreadA(service1);

		a.start();
		b.start();

	}
}
