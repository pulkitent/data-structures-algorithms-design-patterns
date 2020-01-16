package com.pulkit.design.patterns.creational.factorypattern.switchcase.factories;

import com.pulkit.design.patterns.creational.factorypattern.switchcase.constants.ChocolateTypes;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.models.Chocolate;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.models.DairyMilk;
import com.pulkit.design.patterns.creational.factorypattern.switchcase.models.Kitkat;

public class ChocolateFactory {

    public Chocolate createChocolate(ChocolateTypes chocolateType) {
        switch (chocolateType) {
            case KITKAT:
                return new Kitkat("Kitkat");
            case DAIRYMILK:
                return new DairyMilk("DairyMilk");
            default:
                return new DairyMilk("Kitkat");
        }
    }
}