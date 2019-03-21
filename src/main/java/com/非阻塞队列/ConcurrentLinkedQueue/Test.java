package com.非阻塞队列.ConcurrentLinkedQueue;

public class Test {

	public static void main(String[] args) {
		/**
		 * 支持并发环境下增加元素
		 * @param args
		 */
		/*try {
			MyService1 service = new MyService1();
			ThreadA a = new ThreadA(service);
			ThreadB b = new ThreadB(service);

			a.start();
			b.start();
			a.join();
			b.join();
			System.out.println(service.queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		//无数据时返回为null
		MyService1 service = new MyService1();
		System.out.println("无数据时返回为null:   " + service.queue.poll());
		
		//支持对列头进行操作
		service.queue.add("a");
		service.queue.add("b");
		service.queue.add("c");
		
		System.out.println("支持对列头进行操作:    " + service.queue.poll());
	}
}
