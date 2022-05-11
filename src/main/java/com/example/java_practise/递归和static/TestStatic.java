package com.example.java_practise.递归和static;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 你不敢用static的原因：
 *
 * 1、递归，怕对同一个变量改乱了？【多余】
 *
 * java的static得益于其参数全部是传值，因此基本不会出现改乱的问题，大胆使用static就好了！！
 * 递归也没问题，java自身的栈处理的很好，根本不用你操心！
 *
 * 2、多次调用同一个static方法，会不会对同一个变量改乱了？【如果是顺序调用，只有static成员变量的初始化才会有这个问题】
 *
 * (1)问题：
 *      但是还有个问题啊，是关于变量初始化的问题。后面的调用是在前面的基础上的，
 *      会不会因为后面变量的初始化不同，导致后面调用结果出问题？
 * (2)test：
 *      设置一个初始化值，只有在第一次调用的时候才初始化，第二次调用就不初始化了
 *
 * (3)结论：只对static的成员变量有影响，如果不用修改static的成员变量，那就不用怕用static！
 *      static方法只对成员变量有影响，对局部变量和参数均无影响。
 *      如果是static的参数呢？java参数不允许是static的，所以都是值传递，绝对没影响
 *
 * 3、并发调用同一个static方法，会对同一个变量改乱吧？【这个也只针对static成员变量才有的问题！】
 *
 * 对，你真正需要关心的是多线程的问题。
 * 如果并发，多个线程同时调用一个static方法，他们共用同一个变量吗？那样的话，一定有问题啊！！！【static成员变量】
 *
 * 	遇到问题：
 * 	1、这里测试多线程时候，遇到Junit有时候无法启动多线程的问题。已解决《Junit多线程缺陷》
 * 	2、线程安全问题【待解决】
 */
public class TestStatic {

    public static void main(String[] args) {
        //怎么多线程有时候创建成功，有时候不成功？？？？什么情况？？？
        Thread t1 = new MyThread("th-1");
        t1.start();
        new Thread("th-2") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-200");
                TestStatic.f1(-200);
            }
        }.start();

        new Thread("th-3") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-300");
                TestStatic.f1(-300);
            }
        }.start();

        new Thread("th-4") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-400");
                TestStatic.f1(-400);
            }
        }.start();

        System.out.println(Thread.currentThread().getName() + ",初始化i为-2000");
        f1(-2000);
    }

    static int num;

    static {
        num = 10;
    }

    static void f1(int i) {
        if (i == 3) {
            return;
        }
        num++;
        System.out.println("f1函数内的线程名：" + Thread.currentThread().getName() + ",num:" + num + ",i=" + i);
        f1(++i);
    }

    /**
     * 一、并发（concurrency）和并行（parallelism）的区别：
     * 并发：多线程运行在同一个CPU内，CPU不停做上下文切换执行任务，单位时间内只有一个线程在运行；
     * 并行：多线程运行在多核心CPU内，同时执行任务；
     * 【我的理解：并行是特殊的并发】
     *
     *
     * 二、java多线程是并发还是并行？
     * （一）我的观点：并发
     *
     * 现在感觉，多线程和并发并行不是一个层级的东西。多线程更抽象，并发并行是具体实现。
     * JVM说，我就多线程了，具体是并发还是并行，全靠OS处理了。OS说，我就看CPU是几个，1个就无法并行，多个就可以并行。
     * 【有个问题：是JVM处理还是操作系统处理？感觉是操作系统。】
     *
     * 这样一想，其实java多线程，是一种更高层次上的并发，广义的并发。就是可以多个线程同时运行。
     * 【所以，我的结论，Java多线程是并发！！！！】
     *
     *
     * (二）其他人的观点：
     *
     * 1、不确定：多CPU就并行，单CPU无法并行只能并发。
     * https://www.zhihu.com/question/43591043/answer/471803524
     * 多线程，多进程是并行还是并发取决于你的CPU核心数量。
     * 如果是单核CPU，多线程也没用。如果是多核心CPU，那么就可以并行了。
     * CPU多一个核心，这个多出来的核心就可以多处理一个线程。
     * 2、并行：
     * https://blog.csdn.net/gxl1989225/article/details/84912017
     *
     *
     * 结论：只对共享的static成员变量有影响！
     */
    @Test
    public void test3__multi_thread() {
        // 1、问题
        // 怎么多线程有时候创建成功，有时候不成功？？？？什么情况？？？
        // 匿名非匿名都有无法创建的情况，匿名尤其严重，几乎无法创建，多个匿名创建个数随机，有时候也能全部创建。
        // main里的匿名类就没问题（偶尔不行），是Junit对多线程有什么限制吗，多线程模块做的不好？？？
        //
        // 2、原因
        // 【如果是单线程，当测试主线程执行结束后，子线程强制终止！】
        // 【还真有个规律，就是每次都以test的线程结束！！！】
        //
        // 哇偶，真的发现了原因，神奇!
        //    不管子线程是否结束，都会回调TestResult的wasSuccessful方法，然后判断结果是成功还是失败，
        //    最后调用相应的System.exit()方法。大家都知道这个方法是用来结束当前正在运行中的java虚拟机，jvm都自身难保了，所以子线程也就对不住你咧...
        //    参考：https://www.cnblogs.com/yanphet/p/5774291.html
        //
        // 3、解决办法：
        // (1)简单粗暴地让主线程休眠一段时间，然后让子线程能够运行结束。但是这个方法的弊端是，你不知道子线程的运行时间，所以需要看脸＝_＝
        // 　　Thread.sleep();
        //
        // (2)使用CountDownLatch工具类，让主线程阻塞，直到子线程运行结束或者阻塞超时，这个方法要比第一个方法好点。
        // 　　countDownLatch.await(5, TimeUnit.MINUTES);
        //
        // (3)至于还有其他方法，笔者看到很多大神自己写的Junit支持多线程，有兴趣的读者自行度娘...
        //
        Thread.currentThread().setName("test-33333333333");

        Thread t1 = new MyThread("th-1");
        t1.start();

        new Thread("th-2") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-200");
                TestStatic.f1(-200);
            }
        }.start();

        new Thread("th-3") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-300");
                TestStatic.f1(-300);
            }
        }.start();

        new Thread("th-4") {
            @Override
            public void run() {
                System.out.println("创立多线程啦啦啦啦啦啦");
                System.out.println(Thread.currentThread().getName() + ",初始化i为-400");
                TestStatic.f1(-400);
            }
        }.start();

        System.out.println(Thread.currentThread().getName() + ",初始化i为-10");
        f1(-10);
    }

    /**
     * 结论：只对static的成员变量有影响，如果不用修改static的成员变量，那就不用怕用static！
     */
    @Test
    public void test2_seq_init() {
        System.out.println(num);
        int i = 1;
        f1(i);
        System.out.println("========第一次f1后，i=" + i + "，num=" + num + "=========");
        f1(i);
        System.out.println("========第2次f1后，i=" + i + "，num=" + num + "=========");

    }

    @Test
    public void test1_reverse() {
        // System.out.println(getSum(10));
        System.out.println(printList(10));
    }

    //递归实现1加到10
    public static int getSum(int i) {
        if (i == 1) {
            return 1;
        }
        return i + getSum(--i);
    }

    //递归实现输出一个1-10的List
    public static List<Integer> printList(int i) {
        if (i == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            return list;
        }
        List<Integer> list = printList(i - 1);
        list.add(i);
        return list;
    }
}

class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("创立多线程啦啦啦啦啦啦");
        System.out.println(Thread.currentThread().getName() + ",初始化i为-1000");
        TestStatic.f1(-1000);
    }
}