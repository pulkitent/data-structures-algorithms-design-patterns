package com.pulkit.design_patterns.creational.factory_pattern.polymorphism.factories;

import com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models.Chocolate;

public interface ChocolateFactory {
    Chocolate createChocolate();
}