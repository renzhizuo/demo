package com.renzhi.demo.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description : 类描述
 * Created on : 2021-06-26
 * author : renzhi.zuo
 * @see https://www.bilibili.com/video/BV1Hy4y1B78T?p=16
 * @see https://blog.csdn.net/TZ845195485/article/details/109210095
 */

public class LockCodeDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("--");
        } finally {
            lock.unlock();
        }
    }

}
