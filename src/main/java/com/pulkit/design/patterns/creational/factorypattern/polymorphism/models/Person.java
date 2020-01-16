package com.pulkit.design.patterns.creational.factorypattern.polymorphism.models;

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