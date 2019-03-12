package com.thread.ReenterLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * thread�C1�������õ�����Ȼ�����ȴ������ͷ�����2������߳��õ�����Ȼ�󷢳��źŲ��ͷ��������thread�C1����ִ�С�
 * @author Administrator
 */
public class ReenterLockCondition {
	private static ReentrantLock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	private static Runnable runnable = () -> {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "����ȴ�����");
			condition.await();
			System.out.println(Thread.currentThread().getName() + "����ִ��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	};

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(runnable, "thread--1");
		thread.start();

		Thread.sleep(2000);

		lock.lock();
		condition.signal();
		System.out.println("���̷߳����ź�");
		lock.unlock();
	}
}
