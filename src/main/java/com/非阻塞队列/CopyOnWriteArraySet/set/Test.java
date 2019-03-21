package com.非阻塞队列.CopyOnWriteArraySet.set;

/**
 * 多线程环境下使用HsahSet是不安全的
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		MyServiceA service = new MyServiceA();
		ThreadA[] aArray = new ThreadA[100];
		for (int i = 0; i < aArray.length; i++) {
			aArray[i] = new ThreadA(service);
		}
		for (int i = 0; i < aArray.length; i++) {
			aArray[i].start();
		}
		Thread.sleep(3000);
		System.out.println(service.set.size());
	}
}
