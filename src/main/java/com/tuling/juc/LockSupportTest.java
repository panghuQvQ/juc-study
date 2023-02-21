package com.tuling.juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread1());
        parkThread.start();

        Thread parkThread2 = new Thread(new ParkThread2());
        parkThread2.start();

        System.out.println("唤醒parkThread");
        LockSupport.unpark(parkThread2);
    }

    static class ParkThread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("ParkThread1开始执行");
            LockSupport.park();
            System.out.println("ParkThread1执行完成");
        }
    }

    static class ParkThread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("ParkThread2开始执行");
            LockSupport.park();
            System.out.println("ParkThread2执行完成");
        }
    }
}
