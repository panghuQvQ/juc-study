package com.tuling.designpattern.study.adapter.version1;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName adapter.java
 * @Description TODO 适配器模式，对象适配器
 * 定义：实现时使用了构成原则： 适配器实现了其中一个对象的接口， 并对另一个对象进行封装。 所有流行的编程语言都可以实现适配器。
 * 问题：模拟家用电压 220V  ,手机充电需要5V  ，此时就需要一个充电器来转换适配
 * @createTime 2023年02月17日 11:23:00
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        int i = adapter.output5V();

    }
}

// 服务对象：模拟家用电压，220V
class Adaptee {
    public int output220V() {
        return 220;
    }
}

// 模拟手机需要5V电压
interface Phone {
    int output5V();
}

// 适配器：实现客户端接口的同时封装了服务对象
class Adapter implements Phone {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5V() {
        int i = adaptee.output220V(); // 获取220v电压
        // ....转换过程略........
        System.out.println(String.format("原始电压： %d  -> 输出电压： %d", i, 5));
        return 5;
    }
}
