package com.pulkit.design.patterns.creational.factorypattern.polymorphism;

import com.pulkit.design.patterns.creational.factorypattern.polymorphism.factories.ChocolateFactory;
import com.pulkit.design.patterns.creational.factorypattern.polymorphism.factories.KitkatFactory;
import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Chocolate;
import com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Person;

public class PatternUsage {
    public static void main(String[] args) {
        ChocolateFactory chocolateFactory = new KitkatFactory();
        Chocolate chocolate = chocolateFactory.createChocolate();

        com.pulkit.design.patterns.creational.factorypattern.polymorphism.models.Person pulkit = new Person("Pulkit");
        pulkit.eatChocolate(chocolate);
    }
}