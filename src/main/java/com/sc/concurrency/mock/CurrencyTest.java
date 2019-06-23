package com.sc.concurrency.mock;

import com.sc.concurrency.annotation.ThreadUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: shichao
 * @date: 2019/6/23
 * @description:
 */
@ThreadUnsafe
public class CurrencyTest {

    private static int USERS = 10000;

    private static int THREAD_NUM = 50;

    private static int num = 0;

    private static void deTest() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_NUM);
        final CountDownLatch countDownLatch = new CountDownLatch(USERS);
        for (int i = 0; i < USERS; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    addNum();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println(num);
    }

    private static void addNum() {
        num++;
    }

    public static void main(String[] args) {

        try {
            deTest();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
