package com.sc.concurrency.juc;

import com.sc.concurrency.annotation.NotRecommend;
import com.sc.concurrency.annotation.ThreadUnsafe;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description: 对象溢出的示例
 */
@ThreadUnsafe
@NotRecommend
public class EsCape {
    private int num = 0;

    public EsCape() {
        System.out.println("do MainClass init ");
        new InnerClass();
    }

    /**
     * 以上这种类的发布方式会使得内部类在主类没有初始化完成的情况下就拿到主类的引用，从而会出现对象逸出的现象，是线程不安全的。
     * 产生的现象就是：任何线程能看到被发布对象的过期值，其次线程拿到的引用是最新的但状态却是旧的，这样对一个可变对象来说就会有问题。
     */
    private class InnerClass{
        public InnerClass() {
            System.out.println("do InnerClass init..."+EsCape.this.num);
        }
    }

    public static void main(String[] args) {
        EsCape esCape  =new EsCape();
    }
}
