package com.sc.concurrency.threadLocal;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description:
 */
public class RequestHolder {
    /**
     * 声明ThreadLocal
     * 用于保持相关信息 按线程区分
     */
    private final static ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 以当前线程为Key设置指定内容
     *
     * @param id
     */
    public static void add(Long id) {

        THREAD_LOCAL.set(id);

    }

    /**
     * 以当前线程为key获取值
     *
     * @return
     */
    public static Long get() {
        return THREAD_LOCAL.get();
    }

    /**
     * 以当前线程为key移除内容
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
