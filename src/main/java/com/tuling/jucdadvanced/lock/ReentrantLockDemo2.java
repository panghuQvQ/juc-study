package com.tuling.jucdadvanced.lock;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Fox
 * 可重入
 * 可重入锁，也叫做递归锁，是指在一个线程中可以多次获取同一把锁，
 * 比如：一个线程在执行一个带锁的方法，该方法中又调用了另一个需要相同锁的方法，则该线程可以直接执行调用的方法【即可重入】，而无需重新获得锁；
 */
@Slf4j
public class ReentrantLockDemo2 {

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        method1();
    }


    public static void method1() {
        lock.lock();
        try {
            log.debug("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }
    public static void method2() {
        lock.lock();
        try {
            log.debug("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }
    public static void method3() {
        lock.lock();
        try {
            log.debug("execute method3");
        } finally {
            lock.unlock();
        }
    }
}
