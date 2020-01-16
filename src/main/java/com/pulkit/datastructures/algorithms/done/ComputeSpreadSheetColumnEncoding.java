package com.pulkit.datastructures.algorithms.done;

public class ComputeSpreadSheetColumnEncoding {
    public static void main(String[] args) {
        //Another Test case
        //String a = "AA";

        //Another Test case
        //String a ="ZZ";

        //Another Test case
        //String a ="AAC";

        String a ="YZ";

        System.out.println(compute(a));
    }

    private static int compute(String a) {
        int result = 0;
        int power = 0;

        for (int index = a.length() - 1; index >= 0; index--) {
            result = result + (((a.charAt(index) - 'A') + 1) * (int) Math.pow(26, power));
            power++;
        }

        return result;
    }
}