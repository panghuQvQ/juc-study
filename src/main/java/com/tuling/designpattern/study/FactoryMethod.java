package com.tuling.designpattern.study;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FactoryMethod.java
 * @Description TODO 工厂方法模式
 * @createTime 2023年02月14日 10:43:00
 */
public class FactoryMethod {
    public static void main(String[] args) {
        String s = "road";
        LogisticsFactory logistics;
        if( s.equals("road")){ // 根据条件选择交通方式，创建对象即可
            logistics = new RoadLogistics();
        }else {
            logistics = new SeaLogistics();
        }

        Transport transport = logistics.chooseTransport();
        transport.deliver();
    }
}

// =========创建接口与对象的实现====================================================
// 运输方式接口，封装了运送方法
interface Transport{
    public void deliver();
}

// 卡车
class Truck implements Transport{
    public void deliver(){
        System.out.println("货物在盒子中，以陆路方式运输 ");
    }
}

// 轮船
class Ship implements Transport{
    public void deliver(){
        System.out.println("货物在集装箱中，以海陆的方式运输");
    }
}

// =======工厂方法，通过抽象类的方式=============================================

// 物流工厂
abstract class LogisticsFactory{
    abstract Transport chooseTransport();
}

// 道路物流
class RoadLogistics extends LogisticsFactory{

    @Override
    Transport chooseTransport() {
        // ....
        return new Truck();
    }
}

// 海陆物流
class SeaLogistics extends LogisticsFactory{

    @Override
    Transport chooseTransport() {
        // ....
        return new Ship();
    }
}
