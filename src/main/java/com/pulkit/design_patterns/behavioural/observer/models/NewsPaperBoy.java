package com.pulkit.design_patterns.behavioural.observer.models;

import java.util.LinkedList;
import java.util.List;

public class NewsPaperBoy {
    List<Person> peopleToBeNotified = new LinkedList<>();

    public void registerForNewsWithMe(Person personWhoWantsTerrorNews) {
        peopleToBeNotified.add(personWhoWantsTerrorNews);
    }

    public void notifyAllPeople() {
        for (Person person : peopleToBeNotified) {
            person.giveNews("Government down");
            person.giveNews("Bomb blast");
        }
    }
}