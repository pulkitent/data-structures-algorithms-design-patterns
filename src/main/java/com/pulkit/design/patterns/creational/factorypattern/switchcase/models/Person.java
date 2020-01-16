package com.pulkit.design.patterns.creational.factorypattern.switchcase.models;

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