package com.tuling.juc.thread;

public class WaitDemo {
    private static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("2wait start .......");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("2wait end ....... ");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("1wait start .......");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("1wait end ....... ");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    synchronized (lock) {
                        if (flag) {
//                            lock.notify();
                            lock.notifyAll();
                            System.out.println("notify .......");
                            flag = false;
                        }

                    }
                }
            }
        }).start();
    }
}
