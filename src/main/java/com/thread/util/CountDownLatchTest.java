package com.thread.util;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch�÷�
 * 
 * @author Administrator
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread() {
			public void run() {
				try {
					System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
					Thread.sleep(3000);
					System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		new Thread() {
			public void run() {
				try {
					System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
					Thread.sleep(3000);
					System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		try {
			System.out.println("�ȴ�2�����߳�ִ�����...");
			latch.await();
			System.out.println("2�����߳��Ѿ�ִ�����");
			System.out.println("����ִ�����߳�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * �߳�Thread-0����ִ�� �߳�Thread-1����ִ�� �ȴ�2�����߳�ִ�����... �߳�Thread-0ִ����� �߳�Thread-1ִ�����
	 * 2�����߳��Ѿ�ִ����� ����ִ�����߳�
	 */
}
