package com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.factories;

import com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.models.Chocolate;
import com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.models.Kitkat;

public class KitkatFactory implements ChocolateFactory {
    @Override
    public Chocolate createChocolate() {
        return new Kitkat("Kitkat");
    }
}
