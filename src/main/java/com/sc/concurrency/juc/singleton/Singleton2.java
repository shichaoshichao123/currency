package com.sc.concurrency.juc.singleton;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:饿汉单例模式2
 */
public class Singleton2 {

    private static Singleton2 Instance = null;

    static {
        Instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getSingletion() {
        return Instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton2.getSingletion().hashCode())).start();
        }
    }
}
