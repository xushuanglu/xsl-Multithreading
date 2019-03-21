package com.非阻塞队列.ConcurrentLinkedDeque;

/**
 * 类ConcurrentLinkedQueue仅支持列头进行操作，而ConcurrentLinkedDeque支持对列头列尾双向操作。
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {

		try {
			MyService service = new MyService();
			ThreadA a = new ThreadA(service);
			ThreadB b = new ThreadB(service);
			a.start();
			b.start();
			a.join();
			b.join();

			System.out.println(service.queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
