package com.����������.ConcurrentLinkedQueue;

public class Test {

	public static void main(String[] args) {
		/**
		 * ֧�ֲ�������������Ԫ��
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
		
		//������ʱ����Ϊnull
		MyService1 service = new MyService1();
		System.out.println("������ʱ����Ϊnull:   " + service.queue.poll());
		
		//֧�ֶ���ͷ���в���
		service.queue.add("a");
		service.queue.add("b");
		service.queue.add("c");
		
		System.out.println("֧�ֶ���ͷ���в���:    " + service.queue.poll());
	}
}
