package com.pulkit.design_patterns.creational.factory_pattern.polymorphism;

import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.factories.ChocolateFactory;
import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.factories.KitkatFactory;
import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models.Chocolate;
import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models.Person;

public class PatternUsage {
    public static void main(String[] args) {
        ChocolateFactory chocolateFactory = new KitkatFactory();
        Chocolate chocolate = chocolateFactory.createChocolate();

        Person pulkit = new Person("Pulkit");
        pulkit.eatChocolate(chocolate);
    }
}