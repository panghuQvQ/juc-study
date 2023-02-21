package com.tuling.juc.thread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CallableDemo.java
 * @Description TODO
 * @createTime 2022年11月15日 15:03:00
 */
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
