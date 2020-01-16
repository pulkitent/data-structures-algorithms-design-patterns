package com.pulkit.design.patterns.creational.factorypattern.polymorphism.factories;

import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Chocolate;
import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Kitkat;

public class KitkatFactory implements ChocolateFactory {
    @Override
    public Chocolate createChocolate() {
        return new Kitkat("Kitkat");
    }
}
