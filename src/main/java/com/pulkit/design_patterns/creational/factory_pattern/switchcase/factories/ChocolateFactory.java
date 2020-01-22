package com.pulkit.design_patterns.creational.factory_pattern.switchcase.factories;

import com.pulkit.design_patterns.creational.factory_pattern.switchcase.constants.ChocolateTypes;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.models.Chocolate;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.models.DairyMilk;
import com.pulkit.design_patterns.creational.factory_pattern.switchcase.models.Kitkat;

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