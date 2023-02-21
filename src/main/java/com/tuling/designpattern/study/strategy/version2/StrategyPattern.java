package com.tuling.designpattern.study.strategy.version2;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StrategyPattern.java
 * @Description TODO 策略模式
 *  策略模式建议找出负责用许多不同方式完成特定任务的类， 然后将其中的算法抽取到一组被称为策略的独立类中。
 *
 *  名为上下文的原始类必须包含一个成员变量来存储对于每种策略的引用。 上下文并不执行任务， 而是将工作委派给已连接的策略对象。
 * @createTime 2023年02月20日 10:47:00
 */
public class StrategyPattern {

    public static void main(String[] args) {
        AbstractZombie zombie = new NormalZombie(); // 普通僵尸
        zombie.display();
//        zombie.attack();
        zombie.move();

        zombie.setAttackable(new HitAttack()); // 修改攻击策略，打
        zombie.attack();
        System.out.println("--------------------------------------");
        FlagZombie flagZombie = new FlagZombie(new JumpMove(), new BiteAttack()); // 旗子僵尸，提供跳跃和咬策略
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();

    }
}

// 移动策略接口
interface Moveable {
    void move();
}

// 攻击策略接口
interface Attackable {
    void attack();
}

// 移动策略具体实现：一步一步移动
class StepByStepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("一步一步移动.");
    }
}

// 移动策略具体实现：跳跃
class JumpMove implements Moveable {

    @Override
    public void move() {
        System.out.println("跳跃.");
    }
}

// 攻击策略具体实现：咬攻击
class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("咬.");
    }
}

// 攻击策略具体实现：打攻击
class HitAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("打.");
    }
}

// 上下文
@Data  // 抽象僵尸
abstract class AbstractZombie {


    abstract public void display(); // 显示样貌

    abstract void move(); // 移动方式

    abstract void attack(); // 攻击方式

    Moveable moveable; // 移动策略
    Attackable attackable; // 攻击策略


    public AbstractZombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }
}

class NormalZombie extends AbstractZombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

class FlagZombie extends AbstractZombie {

    public FlagZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}
