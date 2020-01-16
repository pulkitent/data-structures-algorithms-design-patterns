package com.pulkit.DsAlgo;

public class CompressString {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        StringBuilder compressedString = new StringBuilder("");

        int fastIndex = 0, slowIndex = 0;
        int length = input.length();

        while (slowIndex < length && slowIndex != length) {
            while (ifValuesAreEqualAtSlowAndFastIndex(input, fastIndex, slowIndex, length)) {
                fastIndex++;
            }

            Character a = input.charAt(slowIndex);
            compressedString.append((a.toString() + getTotalCountOfCharacterAtSlowIndex(fastIndex, slowIndex)));

            slowIndex = fastIndex;
        }

        System.out.println(compressedString);
    }

    private static boolean ifValuesAreEqualAtSlowAndFastIndex(String input, int fastIndex, int slowIndex, int length) {
        return fastIndex < length && input.charAt(slowIndex) == input.charAt(fastIndex);
    }

    private static int getTotalCountOfCharacterAtSlowIndex(int fastIndex, int slowIndex) {
        return fastIndex - slowIndex;
    }
}