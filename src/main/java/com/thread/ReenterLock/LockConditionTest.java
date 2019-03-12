package com.thread.ReenterLock;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {
    // ���� �� ���� ���������
    public static int totalCount = 10;
    // �Ѿ������Ĳ�Ʒ��
    public static volatile int hasProduceCount = 0;
    // �Ѿ����ѵĲ�Ʒ��
    public static volatile int hasConsumeCount = 0;
    // �����������
    public static int containerSize = 3;
    // ʹ�ù�ƽ���ԵĿ������������ڹ۲���ʾ���
    public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition notEmpty = lock.newCondition();
    public static Condition notFull = lock.newCondition();
    // ����
    public static LinkedList<Integer> container = new LinkedList<Integer>();
    // ���ڱ�ʶ��Ʒ
    public static AtomicInteger idGenerator = new AtomicInteger();

    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer(), "p-1");
        Thread p2 = new Thread(new Producer(), "p-2");
        Thread p3 = new Thread(new Producer(), "p-3");

        Thread c1 = new Thread(new Consumer(), "c-1");
        Thread c2 = new Thread(new Consumer(), "c-2");
        Thread c3 = new Thread(new Consumer(), "c-3");

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        try{
            c1.join();
            c2.join();
            c3.join();
            p1.join();
            p2.join();
            p3.join();
        }catch(Exception e){

        }
        System.out.println(" done. ");
    }
    static class Producer implements Runnable{
        @Override
        public void run() {
            while(true){
                lock.lock();
                try{
                    // �������ˣ���Ҫ�ȴ���������
                    while(container.size() >= containerSize){
                        notFull.await();
                    }

                    // �������������δ��������Ҫ�ٴ��ж��Ƿ��Ѿ����������
                    if(hasProduceCount >= totalCount){
                        System.out.println(Thread.currentThread().getName()+" producer exit");
                        return ;
                    }

                    int product = idGenerator.incrementAndGet();
                    // �����������Ĳ�Ʒ��������
                    container.addLast(product);
                    System.out.println(Thread.currentThread().getName() + " product " + product);
                    hasProduceCount++;

                    // ֪ͨ�����߳̿���ȥ������
                    notEmpty.signal();
                } catch (InterruptedException e) {
                }finally{
                    lock.unlock();
                }
            }
        }
    }
    static class Consumer implements Runnable{
        @Override
        public void run() {
            while(true){
                lock.lock();
                try{
                    if(hasConsumeCount >= totalCount){
                        System.out.println(Thread.currentThread().getName()+" consumer exit");
                        return ;
                    }

                    // һֱ�ȴ��в�Ʒ�ˣ��ټ�����������
                    while(container.isEmpty()){
                        notEmpty.await(2, TimeUnit.SECONDS);
                        if(hasConsumeCount >= totalCount){
                            System.out.println(Thread.currentThread().getName()+" consumer exit");
                            return ;
                        }
                    }

                    Integer product = container.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " consume " + product);
                    hasConsumeCount++;

                    // ֪ͨ�����߳̿��Լ���������Ʒ��
                    notFull.signal();
                } catch (InterruptedException e) {
                }finally{
                    lock.unlock();
                }
            }
        }
    }
}
