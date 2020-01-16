package com.pulkit.datastructures.algorithms.done;

public class AddDigitToALinkedList {
    public static void main(String[] args) {
        Nodee<Integer> head = new Nodee<>(1,
                new Nodee<>(9,
                        new Nodee<>(9,
                                new Nodee<>(9,
                                        new Nodee<>(9,
                                                new Nodee<>(9, null))))));

        Integer carry = addDigit(head, 9);

        if (carry != 0) {
            System.out.print(carry + " ");
        }


        Nodee<Integer> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.nextNode;
        }
    }

    private static Integer addDigit(Nodee<Integer> head, Integer digit) {
        if (head.nextNode == null) {
            int newLastDigit = head.data + digit;
            if (newLastDigit >= 10) {
                head.data = newLastDigit % 10;
                return newLastDigit / 10;
            } else {
                return 0;
            }
        }

        Integer previousSumCarry = addDigit(head.nextNode, digit);
        int finalData = head.data + previousSumCarry;

        head.data = finalData % 10;
        return finalData / 10;
    }
}