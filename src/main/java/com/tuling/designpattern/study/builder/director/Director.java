package com.tuling.designpattern.study.builder.director;

import com.tuling.designpattern.study.builder.builders.Builder;
import com.tuling.designpattern.study.builder.cars.CarType;
import com.tuling.designpattern.study.builder.components.Engine;
import com.tuling.designpattern.study.builder.components.GPSNavigator;
import com.tuling.designpattern.study.builder.components.Transmission;
import com.tuling.designpattern.study.builder.components.TripComputer;

// 主管, 用来控制生成器
public class  Director{
    public void constructSportsCar(Builder builder){
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }

}
