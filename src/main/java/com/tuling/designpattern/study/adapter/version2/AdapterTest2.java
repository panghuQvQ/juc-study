package com.tuling.designpattern.study.adapter.version2;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdapterTest.java
 * @Description TODO 适配器模式，类适配器
 * 定义：使用了继承机制： 适配器同时继承两个对象的接口。 请注意， 这种方式仅能在支持多重继承的编程语言中实现， 例如 C++。
 * @createTime 2023年02月17日 13:41:00
 */
public class AdapterTest2 {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5V();
    }
}

// 服务对象：模拟家用电压，220V
class Adaptee {
    public int output220V() {
        return 220;
    }
}

interface Phone {
    int output5V();
}

class Adapter extends Adaptee implements Phone{
    @Override
    public int output5V() {
        int i = output220V(); // 获取220v电压
        // ...转换过程略......
        System.out.println(String.format("原始电压： %d  -> 输出电压： %d", i, 5));
        return 5;
    }
}

