package com.pulkit.design_patterns.creational.factory_pattern.switchcase.models;

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