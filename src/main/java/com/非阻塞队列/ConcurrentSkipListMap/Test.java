package com.非阻塞队列.ConcurrentSkipListMap;

/**
 * 有时候顺序也不对
 * @author Administrator
 *
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
