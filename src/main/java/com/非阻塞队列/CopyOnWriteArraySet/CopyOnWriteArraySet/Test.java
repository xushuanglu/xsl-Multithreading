package com.非阻塞队列.CopyOnWriteArraySet.CopyOnWriteArraySet;

/**
 * 多线程环境下CopyOnWriteArraySet是安全的
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		MyServiceB service = new MyServiceB();
		ThreadB[] aArray = new ThreadB[100];
		for (int i = 0; i < aArray.length; i++) {
			aArray[i] = new ThreadB(service);
		}
		for (int i = 0; i < aArray.length; i++) {
			aArray[i].start();
		}
		Thread.sleep(3000);
		System.out.println(service.set.size());
	}
}
