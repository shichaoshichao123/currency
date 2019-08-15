package com.sc.concurrency.juc.singleton;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description: 枚举的方式实现线程安全的单例
 */
public class Singleton4 {


    private Singleton4() {
    }

    public static Singleton4 getInstance() {
       return InnerEnum.INSTANCE.getInstance();
    }

    private enum InnerEnum

    {

        /**
         * 示例枚举
         */
        INSTANCE;
        private Singleton4 Instance;

        /**
         * JVM内部保证枚举的构造方法只会执行一次
         * @return
         */
        InnerEnum() {
            Instance = new Singleton4();

        }

        public Singleton4 getInstance() {
            return Instance;
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton4.getInstance().hashCode())).start();
        }
    }
}
