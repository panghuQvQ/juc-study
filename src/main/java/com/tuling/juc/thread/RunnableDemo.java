package com.tuling.juc.thread;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RunnableDemo.java
 * @Description TODO
 * @createTime 2022年11月15日 15:01:00
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
