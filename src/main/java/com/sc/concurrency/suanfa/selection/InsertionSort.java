package com.sc.concurrency.suanfa.selection;

/**
 * @author: shichao
 * @date: 2019/7/14
 * @description: 插入排序 (优点：可以提交停止内层循环)
 * <p>
 * 所以在数据近乎有序的情况下排序效率非常高，有可能比哪些0 nlogN的算法效率更高
 */
public class InsertionSort {


    /**
     * 直接使用遍历交换的方式
     *
     * @param arr
     * @param n
     * @return
     */
    private static int[] sort(int[] arr, int n) {
        if (null == arr || arr.length <= 2) {
            return arr;
        }
        if (n >= arr.length) {
            n = arr.length;
        }

        for (int i = 0; i < n; i++) {
            //寻找arr[i] 合适的插入位置 j

            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    //交换比较耗时间
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 用赋值取代交换的优化后的插入排序
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
            //寻找arr[i] 合适的插入位置 j
            int current = arr[i];
            int j;//保存了current应该存放迭代索引
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > current) {
                    //交换比较耗时间
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = current;
        }
        return arr;
    }

    /**
     * 插入排序，复习
     *
     * @param arr
     * @return
     */
    private static int[] sortReplay(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        //默认以第一个为已排序好的数组，向后取元素往前面排好序的数组插入
        for (int i = 0; i < arr.length; i++) {
            //本轮向前插入的当前值
            int currentValue = arr[i];
            //获取的插入位置
            int j;
            //逆向比较
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > currentValue) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            //指定位置赋值
            arr[j] = currentValue;
        }
        return arr;
    }

    /**
     * 插入排序，复习
     *
     * @param arr
     * @return
     */
    private static int[] sortReplay1(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        //默认以第一个为已排序好的数组，向后取元素往前面排好序的数组插入
        for (int i = 0; i < arr.length; i++) {
            //获取的插入位置
            int j;
            //逆向比较
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = Util.getRondomArray(30, 1, 1000);
        Util.print(arr);
        Util.print(sortReplay1(arr));
    }
}
