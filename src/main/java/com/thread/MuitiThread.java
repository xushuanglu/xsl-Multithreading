package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MuitiThread {

	public static void main(String[] args) {
		//��ȡjava�̹߳���MXBean
		ThreadMXBean threadMXbean = ManagementFactory.getThreadMXBean();
		//����Ҫ��ȡͬ����monitor��synchionizer��Ϣ������ȡ�̺߳��̶߳���Ϣ
		ThreadInfo[] threadInfos = threadMXbean.dumpAllThreads(false, false);
		//�����߳���Ϣ������ӡ�߳�Id���߳�����
		// @formatter:off
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		} 
		// @formatter:on
	}
	
	/*
	[5] Attach Listener
	[4] Signal Dispatcher   // �ַ������͸�JVM�źŵ��߳�
	[3] Finalizer           // ���ö���finalize�������߳�
	[2] Reference Handler	// ���Reference���߳�
	[1] main				// main�̣߳��û��������
	*/
}
