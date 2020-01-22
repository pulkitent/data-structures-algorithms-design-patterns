package com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models;

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