package com.lucky.springbootkafka.lock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: H
 * @description:
 * @program: springboot-kafka
 * @create: 2019-12-18 17:01
 **/
public class LockTest implements Runnable {
    Lock lock =new ReentrantLock();

    private static int i=0;

    @Override
    public void run() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    for (int i1 = 0; i1 < 10; i1++) {
                        System.out.println(Thread.currentThread().getName() + "打印了：" + i1);
                        i++;
                    }
                    Thread.sleep(1000);
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println(Thread.currentThread().getName()+"没有抢到锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
        new Thread(lockTest).start();
    }
}
