package com.tuling.jucdadvanced.threadbase;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2022年11月23日 09:33:00
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"==="+ random.nextInt());
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
