package com.pulkit.datastructures_algorithms.done.linkedlist;

public class TestLinkedListIsPalindrome {
    private static Node head = null;
    private static boolean result = true;

    public static void main(String[] args) {
        Node list = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(2,
                                        new Node(3,
                                                new Node(2,
                                                        new Node(1,
                                                                null)))))));
        head = list;
        isPalindrome(list);
        System.out.println(result);
    }

    private static void isPalindrome(Node localHead) {
        if (localHead == null) {
            return;
        }

        isPalindrome(localHead.nextNode);

        //System.out.println("comparing " + head.data + " " + localHead.data);
        if (head.data != localHead.data) {
            //System.out.println("comparison failed for " + head.data + " " + localHead.data);
            result = false;
            return;
        }
        head = head.nextNode;
    }
}