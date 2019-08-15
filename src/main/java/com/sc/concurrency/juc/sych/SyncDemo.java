package com.sc.concurrency.juc.sych;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:
 */
public class SyncDemo {


    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + "comming.....test1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + "comming.....test2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test3() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "comming.....test3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void test4() {
        System.out.println(Thread.currentThread().getName() + "comming.....test4");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void test5() {
        synchronized (SyncDemo.class) {
            System.out.println(Thread.currentThread().getName() + "comming.....test5");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();

        new Thread(() -> syncDemo.test1(), "A").start();
        new Thread(() -> syncDemo.test3(), "B").start();
        new Thread(() -> syncDemo.test4(), "C").start();
        new Thread(() -> syncDemo.test5(), "D").start();
        new Thread(() -> syncDemo.test5(), "E").start();
    }
}
