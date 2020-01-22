package com.pulkit.design.patterns.creational.builder.models;

import com.pulkit.design.patterns.creational.builder.CarBuilder;
import com.pulkit.design.patterns.creational.builder.constants.FuelType;
import com.pulkit.design.patterns.creational.builder.constants.Manufacturer;
import com.pulkit.design.patterns.creational.builder.constants.ModelType;

import java.time.LocalDateTime;

public class Car {
    private String engineNumber;
    private int modelYear;
    private LocalDateTime registrationYear;
    private ModelType modelType;
    private FuelType fuelType;
    private Manufacturer manufacturer;
    private String RTOLocation;

    public Car(CarBuilder carBuilder) {
        this.engineNumber = carBuilder.getEngineNumber();
        this.modelYear = carBuilder.getModelYear();
        this.registrationYear = carBuilder.getRegistrationYear();
        this.modelType = carBuilder.getModelType();
        this.fuelType = carBuilder.getFuelType();
        this.manufacturer = carBuilder.getManufacturer();
        this.RTOLocation = carBuilder.getRTOLocation();
    }
}