package com.tuling.designpattern.study;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Decorator.java
 * @Description TODO 装饰模式
 * 使用场景： 在拍照前后，添加美颜、精修
 * @createTime 2023年02月17日 15:45:00
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        // 谁先被new 出来谁先
        Component concreteDecorator2 = new ConcreteDecorator(new ConcreteDecorator2(new Camera()));
        concreteDecorator2.photograph();
    }
}

/**
 * 业务代码，不变的部分
 */
// 部件：声明封装器和被封装对象的公用接口
interface Component {
    void photograph(); // 拍照方法
}

// 具体部件：定义了基础行为
class Camera implements Component {

    @Override
    public void photograph() {
        System.out.println("拍照.");
    }
}

/**
 * 装饰模式，添加代码，改变的部分
 */

// 基础装饰类
class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void photograph() {
        component.photograph();
    }
}

// 具体装饰类：定义了可动态添加到部件的额外行为。
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void photograph() {
        System.out.println("添加美颜.");
        // 调用基础方法
        super.photograph();
    }
}

class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void photograph() {
        super.photograph();
        System.out.println("精修.");
    }
}

