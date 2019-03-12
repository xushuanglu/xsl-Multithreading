package com.thread.ReenterLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ʱ��ĵȴ���
 * 
 * ����ʹ��tryLock()��һ����ȡ�����̣߳���ֹͣ5�롣����ȡ��������Ϊ3���ȡ����������������Եڶ���ȥ���Ի�ȡ�����߳��ǻ�ȡ������������ֹͣ�ġ�
 * ���tryLock()�����������κβ�������ô��ȡ�����̲߳���ȴ���������������false��
 * @author Administrator
 *
 */
public class ReenterTryLock {
	private static ReentrantLock reenterLock = new ReentrantLock();

	private static Runnable runnable = () -> {
		try {
			// tryLock()�����᷵��һ������ֵ����ȡ���ɹ���Ϊtrue
			if (reenterLock.tryLock(3, TimeUnit.SECONDS)) {
				Thread.sleep(5000);
			} else {
				System.out.println(Thread.currentThread().getName() + "��ȡ��ʧ��");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// ��������ǰǰ���ڳ����������ͷ���
			if (reenterLock.isHeldByCurrentThread()) {
				System.out.println(Thread.currentThread().getName() + "�ͷ�����");
				reenterLock.unlock();
			}
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread-1");
		Thread thread2 = new Thread(runnable, "thread-2");

		thread1.start();
		thread2.start();
	}
}
