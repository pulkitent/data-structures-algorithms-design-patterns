package com.pulkit.design.patterns.creational.factorypattern.polymorphism.factories;

import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Chocolate;
import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.DairyMilk;

public class DairyMilkFactory implements ChocolateFactory {
    @Override
    public Chocolate createChocolate() {
        return new DairyMilk("DairyMilk");
    }
}