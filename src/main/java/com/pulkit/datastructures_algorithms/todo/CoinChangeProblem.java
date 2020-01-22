package com.pulkit.datastructures_algorithms.todo;

import java.util.LinkedList;
import java.util.List;

public class CoinChangeProblem {
    private static final List<List<Integer>> coinsList = new LinkedList<>();
    private static final List<Integer> coinList = new LinkedList<>();
    private static final Count count = new Count(0);
    private static int dpStateMatrix[][] = new int[5][5];

    public static void main(String[] args) {

        List<Integer> givenCoins = new LinkedList<>();
        givenCoins.add(1);
        givenCoins.add(2);
        givenCoins.add(3);
        givenCoins.add(4);
        givenCoins.add(5);

        calculateCountWithCoinsDetails(givenCoins, 5,
                0, 0);

        for (List list : coinsList) {
            for (Object coin : list) {
                System.out.print(coin + " ");
            }
            System.out.println("");
        }

        calculateCountsOnly(givenCoins, 5, 0, 0, count);
        System.out.println(count.counter);
    }

    private static void calculateCountWithCoinsDetails(List<Integer> givenCoins, int expectedValue,
                                                       int currentValue, int index) {
        //System.out.println("function called with argument " + expectedValue + " " + currentValue);

        if (currentValue > expectedValue)
            return;

        if (currentValue == expectedValue) {
            List<Integer> resultantCoinList = new LinkedList<>(coinList);
            coinsList.add(resultantCoinList);
            return;
        }

        for (int currentIndex = index; currentIndex < givenCoins.size(); currentIndex++) {
            Integer currentCoinValue = givenCoins.get(currentIndex);
            coinList.add(currentCoinValue);
            calculateCountWithCoinsDetails(givenCoins, expectedValue,
                    currentValue + currentCoinValue, currentIndex);
            coinList.remove(currentCoinValue);
        }
    }

    private static void calculateCountsOnly(List<Integer> givenCoins, int expectedValue,
                                            int currentValue, int index, Count count) {
        System.out.println("function called with argument " + expectedValue + " " + currentValue);

        if (currentValue > expectedValue)
            return;

        if (currentValue == expectedValue) {
            count.counter++;
        }

        for (int currentIndex = index; currentIndex < givenCoins.size(); currentIndex++) {
            Integer currentCoinValue = givenCoins.get(currentIndex);
            calculateCountsOnly(givenCoins, expectedValue,
                    currentValue + currentCoinValue, currentIndex, count);
        }
    }

    static class Count {
        int counter;

        Count(int counter) {
            this.counter = counter;
        }
    }
}