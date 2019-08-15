package com.sc.concurrency.mock;

import java.lang.management.*;

/**
 * @author: shichao
 * @date: 2019/7/1
 * @description:
 */
public class Demo {


    public static void main(String[] args) {
        /**
         * 堆内存
         */
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("jvm.heap.init is " + (heapMemoryUsage.getInit()));
        System.out.println("jvm.heap.used is " + (heapMemoryUsage.getUsed()));
        System.out.println("jvm.heap.committed is " + (heapMemoryUsage.getCommitted()));
        System.out.println("jvm.heap.max is " + (heapMemoryUsage.getMax()));

        /**
         * 非堆内存
         */
        MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        System.out.println("jvm.nonheap.init is " + (nonHeapMemoryUsage.getInit()));
        System.out.println("jvm.nonheap.used is " + (nonHeapMemoryUsage.getUsed()));
        System.out.println("jvm.nonheap.committed is " + (nonHeapMemoryUsage.getCommitted()));
        System.out.println("jvm.nonheap.max is " + (nonHeapMemoryUsage.getMax()));

        /**
         * 不同区的内存
         */
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            final String kind = pool.getType() == MemoryType.HEAP ? "heap" : "nonheap";
            final MemoryUsage usage = pool.getUsage();
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".init is " + usage.getInit());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".used is " + usage.getUsed());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName()+ ".committed is " + usage.getCommitted());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".max is " + usage.getMax());
        }
    }
}
