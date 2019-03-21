package com.非阻塞队列.CopyOnWriteArrayList.Arraylist;

/**
 * 会出现异常
 * 
 * Exception in thread "Thread-1" Exception in thread "Thread-5" Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 65
	at java.util.ArrayList.add(Unknown Source)
	at com.非阻塞队列.CopyOnWriteArrayList.ThreadA.run(ThreadA.java:13)
java.lang.ArrayIndexOutOfBoundsException: 150
	at java.util.ArrayList.add(Unknown Source)
	at com.非阻塞队列.CopyOnWriteArrayList.ThreadA.run(ThreadA.java:13)
java.lang.ArrayIndexOutOfBoundsException: 64
	at java.util.ArrayList.add(Unknown Source)
	at com.非阻塞队列.CopyOnWriteArrayList.ThreadA.run(ThreadA.java:13)
9600
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
		System.out.println(service.list.size());
	}
}
