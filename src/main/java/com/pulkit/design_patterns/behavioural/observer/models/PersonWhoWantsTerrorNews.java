package com.pulkit.design_patterns.behavioural.observer.models;

public class PersonWhoWantsTerrorNews implements Person {
    String name;

    public PersonWhoWantsTerrorNews(String name) {
        this.name = name;
    }

    public void giveNews(String news) {
        System.out.println("Latest News is " + news);
    }
}