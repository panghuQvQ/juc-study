package com.tuling.juc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestAllDemo.java
 * @Description TODO
 * @createTime 2022年11月15日 15:06:00
 */
public class TestAllDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new ThreadDemo().start();

        new Thread(new RunnableDemo()).start();

        ExecutorService service = Executors.newFixedThreadPool(10);
        Integer integer = service.submit(new CallableDemo()).get();

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

        System.out.println("mian");
    }
}
