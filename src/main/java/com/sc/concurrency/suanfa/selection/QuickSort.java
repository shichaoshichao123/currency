package com.sc.concurrency.suanfa.selection;

/**
 * @author: shichao
 * @date: 2019/7/14
 * @description: 快速排序
 */
public class QuickSort {

    private static int[] sort(int[] arr, Integer n) {
        if (null == arr || arr.length <= 2) {
            return arr;
        }
        if (null == n || n >= arr.length) {
            n = arr.length;

        }
        cellSort(arr, 0, n - 1);
        return arr;
    }

    /**
     * 该函数的作用是返回一个索引P，
     * 要求该处理的子数组中索引l-p 的值都小于p指向的值
     * p+1-r的值都大于p指向的值
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
        //取数组第一个元素为标准值，也就是p指向的值
        int v = arr[l];
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                //交换
                int tmp = arr[i];
                arr[i] = arr[p + 1];
                arr[p + 1] = tmp;
                p++;
            }
        }
        //最后交换标准值的位置
        int tmp = arr[p];
        arr[p] = v;
        arr[l] = tmp;
        return p;
    }
    /**
     * 以最左编的元素作为基准值进行递归快排
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int getPartition(int[] arr, int left, int right) {
        //以最左侧作为基准
        int v = arr[left];
        int p = left;
        for (int i = left + 1; i <= right; i++) {
            if (v > arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[p + 1];
                arr[p + 1] = tmp;
                p++;
            }

        }
        int tmp = arr[p];
        arr[p] = v;
        arr[left] = tmp;
        return p;
    }

    /**
     * 快速排序 递归单元
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void cellSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        //注意调用递归的时候要把p的位置留下来
        cellSort(arr, l, p - 1);
        cellSort(arr, p + 1, r);
    }


    /**
     * @param arr
     * @return
     */
    private static int[] sortReplay(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        cell_sort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 快排递归单元
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void cell_sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = getPartition(arr, left, right);
        cell_sort(arr,left,p-1);
        cell_sort(arr,p+1,right);
    }



    public static void main(String[] args) {
        int[] arr = Util.getRondomArray(30, 1, 1000);
        Util.print(arr);
        Util.print(sortReplay(arr));
    }
}
