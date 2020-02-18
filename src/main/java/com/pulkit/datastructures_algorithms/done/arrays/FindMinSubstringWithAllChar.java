package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindMinSubstringWithAllChar {
    public static void main(String[] args) {
        FindMinSubstringWithAllChar find = new FindMinSubstringWithAllChar();

        //Another Test case
        System.out.println(find.compute("abbbbbcba"));

        //Another Test case
        System.out.println(find.compute("abbbcabcda"));

        //Another Test case
        System.out.println(find.compute("aaaabbbb"));
    }

    private Pair compute(String inputString) {
        int ResultStartIndex = 0;
        int ResultEnddex = 0;

        Set<Character> allUniqueCharacters = new HashSet<>();
        Set<Character> charactersVisitedSoFar = new HashSet<>();

        int inputLength = inputString.length();

        for (int index = 0; index < inputLength; index++) {
            char currentCharacter = inputString.charAt(index);

            if (!allUniqueCharacters.contains(currentCharacter)) {
                allUniqueCharacters.add(currentCharacter);
            }
        }

        int allUniqueCharactersSize = allUniqueCharacters.size();

        int startIndex = 0;
        int endIndex = 0;
        int minOutputLength = Integer.MAX_VALUE;

        while (endIndex < inputLength) {
            char currentCharacter = inputString.charAt(endIndex);

            if (allUniqueCharacters.contains(currentCharacter)
                    && !charactersVisitedSoFar.contains(currentCharacter)) {
                allUniqueCharactersSize = allUniqueCharactersSize - 1;
                charactersVisitedSoFar.add(currentCharacter);
            }

            if (allUniqueCharactersSize == 0) {
                if ((endIndex - startIndex) < minOutputLength) {
                    minOutputLength = endIndex - startIndex;
                    ResultStartIndex = startIndex;
                    ResultEnddex = endIndex;
                }

                charactersVisitedSoFar = new HashSet<>();
                allUniqueCharactersSize = allUniqueCharacters.size();
                startIndex = endIndex;
                endIndex = endIndex - 1;
            }

            endIndex++;
        }

        return new Pair(ResultStartIndex, ResultEnddex);
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    Pair() {

    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}