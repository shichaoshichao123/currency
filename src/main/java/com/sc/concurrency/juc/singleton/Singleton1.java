package com.sc.concurrency.juc.singleton;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description: 饿汉单例模式1
 */
public class Singleton1 {

    private static Singleton1 Instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getSingletion() {

        return Instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton1.getSingletion().hashCode());
            }).start();
        }
    }
}
