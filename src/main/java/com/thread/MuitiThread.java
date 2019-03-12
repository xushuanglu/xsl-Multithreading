package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MuitiThread {

	public static void main(String[] args) {
		//获取java线程管理MXBean
		ThreadMXBean threadMXbean = ManagementFactory.getThreadMXBean();
		//不需要获取同步的monitor和synchionizer信息，仅获取线程和线程堆信息
		ThreadInfo[] threadInfos = threadMXbean.dumpAllThreads(false, false);
		//遍历线程信息，仅打印线程Id和线程名称
		// @formatter:off
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		} 
		// @formatter:on
	}
	
	/*
	[5] Attach Listener
	[4] Signal Dispatcher   // 分发处理发送给JVM信号的线程
	[3] Finalizer           // 调用对象finalize方法的线程
	[2] Reference Handler	// 清除Reference的线程
	[1] main				// main线程，用户程序入口
	*/
}
