package com.thread.thread;

import java.util.Arrays;
import java.util.List;

/**
 * Lambdaʵ�ֶ��߳�
 * @author Administrator
 */
public class Demo4 {
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(10,20,30,40);
		int res = new Demo4().add(values);
		System.out.println("������Ľ��Ϊ��" + res);
	}

	public int add(List<Integer> values) {
		return values.parallelStream().mapToInt(a -> a).sum();
	}
}
