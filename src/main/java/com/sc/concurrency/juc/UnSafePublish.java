package com.sc.concurrency.juc;

import com.sc.concurrency.annotation.ThreadUnsafe;

import java.util.Arrays;

/**
 * @author: shichao
 * @date: 2019/6/29
 * @description: 类的不安全发布
 */
@ThreadUnsafe
public class UnSafePublish {

    private String[] resource = {"a", "b", "c"};

    public String[] getResource() {
        return resource;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        String[] resource =  unSafePublish.getResource();
        System.out.println(Arrays.asList(resource).toString());

        resource[0] = "d";

        System.out.println(Arrays.asList(unSafePublish.getResource()).toString());
    }
}
