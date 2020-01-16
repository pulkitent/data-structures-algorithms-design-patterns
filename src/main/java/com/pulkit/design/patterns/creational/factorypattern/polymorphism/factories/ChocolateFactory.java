package com.pulkit.design.patterns.creational.factorypattern.polymorphism.factories;

import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Chocolate;

public interface ChocolateFactory {
    Chocolate createChocolate();
}