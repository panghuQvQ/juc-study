package com.tuling.designpattern.study.strategy.errorversion1;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StrategyPattern.java
 * @Description TODO 按照此方式进行拓展的话，每有一个新僵尸出现，将继承之前的僵尸类，代码会越来越复杂，不推荐此方法。
 * @createTime 2023年02月20日 10:33:00
 */
public class StrategyPattern {

    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        FlagZombie flagZombie = new FlagZombie();
        normalZombie.display();
        normalZombie.attack();
        normalZombie.move();

        System.out.println("----------------------------");
        flagZombie.display();
        flagZombie.attack();
        flagZombie.move();
    }
}

// 抽象僵尸类
abstract class AbstractZombie {

    public abstract void display();

    public void attack() {
        System.out.println("咬.");
    }

    public void move() {
        System.out.println("一步一步移动.");
    }
}

class NormalZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是普通僵尸.");
    }
}

class FlagZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是旗手僵尸.");
    }
}
