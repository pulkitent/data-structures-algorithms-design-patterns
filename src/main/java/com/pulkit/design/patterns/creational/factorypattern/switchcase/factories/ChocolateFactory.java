package com.pulkit.design.patterns.Creational.FactoryPattern.by.switchcase.factories;

import com.pulkit.design.patterns.Creational.FactoryPattern.by.switchcase.constants.ChocolateTypes;
import com.pulkit.design.patterns.Creational.FactoryPattern.by.switchcase.models.Chocolate;
import com.pulkit.design.patterns.Creational.FactoryPattern.by.switchcase.models.DairyMilk;
import com.pulkit.design.patterns.Creational.FactoryPattern.by.switchcase.models.Kitkat;

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