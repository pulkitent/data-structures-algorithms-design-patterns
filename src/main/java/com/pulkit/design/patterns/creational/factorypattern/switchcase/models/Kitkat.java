package com.pulkit.design.patterns.creational.factorypattern.switchcase.models;

public class Kitkat implements Chocolate {
    String name;

    public Kitkat(String name) {
        this.name = name;
    }

    @Override
    public String Expiry() {
        return "Kitkat Expired";
    }
}