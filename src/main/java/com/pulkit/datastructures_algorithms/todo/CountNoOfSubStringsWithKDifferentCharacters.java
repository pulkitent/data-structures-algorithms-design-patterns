package com.pulkit.datastructures_algorithms.todo;

import java.util.HashMap;

public class CountNoOfSubStringsWithKDifferentCharacters {
    public static void main(String[] args) {
        String input1 = "abcdaaa";
        int noOfUniqueCharactersRequired1 = 4;
        int expectedCount1 = 2;
        testCase(input1, noOfUniqueCharactersRequired1, expectedCount1);

        String input2 = "abcaaada";
        int noOfUniqueCharactersRequired2 = 4;
        int expectedCount2 = 1;
        testCase(input2, noOfUniqueCharactersRequired2, expectedCount2);
    }

    private static int countAnotherApproach(String input, int uniqueCountRequired) {
        int length = input.length();

        if (length == 0 || length < uniqueCountRequired)
            return 0;

        int slowIndex = 0;
        int fastIndex = 0;
        int noOfUniqueStrings = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        //abcaaada
        while (fastIndex < length) {
            int uniqueCharactersCountSoFar = 0;
            while (fastIndex < length &&
                    uniqueCharactersCountSoFar <= uniqueCountRequired) {
                char currentCharacter = input.charAt(fastIndex);
                if (hm.containsKey(currentCharacter)) {
                    if (fastIndex - slowIndex == uniqueCountRequired) {
                        noOfUniqueStrings++;
                    }
                    slowIndex = hm.get(currentCharacter) + 1;
                } else {
                    uniqueCharactersCountSoFar++;
                }
                hm.put(currentCharacter, fastIndex);
                fastIndex++;
            }

            if (uniqueCharactersCountSoFar == uniqueCountRequired) {
                noOfUniqueStrings++;
            }

            while (uniqueCharactersCountSoFar == uniqueCountRequired) {
                char currentCharacter = input.charAt(slowIndex);
                if (hm.containsKey(currentCharacter)) {
                    Integer charFrequency = hm.get(currentCharacter);
                    if (charFrequency > 1) {
                        hm.put(currentCharacter, charFrequency - 1);
                        noOfUniqueStrings++;
                    } else {
                        hm.remove(currentCharacter);
                        uniqueCharactersCountSoFar--;
                    }
                    slowIndex++;
                }
            }
        }
        return noOfUniqueStrings;
    }

    private static int count(String input, int uniqueCountRequired) {
        int length = input.length();

        if (length == 0 || length < uniqueCountRequired)
            return 0;

        int slowIndex = 0;
        int fastIndex = 0;
        int noOfUniqueStrings = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        while (fastIndex < length) {
            int uniqueCharactersCountSoFar = 0;
            while (fastIndex < length &&
                    uniqueCharactersCountSoFar <= uniqueCountRequired) {
                char currentCharacter = input.charAt(fastIndex);
                if (hm.containsKey(currentCharacter)) {
                    hm.put(currentCharacter, hm.get(currentCharacter) + 1);
                } else {
                    hm.put(currentCharacter, 1);
                    uniqueCharactersCountSoFar++;
                }
                fastIndex++;
            }

            if (uniqueCharactersCountSoFar == uniqueCountRequired) {
                noOfUniqueStrings++;
            }

            while (uniqueCharactersCountSoFar == uniqueCountRequired) {
                char currentCharacter = input.charAt(slowIndex);
                if (hm.containsKey(currentCharacter)) {
                    Integer charFrequency = hm.get(currentCharacter);
                    if (charFrequency > 1) {
                        hm.put(currentCharacter, charFrequency - 1);
                        noOfUniqueStrings++;
                    } else {
                        hm.remove(currentCharacter);
                        uniqueCharactersCountSoFar--;
                    }
                    slowIndex++;
                }
            }
        }
        return noOfUniqueStrings;
    }

    private static void testCase(String input1, int noOfUniqueCharactersRequired1, int expectedCount1) {
        int resultantCount1 = count(input1, noOfUniqueCharactersRequired1);
        if (resultantCount1 == expectedCount1) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected Output " + expectedCount1);
            System.out.println("Actual Output " + resultantCount1);
        }
    }
}