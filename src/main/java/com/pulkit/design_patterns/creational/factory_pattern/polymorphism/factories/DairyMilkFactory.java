package com.pulkit.design_patterns.creational.factory_pattern.polymorphism.factories;

import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models.Chocolate;
import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models.DairyMilk;

public class DairyMilkFactory implements ChocolateFactory {
    @Override
    public Chocolate createChocolate() {
        return new DairyMilk("DairyMilk");
    }
}