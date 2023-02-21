package com.tuling.designpattern.study.builder.cars;

import com.tuling.designpattern.study.builder.components.Engine;
import com.tuling.designpattern.study.builder.components.GPSNavigator;
import com.tuling.designpattern.study.builder.components.Transmission;
import com.tuling.designpattern.study.builder.components.TripComputer;
import lombok.Data;

// 汽车产品
@Data
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }
}
