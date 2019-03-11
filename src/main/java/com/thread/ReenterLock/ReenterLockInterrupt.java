package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �߳��ж���Ӧ
 * ����߳�������synchronized����ôҪô��ȡ����������ִ�У�Ҫôһֱ�ȴ���
 * �������ṩ����һ�ֿ��ܣ������ж��̡߳���������������������̹߳���һ��������Ȼ���ж�����һ���̣߳�
 * 
 * thread-1�õ���֮���̼߳����������ȴ�20�룬Ȼ��thread-2��������û���õ�������ʱ���ж�thread-2�̣߳��߳�2�˳���
 * @author Administrator
 */
public class ReenterLockInterrupt {
	private static ReentrantLock lock = new ReentrantLock();

	private static Runnable runnable = () -> {
		try {
			// ���� lockInterruptibly ������,���ǿ��Խ��ж����������������
			lock.lockInterruptibly();
			// ˯��20�룬��˯�߽���֮ǰ��main������Ҫ�ж�thread2�Ļ�ȡ������
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			String threadName = Thread.currentThread().getName();
			// �жϺ��׳��쳣�����Ҫ�ͷ���
			// ������߳�1���ͷ�������Ϊ�߳�2��û�õ��������Բ����ͷ�
			if ("Thread-1".equals(threadName))
				lock.unlock();
			System.out.println(threadName + " ֹͣ");
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread-1");
		Thread thread2 = new Thread(runnable, "thread-2");
		thread1.start();

		// �����߳�ͣһ�£���thread1��ȡ����������thread2
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// ����ʲôҲ����
		}

		thread2.start();
		thread2.interrupt();
	}
}
