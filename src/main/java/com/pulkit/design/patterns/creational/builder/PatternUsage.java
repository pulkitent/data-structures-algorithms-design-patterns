package com.pulkit.design.patterns.creational.builder;

import com.pulkit.design.patterns.creational.builder.constants.FuelType;
import com.pulkit.design.patterns.creational.builder.constants.Manufacturer;
import com.pulkit.design.patterns.creational.builder.constants.ModelType;
import com.pulkit.design.patterns.creational.builder.models.Car;

import java.time.LocalDateTime;

public class PatternUsage {
    public static void main(String[] args) {
        Car car = CarBuilder.builder()
                .setEngineNumber("123-456-789")
                .setFuelType(FuelType.CNG)
                .setModelType(ModelType.LXI)
                .setModelYear(2014)
                .setManufacturer(Manufacturer.MARUTI)
                .setRegistrationYear(LocalDateTime.now())
                .setRTOLocation("DL")
                .build();
    }
}