package com.sc.concurrency.juc.singleton;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description: 双重检测加同步锁的懒汉模式
 */
public class Singleton3 {
    private volatile static Singleton3 Instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() throws InterruptedException {
        if (null == Instance) {
            synchronized (Singleton3.class) {
                if (null == Instance) {
                    Thread.sleep(1);
                    Instance = new Singleton3();
                }

            }

        }
        return Instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Singleton3.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
