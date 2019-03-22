		线程、并发学习

【死磕Java并发】—–深入分析synchronized的实现原理
1、原理：synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性
2、Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
	1、普通同步方法，锁是当前实例对象
	2、静态同步方法，锁是当前类的class对象
	3、同步方法块，锁是括号里面的对象
3、同步代码块：monitorenter指令插入到同步代码块的开始位置，monitorexit指令插入到同步代码块的结束位置，JVM需要保证每一个monitorenter都有一个monitorexit与之相对应。
任何对象都有一个monitor与之相关联，当且一个monitor被持有之后，他将处于锁定状态。线程执行到monitorenter指令时，将会尝试获取对象所对应的monitor所有权，即尝试获取对象的锁；
4、同步方法：synchronized方法则会被翻译成普通的方法调用和返回指令如:invokevirtual、areturn指令，在VM字节码层面并没有任何特别的指令来实现被synchronized修饰的方法，而是在Class文件的方法表中将该方法的access_flags字段中的synchronized标志位置1，表示该方法是同步方法并使用调用该方法的对象或该方法所属的Class在JVM的内部对象表示Klass做为锁对象。 

5、Java对象头、monitor
	Java对象头
	synchronized用的锁是存在Java对象头里的，那么什么是Java对象头呢？
	Hotspot虚拟机的对象头主要包括两部分数据：
		Mark Word（标记字段）、
			Klass Point是是对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象是哪个类的实例，
			Mark Word用于存储对象自身的运行时数据，如哈希码（HashCode）、GC分代年龄、锁状态标志、线程持有的锁、偏向线程 ID、偏向时间戳等等。
			Java对象头一般占有两个机器码（在32位虚拟机中，1个机器码等于4字节，也就是32bit），但是如果对象是数组类型，则需要三个机器码，
			因为JVM虚拟机可以通过Java对象的元数据信息确定Java对象的大小，但是无法从数组的元数据来确认数组的大小，所以用一块来记录数组长度。
		Klass Pointer（类型指针）。
			Mark Word用于存储对象自身的运行时数据，它是实现轻量级锁和偏向锁的关键

   Monitor
	什么是Monitor？我们可以把它理解为一个同步工具，也可以描述为一种同步机制，它通常被描述为一个对象。
	Monitor 是线程私有的数据结构，每一个线程都有一个可用monitor record列表，同时还有一个全局的可用列表。每一个被锁住的对象都会和一个monitor关联（对象头的MarkWord中的LockWord指向monitor的起始地址），同时monitor中有一个Owner字段存放拥有该锁的线程的唯一标识，表示该锁被这个线程占用。
	
	Owner
		初始时为NULL表示当前没有任何线程拥有该monitor record，当线程成功拥有该锁后保存线程唯一标识，当锁被释放时又设置为NULL； 
	EntryQ
		关联一个系统互斥锁（semaphore），阻塞所有试图锁住monitor record失败的线程。 
	RcThis
		表示blocked或waiting在该monitor record上的所有线程的个数。
	Nest
		用来实现重入锁的计数。
	HashCode
		保存从对象头拷贝过来的HashCode值（可能还包含GC age）。 
	Candidate
		用来避免不必要的阻塞或等待线程唤醒，因为每一次只有一个线程能够成功拥有锁，如果每次前一个释放锁的线程唤醒所有正在阻塞或等待的线程，会引起不必要的上下文切换（从阻塞到就绪然后因为竞争锁失败又被阻塞）从而导致性能严重下降。Candidate只有两种可能的值0表示没有需要唤醒的线程1表示要唤醒一个继任线程来竞争锁。
	
	
锁优化

jdk1.6对锁的实现引入了大量的优化，如自旋锁、适应性自旋锁、锁消除、锁粗化、偏向锁、轻量级锁等技术来减少锁操作的开销。 
锁主要存在四中状态，依次是：
	无锁状态、
	偏向锁状态、
	轻量级锁状态、
	重量级锁状态，他们会随着竞争的激烈而逐渐升级。注意锁可以升级不可降级，这种策略是为了提高获得锁和释放锁的效率。	
	
	
	
【死磕Java并发】-----深入分析ThreadLocal

ThreadLocal是什么？
	该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。 ThreadLocal实例通常是类中的 private static 字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。
	
	所以ThreadLocal与线程同步机制不同，线程同步机制是多个线程共享同一个变量，而ThreadLocal是为每一个线程创建一个单独的变量副本，故而每个线程都可以独立地改变自己所拥有的变量副本，而不会影响其他线程所对应的副本。
	
	ThreadLocal定义了四个方法：
		1、get()：返回此线程局部变量的当前线程副本中的值。
		2、initialValue()：返回此线程局部变量的当前线程的“初始值”。
		3、remove()：移除此线程局部变量当前线程的值。
		4、set(T value)：将此线程局部变量的当前线程副本中的值设置为指定值。

对于ThreadLocal需要注意的有两点：

1、ThreadLocal实例本身是不存储值，它只是提供了一个在当前线程中找到副本值得key。
2、是ThreadLocal包含在Thread中，而不是Thread包含在ThreadLocal中，有些小伙伴会弄错他们的关系。

ThreadLocal源码解析

1、ThreadLocal虽然解决了这个多线程变量的复杂问题，但是它的源码实现却是比较简单的。
2、ThreadLocalMap是实现ThreadLocal的关键，我们先从它入手。	   


ThreadLocalMap

	ThreadLocalMap其内部利用Entry来实现key-value的存储，如下：

     static class Entry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;
            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
	
从上面代码中可以看出Entry的key就是ThreadLocal，而value就是值。同时，Entry也继承WeakReference，所以说Entry所对应key（ThreadLocal实例）的引用为一个弱引用	




1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
　　　　CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
　　　　而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
　　　　另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
　　2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。



35.CopyOnWriteArrayList可以用于什么应用场景
CopyOnWriteArrayList(免锁容器)的好处之一是当多个迭代器同时遍历和修改这个列表时，不会抛出ConcurrentModificationException。在CopyOnWriteArrayList中，写入将导致创建整个底层数组的副本，而源数组将保留在原地，使得复制的数组在被修改时，读取操作可以安全地执行。

1、由于写操作的时候，需要拷贝数组，会消耗内存，如果原数组的内容比较多的情况下，可能导致young gc或者full gc； 
2、不能用于实时读的场景，像拷贝数组、新增元素都需要时间，所以调用一个set操作后，读取到数据可能还是旧的,虽然CopyOnWriteArrayList 能做到最终一致性,但是还是没法满足实时性要求；

CopyOnWriteArrayList透露的思想 
1、读写分离，读和写分开 
2、最终一致性 
3、使用另外开辟空间的思路，来解决并发冲突

