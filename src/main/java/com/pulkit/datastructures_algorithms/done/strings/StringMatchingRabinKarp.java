package com.pulkit.datastructures_algorithms.done.strings;

public class StringMatchingRabinKarp {
    public static void main(String[] args) {
        //Test case : Expected output - true
        //String text = "abcdebcdef";
        //String pattern = "bcdef";

        //Another Test case  : Expected Output - true
        String text = "bcdecdebcdebcdef";
        String pattern = "bcdef";

        System.out.println(doMatching(text, pattern));
    }

    private static boolean doMatching(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        if (textLength < patternLength)
            return false;

        long textHash = 0L;
        long patternHash = 0L;
        int hashConstant = 11;

        for (int index = patternLength - 1; index >= 0; index--) {
            patternHash = (patternHash + pattern.charAt(index)) * hashConstant;
        }

        for (int index = patternLength - 1; index >= 0; index--) {
            textHash = (textHash + text.charAt(index)) * hashConstant;
        }

        if (patternHash == textHash)
            return true;

        double hashConstantPowerLength = Math.pow(hashConstant, patternLength);

        for (int index = patternLength; index < textLength; index++) {
            textHash = (textHash / hashConstant) - (text.charAt(index - patternLength))
                    + (long) (text.charAt(index) * hashConstantPowerLength);

            if (checkIfCollisionHasNotOccured(text, pattern, patternLength, textHash, patternHash, index)) {
                System.out.println("Found matching string between: " + (index - patternLength + 2) + "-" + (index + 1));

                return true;
            }
        }

        return false;
    }

    private static boolean checkIfCollisionHasNotOccured(String text, String pattern, int patternLength, long textHash,
                                                         long patternHash, int index) {
        if (textHash == patternHash) {
            int patternTempIndex = 0;
            int successCounts = 0;

            for (int anotherIndex = index - patternLength + 1; anotherIndex <= index; anotherIndex++) {
                if (pattern.charAt(patternTempIndex) != text.charAt(anotherIndex)) {
                    break;
                }
                patternTempIndex++;
                successCounts++;
            }

            return successCounts == patternLength;
        }

        return false;
    }
}