package com.soapsnake.concurrence.runnable.volatiletest;


public class VolatileTest {

    private static final int THREADS_COUNT = 20;      //线程数量=20
    public static volatile int race = 0;  //共享变量race

    //public synchronized static void increace(){   //加synchronized关键字后输出正常
    public static void increace() {

        race++;     //race自加1,注意此操作并非原子操作
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];      //线程数组,20条线程

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {     //创建20个任务分别交给20条线程
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {    //每条线程内,执行1000此increase方法
                        increace();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("end: " + race);
    }
}
