package com.pulkit.design_patterns.creational.factory_pattern.switchcase.models;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void eatChocolate(Chocolate chocolate) {
        DairyMilk dairyMilk = (DairyMilk) chocolate;
        System.out.println("I am eating " + dairyMilk.name);
    }
}