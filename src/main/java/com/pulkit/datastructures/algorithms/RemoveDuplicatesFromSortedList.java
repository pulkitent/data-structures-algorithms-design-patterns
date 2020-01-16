package com.pulkit.DsAlgo;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Node list = new Node(1,
                new Node(2,
                        new Node(2,
                                new Node(2,
                                        new Node(3,
                                                new Node(3,
                                                        new Node(4,
                                                                null)))))));

        System.out.println(list);
        System.out.println(remove(list));
    }

    private static Node remove(Node head) {
        Node slow = head;
        Node fast = head.nextNode;

        while (fast != null) {
            if (slow != null && fast != null && slow.data == fast.data) {
                while (slow != null && fast != null && slow.data == fast.data) {
                    fast = fast.nextNode;
                }

                slow.nextNode = fast;
                slow = fast;

            } else {
                if (slow != null && fast != null) {
                    slow = slow.nextNode;
                    fast = fast.nextNode;
                }
            }
        }
        return head;
    }
}
