package com.sc.concurrency.suanfa.selection;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.springframework.cache.annotation.CachePut;

/**
 * @author: shichao
 * @date: 2019/7/14
 * @description: 归并排序（
 */
public class MergeSort {

    /**
     * 自顶向下（递归的实现方式）
     *
     * @param arr
     * @param n
     * @return
     */
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
     * 自底向上（循环的实现方式）
     *
     * @param arr
     * @param n
     * @return
     */
    private static int[] sort1(int[] arr, Integer n) {
        //TODO
        return arr;
    }

    /**
     * 进行递归的最小单元
     *
     * @param arr 要归并的子数组
     * @param l   左边最小索引
     * @param r   右边最大索引
     */
    private static void cellSort(int[] arr, int l, int r) {
        if (l >= r) {
            //代表已经递归到最小单元了
            return;
        }

        int mid = (r + l) / 2;
        cellSort(arr, l, mid);
        cellSort(arr, mid + 1, r);
        doMerge(arr, l, mid, r);

    }

    /**
     * 进行merge操作，归并操作方法
     */
    private static void doMerge(int[] arr, int l, int mid, int r) {

        int[] tmp = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            //初始化零时数组
            tmp[i - l] = arr[i];
        }
        //进行归并
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l] < tmp[j - l]) {
                arr[k] = tmp[i - l];
                i++;
            } else {
                arr[k] = tmp[j - l];
                j++;
            }
        }
    }

    /**
     * 通过复制一份零时copy进行数据合并
     * 注意偏移量left
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void mergeData(int[] arr, int left, int mid, int right) {
        int[] copy = new int[right - left + 1];
        //初始化零时copy
        for (int i = left; i <= right; i++) {
            copy[i - left] = arr[i];
        }
        int k, i = left, j = mid + 1;
        for (k = left; k <= right; k++) {
            //如果左边部分不存在,只进行右边的迭代
            if (i > mid) {
                arr[k] = copy[j - left];
                j++;
            } else if (right < j) {
                arr[k] = copy[i - left];
                i++;
            } else if (copy[i - left] < copy[j - left]) {
                arr[k] = copy[i - left];
                i++;
            } else {
                arr[k] = copy[j - left];
                j++;
            }

        }


    }

    /**
     * 归并排序-复习
     *
     * @param arr
     * @return
     */
    private static int[] sortReplay(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return arr;
        }
        cell_sort(arr, 0, arr.length-1);
        return arr;
    }

    /**
     * 用于归并分解的递归单元
     * 在排序过程中在内存里面对同一个数组进行分解归并
     *
     * @param arr   操作的数组
     * @param left  要操作的最小索引
     * @param right 要操作的最大索引
     * @return
     */
    private static void cell_sort(int[] arr, int left, int right) {
        //递归出口
        if (left >= right) {
            return;
        }
        //获取索引的点进行递归分解
        int mid = (right + left) / 2;
        cell_sort(arr, left, mid);
        cell_sort(arr, mid + 1, right);
        //合并操作
        mergeData(arr, left, mid, right);
    }


    public static void main(String[] args) {
        int[] arr = Util.getRondomArray(30, 1, 1000);
        Util.print(arr);
        Util.print(sortReplay(arr));
    }
}
