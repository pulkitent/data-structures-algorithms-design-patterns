package com.pulkit.datastructures.algorithms.done.strings;

import java.util.HashMap;

//TODO: This is my own implementation which is complex, Need to revisit to make it simple
public class ConvertIntegerIntoRomanNumerals {
    private static final int ONE = 1;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int FOURTY = 40;
    private static final int FIFTY = 50;
    private static final int NINTY = 90;
    private static final int HUNDRED = 100;
    private static final int FOUR_HUNDRED = 400;
    private static final int FIVE_HUNDRED = 500;
    private static final int NINE_HUNDRED = 900;
    private static final int THOUSAND = 1000;

    private static final HashMap<Integer, String> numberRomanMap = new HashMap<>();

    static {
        numberRomanMap.put(ONE, "I");
        numberRomanMap.put(FOUR, "IV");
        numberRomanMap.put(FIVE, "V");
        numberRomanMap.put(NINE, "IX");
        numberRomanMap.put(TEN, "X");
        numberRomanMap.put(FOURTY, "XL");
        numberRomanMap.put(FIFTY, "L");
        numberRomanMap.put(NINTY, "XC");
        numberRomanMap.put(HUNDRED, "C");
        numberRomanMap.put(FOUR_HUNDRED, "CD");
        numberRomanMap.put(FIVE_HUNDRED, "D");
        numberRomanMap.put(NINE_HUNDRED, "CM");
        numberRomanMap.put(THOUSAND, "M");
    }

    public static void main(String[] args) {
        System.out.println("25 " + convert(25));
        System.out.println("30 " + convert(30));
        System.out.println("100 " + convert(100));
        System.out.println("9 " + convert(9));
        System.out.println("40 " + convert(40));
        System.out.println("1904 " + convert(1904));
        System.out.println("3549 " + convert(3549));
    }

    private static String convert(int number) {
        String result = "";

        while (number > 0) {
            while (number >= THOUSAND) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / THOUSAND;

                    String romanChar = numberRomanMap.get(THOUSAND);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % THOUSAND;
                }
            }

            while (number >= NINE_HUNDRED) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / NINE_HUNDRED;

                    String romanChar = numberRomanMap.get(NINE_HUNDRED);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % NINE_HUNDRED;
                }
            }

            while (number >= FIVE_HUNDRED) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FIVE_HUNDRED;

                    String romanChar = numberRomanMap.get(FIVE_HUNDRED);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FIVE_HUNDRED;
                }
            }

            while (number >= FOUR_HUNDRED) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FOUR_HUNDRED;

                    String romanChar = numberRomanMap.get(FOUR_HUNDRED);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FOUR_HUNDRED;
                }
            }

            while (number >= HUNDRED) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / HUNDRED;

                    String romanChar = numberRomanMap.get(HUNDRED);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % HUNDRED;
                }
            }

            while (number >= NINTY) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / NINTY;

                    String romanChar = numberRomanMap.get(NINTY);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % NINTY;
                }
            }

            while (number >= FIFTY) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FIFTY;

                    String romanChar = numberRomanMap.get(FIFTY);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FIFTY;
                }
            }

            while (number >= FOURTY) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FOURTY;

                    String romanChar = numberRomanMap.get(FOURTY);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FOURTY;
                }
            }

            while (number >= TEN) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / TEN;

                    String romanChar = numberRomanMap.get(TEN);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % TEN;
                }
            }

            while (number >= NINE) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / NINE;

                    String romanChar = numberRomanMap.get(NINE);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % NINE;
                }
            }

            while (number >= FIVE) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FIVE;

                    String romanChar = numberRomanMap.get(FIVE);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FIVE;
                }
            }

            while (number >= FOUR) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / FOUR;

                    String romanChar = numberRomanMap.get(FOUR);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % FOUR;
                }
            }

            while (number >= ONE) {
                if (numberRomanMap.containsKey(number)) {
                    result = result + numberRomanMap.get(number);
                    number = 0;
                } else {
                    int quotient = number / ONE;

                    String romanChar = numberRomanMap.get(ONE);
                    for (int index = ONE; index <= quotient; index++) {
                        result = result + romanChar;
                    }

                    number = number % ONE;
                }
            }
        }
        return result;
    }
}