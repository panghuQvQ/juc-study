package com.tuling.designpattern.study.templatemethod;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TemplateMethodTest.java
 * @Description TODO 模板方法模式
 * @createTime 2023年02月20日 13:48:00
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        AbstractClass subClass = new SubClass();
        subClass.operation();
    }
}

abstract class AbstractClass {

    public void operation() {
        // ...
        System.out.println(" pre........ ");
        System.out.println(" step1 ");
        System.out.println(" step2 ");
        templateMethod(); // 模板方法
        // ...
    }

    abstract void templateMethod();
}

// 模板方法实现
class SubClass extends AbstractClass{

    @Override
    void templateMethod() {
        System.out.println(" subClass.... ");
    }
}


