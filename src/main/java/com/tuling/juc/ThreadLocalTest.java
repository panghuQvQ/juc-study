package com.tuling.juc;

public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中变量的值
        System.out.println(str + " :" + local.get());
        //清除内存中的本地变量
        local.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalTest.local.set("xdclass_A");
                print("A");
                //打印本地变量
                System.out.println("清除后：" + local.get());
            }
        },"A").start();
        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalTest.local.set("xdclass_B");
                print("B");
                System.out.println("清除后 " + local.get());
            }
        },"B").start();
    }
}
