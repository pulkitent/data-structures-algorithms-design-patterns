package com.pulkit.design.patterns.creational.builder;

import com.pulkit.design.patterns.creational.builder.constants.FuelType;
import com.pulkit.design.patterns.creational.builder.constants.Manufacturer;
import com.pulkit.design.patterns.creational.builder.constants.ModelType;
import com.pulkit.design.patterns.creational.builder.models.Car;

import java.time.LocalDateTime;

public class CarBuilder {
    private String engineNumber;
    private int modelYear;
    private LocalDateTime registrationYear;
    private ModelType modelType;
    private FuelType fuelType;
    private Manufacturer manufacturer;
    private String RTOLocation;

    static CarBuilder builder() {
        return new CarBuilder();
    }

    Car build() {
        return new Car(this);
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public LocalDateTime getRegistrationYear() {
        return registrationYear;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getRTOLocation() {
        return RTOLocation;
    }

    CarBuilder setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
        return this;
    }

    CarBuilder setModelYear(int modelYear) {
        this.modelYear = modelYear;
        return this;
    }

    CarBuilder setRegistrationYear(LocalDateTime registrationYear) {
        this.registrationYear = registrationYear;
        return this;
    }

    CarBuilder setModelType(ModelType modelType) {
        this.modelType = modelType;
        return this;
    }

    CarBuilder setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    CarBuilder setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    CarBuilder setRTOLocation(String RTOLocation) {
        this.RTOLocation = RTOLocation;
        return this;
    }
}