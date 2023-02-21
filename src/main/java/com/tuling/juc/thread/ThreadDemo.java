package com.tuling.juc.thread;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ThreadDemo.java
 * @Description TODO
 * @createTime 2022年11月15日 14:41:00
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread");
    }
}
