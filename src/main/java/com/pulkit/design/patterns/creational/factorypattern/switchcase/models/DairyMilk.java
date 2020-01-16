package com.pulkit.design.patterns.creational.factorypattern.switchcase.models;

public class DairyMilk implements Chocolate {
    String name;

    public DairyMilk(String name) {
        this.name = name;
    }

    @Override
    public String Expiry() {
        return "DairyMilk expired";
    }
}