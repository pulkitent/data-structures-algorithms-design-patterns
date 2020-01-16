package com.pulkit.design.patterns.behavioural.observer;

import com.pulkit.design.patterns.behavioural.observer.models.NewsPaperBoy;
import com.pulkit.design.patterns.behavioural.observer.models.Person;
import com.pulkit.design.patterns.behavioural.observer.models.PersonWhoWantsPoliticalNews;
import com.pulkit.design.patterns.behavioural.observer.models.PersonWhoWantsTerrorNews;

//TODO: Implement it properly to have different types of news
public class PatternUsage {
    public static void main(String[] args) {
        Person pulkit = new PersonWhoWantsTerrorNews("Pulkit");
        Person jyoti = new PersonWhoWantsPoliticalNews("Jyoti");

        NewsPaperBoy boy = new NewsPaperBoy();
        boy.registerForNewsWithMe(pulkit);
        boy.registerForNewsWithMe(jyoti);

        boy.notifyAllPeople();
    }
}