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





	   
	
	