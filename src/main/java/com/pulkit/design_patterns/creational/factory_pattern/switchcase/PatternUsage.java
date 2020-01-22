package com.pulkit.design_patterns.creational.factory_pattern.switchcase;

import com.pulkit.design_patterns.creational.factory_pattern.switchcase.factories.ChocolateFactory;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.constants.ChocolateTypes;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.models.Chocolate;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.models.Person;

public class PatternUsage {
    public static void main(String[] args) {
        ChocolateFactory chocolateFactory = new ChocolateFactory();
        Chocolate chocolate = chocolateFactory.createChocolate(ChocolateTypes.DAIRYMILK);

        Person pulkit = new Person("Pulkit");
        pulkit.eatChocolate(chocolate);
    }
}