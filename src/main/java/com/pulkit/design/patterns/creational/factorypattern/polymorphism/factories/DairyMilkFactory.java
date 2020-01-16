package com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.factories;

import com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.models.Chocolate;
import com.pulkit.design.patterns.Creational.FactoryPattern.by.polymorphism.models.DairyMilk;

public class DairyMilkFactory implements ChocolateFactory {
    @Override
    public Chocolate createChocolate() {
        return new DairyMilk("DairyMilk");
    }
}