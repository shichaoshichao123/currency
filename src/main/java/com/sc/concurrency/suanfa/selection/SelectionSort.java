package com.sc.concurrency.suanfa.selection;

/**
 * @author: shichao
 * @date: 2019/7/14
 * @description: 选择排序
 */
public class SelectionSort {


    /**
     * 排序指定位数的选择排序算法
     *
     * @param arr
     * @param n
     * @return
     */
    private static int[] sort1(int[] arr, int n) {

        if (null == arr || arr.length <= 2) {
            return arr;
        }
        if (n >= arr.length) {
            n = arr.length;
        }

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            //寻找i-arr.length 区间的最小数
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //进行交换
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;

    }

    /**
     * 复习
     *
     * @return
     */
    private static int[] sortReplay(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int currentIndex = i;
            //遍历i+1 到arr.length获取最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[currentIndex] > arr[j]) {
                    //交换最小索引
                    currentIndex = j;
                }
            }
            //交换值
            int temp = arr[i];
            arr[i] = arr[currentIndex];
            arr[currentIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = Util.getRondomArray(30, 1, 1000);
        Util.print(arr);
        Util.print(sortReplay(arr));
    }
}
