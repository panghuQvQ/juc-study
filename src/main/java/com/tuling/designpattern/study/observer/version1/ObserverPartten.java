package com.tuling.designpattern.study.observer.version1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ObserverPartten.java
 * @Description TODO 观察者模式
 * 可以设置多个观察者对象，观察主题对象，当主题对象发生变化时，观察者对象也会做出相应的改变
 * @createTime 2023年02月20日 14:45:00
 */
public class ObserverPartten {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);

        subject.notifyObserver("观察A数据成功");
        System.out.println("---------------------------------");
        subject.remove(task1);
        subject.notifyObserver("观察B数据成功");

    }
}

// 发布者：主题对象
class Subject {

    private List<Observer> containers = new ArrayList<>();

    // 添加观察者
    public void addObserver(Observer observer) {
        containers.add(observer);
    }

    // 移除观察者
    public void remove(Observer observer) {
        containers.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer container : containers) {
            container.update(object);
        }
    }

}

// 订阅者
interface Observer {
    void update(Object object);
}

// 具体订阅者：观察者1
class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("Task1 received:" + object);
    }
}

// 具体订阅者：观察者2
class Task2 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("Task2 received:" + object);
    }
}

