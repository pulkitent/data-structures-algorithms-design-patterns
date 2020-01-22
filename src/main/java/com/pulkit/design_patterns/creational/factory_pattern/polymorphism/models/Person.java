package com.pulkit.design_patterns.creational.factory_pattern.polymorphism.models;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void eatChocolate(Chocolate chocolate) {
        Kitkat kitkat = (Kitkat) chocolate;
        System.out.println("I am eating " + kitkat.name);
    }
}