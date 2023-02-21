package com.tuling.designpattern.study.builder.builders;

import com.tuling.designpattern.study.builder.cars.CarType;
import com.tuling.designpattern.study.builder.components.Engine;
import com.tuling.designpattern.study.builder.components.GPSNavigator;
import com.tuling.designpattern.study.builder.components.Transmission;
import com.tuling.designpattern.study.builder.components.TripComputer;

// 通用生成器接口
public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
