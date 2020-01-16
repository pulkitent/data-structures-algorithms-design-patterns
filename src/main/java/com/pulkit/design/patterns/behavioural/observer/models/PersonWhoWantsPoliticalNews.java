package com.pulkit.design.patterns.behavioural.observer.models;

public class PersonWhoWantsPoliticalNews implements Person {
    String name;

    public PersonWhoWantsPoliticalNews(String name) {
        this.name = name;
    }

    public void giveNews(String news) {
        System.out.println("Latest News is " + news);
    }
}