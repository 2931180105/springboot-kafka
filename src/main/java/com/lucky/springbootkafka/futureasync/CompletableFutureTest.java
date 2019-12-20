package com.lucky.springbootkafka.futureasync;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: H
 * @description:
 * @program: springboot-kafka
 * @create: 2019-12-20 11:45
 **/
public class CompletableFutureTest {

    private static final AtomicInteger ATOMIC_INTEGER=new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = createThread();

        CompletableFuture<String> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName() + "hahah");
                    return "haha";}
                ,executorService).thenApply(
                (a)->{
                    System.out.println("thenApply执行了;"+a);
                    return "wget";
                }
        );
        System.out.println(voidCompletableFuture.get());
        System.out.println("结束");
        executorService.shutdown();
    }

    private static ExecutorService createThread() {
        return Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                //创建线程
                Thread thread=new Thread(r);
                thread.setName("lucky"+ATOMIC_INTEGER.incrementAndGet());
                return thread;
            }
        });
    }

}