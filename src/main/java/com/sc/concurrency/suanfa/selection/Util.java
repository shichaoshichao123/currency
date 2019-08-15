package com.sc.concurrency.suanfa.selection;

import java.util.Random;

/**
 * @author: shichao
 * @date: 2019/7/14
 * @description:
 */
public class Util {

    /**
     * 根据指定参数生产随机数组
     *
     * @param num
     * @param min
     * @param max
     * @return
     */
    static int[] getRondomArray(int num, int min, int max) {
        Random random = new Random();
        if (num <= 0 || max < min) {
            throw new RuntimeException("参数异常");
        }

        int[] result = new int[num];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(max - min) + min;
        }
        return result;
    }

    /**
     * 打印
     *
     * @param array
     */
    static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
