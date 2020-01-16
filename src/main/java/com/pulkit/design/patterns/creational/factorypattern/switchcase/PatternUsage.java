package com.pulkit.design.patterns.creational.factorypattern.switchcase;

import com.pulkit.design.patterns.creational.factorypattern.switchcase.constants.ChocolateTypes;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.factories.ChocolateFactory;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.models.Chocolate;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.models.Person;

public class PatternUsage {
    public static void main(String[] args) {
        com.pulkit.design.patterns.creational.factorypattern.switchcase.factories.ChocolateFactory chocolateFactory = new ChocolateFactory();
        Chocolate chocolate = chocolateFactory.createChocolate(ChocolateTypes.DAIRYMILK);

        com.pulkit.design.patterns.creational.factorypattern.switchcase.models.Person pulkit = new Person("Pulkit");
        pulkit.eatChocolate(chocolate);
    }
}