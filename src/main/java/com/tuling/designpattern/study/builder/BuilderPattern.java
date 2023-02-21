package com.tuling.designpattern.study.builder;

import com.tuling.designpattern.study.builder.builders.CarBuilder;
import com.tuling.designpattern.study.builder.builders.CarManualBuilder;
import com.tuling.designpattern.study.builder.cars.Car;
import com.tuling.designpattern.study.builder.cars.Manual;
import com.tuling.designpattern.study.builder.director.Director;

/**
 * 生成器模式，比如 桌子，椅子，沙发都有不同的风格，现需要同种风格或不同风格的搭配，就可以用生成器模式，动态控制构造方法
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());
        System.out.println("Car built:\n" + car);

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}
