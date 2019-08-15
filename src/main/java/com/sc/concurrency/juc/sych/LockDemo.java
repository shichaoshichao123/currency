package com.sc.concurrency.juc.sych;

/**
 * @author: shichao
 * @date: 2019/7/11
 * @description:
 */
public class LockDemo {

    private static Object Lock = new Object();
    private static Object Lock1 = new Object();

    private void testLock(){
        synchronized (Lock){
            System.out.println(Thread.currentThread().getName()+"进入代码库执行.....");
            try {
                Thread.sleep(10000);
                subWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕.....");

        }
    }

    private void subWork(){
        synchronized (Lock1){
            System.out.println(Thread.currentThread().getName()+"进入subWork代码库执行.....");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        new Thread(()->lockDemo.testLock(),"A").start();
        new Thread(()->lockDemo.testLock(),"B").start();
        Thread.sleep(1000);
        new Thread(()->lockDemo.subWork(),"c").start();
    }
}
