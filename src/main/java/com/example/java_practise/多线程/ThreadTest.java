package com.example.java_practise.多线程;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();//会自动执行run()方法，不用专门去调用run()。
        t2.start();
        for (int i = 0; i < 80; i++) {
            System.out.println(i + "================main");
        }
        t1.run();//这个并没有启动新线程，还是main的线程执行的run()。
        //顺序：main调用的run()虽然在后面，竟然比新线程早输出？【那是因为造新线程要慢很多，如果有别的干扰，二者可能顺序会换掉！交替执行。】
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这是线程1,遍历0-99");
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "______" + Thread.currentThread().getName());

        }
    }
}