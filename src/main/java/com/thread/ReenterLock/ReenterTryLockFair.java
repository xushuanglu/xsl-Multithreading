package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 
 * ��ƽ����ǹ�ƽ��

��һ���߳��ͷ���ʱ�������ȴ����߳����л����ȡ��������ǹ�ƽ������������󵽵Ļ�ȡ��������Ƿǹ�ƽ����˭��������˭�ģ�����൱���Ŷ������Ͳ��Ŷ�������һ������Java��synchronized�ؼ��־��Ƿǹ�ƽ����

��ô������ReentrantLock()�ǹ�ƽ�����Ƿǹ�ƽ����

������ReentrantLock()�ǿ������ù�ƽ�Եģ����Բο��乹�췽����

// ͨ������һ������ֵ�����ù�ƽ����Ϊtrue���ǹ�ƽ����false��Ϊ�ǹ�ƽ��
public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }
 * @author Administrator
 *
 */
public class ReenterTryLockFair {
	// �ֱ����ù�ƽ���ͷǹ�ƽ����������ӡ���
	private static ReentrantLock lock = new ReentrantLock(true);

	private static Runnable runnable = () -> {
		while (true) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " ��ȡ����");
			} finally {
				lock.unlock();
			}
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread---1");
		Thread thread2 = new Thread(runnable, "thread---2");
		Thread thread3 = new Thread(runnable, "thread---3");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
