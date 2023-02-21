package com.tuling.designpattern.study;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FacadeTest.java
 * @Description TODO 门面模式
 * 在所有业务之前添加一个门面，有这个门面进行转发路由
 * @createTime 2023年02月20日 09:43:00
 */
public class FacadePattern {

    public static void main(String[] args) {

    }
}


class Client1 {

    Facade facade = new Facade();
    public void doSomething2() {
        facade.doSomeThingFacade();
    }
}

class Client2 {

    Facade facade = new Facade();
    public void doSomething2() {
        facade.doSomeThingFacade();
    }
}

// 门面类
class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomeThingFacade() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }

}


class SubSystem1 {
    public void method1() {
        System.out.println("SubSystem1.method1 executed. ");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("SubSystem2.method2 executed. ");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("SubSystem3.method3 executed. ");
    }
}
