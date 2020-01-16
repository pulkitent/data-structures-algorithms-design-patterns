package com.pulkit.datastructures.algorithms.done.linkedlist;

import com.pulkit.datastructures.algorithms.done.linkedlist.Node;

//List Example
/* 1->2->3->4->5->6->7->8 */
public class ImplementOddEvenMerge {
    static Node oddHead = null;
    static Node evenHead = null;

    public static void main(String[] args) {
        //Another Test case
        /*
        com.pulkit.DsAlgo.Node list = new com.pulkit.DsAlgo.Node(0,
                new com.pulkit.DsAlgo.Node(1,
                        new com.pulkit.DsAlgo.Node(2,
                                new com.pulkit.DsAlgo.Node(3,
                                        new com.pulkit.DsAlgo.Node(4,
                                                new com.pulkit.DsAlgo.Node(5,
                                                        new com.pulkit.DsAlgo.Node(6,
                                                                null)))))));
        */

        Node list = new Node(0,
                new Node(1,
                        new Node(2,
                                new Node(3,
                                        new Node(4,
                                                new Node(5,
                                                        new Node(6,
                                                                new Node(7,
                                                                        null))))))));


        System.out.println(list);
        merge(list);

        System.out.println(oddHead);
        System.out.println(evenHead);
    }

    private static void merge(Node head) {
        oddHead = head;
        evenHead = head.nextNode;

        Node oddCurrent = head;
        Node evenCurrent = head.nextNode;

        while (evenCurrent != null && oddCurrent != null) {
            if (evenCurrent != null) {
                oddCurrent.nextNode = evenCurrent.nextNode;
                oddCurrent = oddCurrent.nextNode;
            } else {
                oddCurrent.nextNode = null;
            }

            if (oddCurrent != null) {
                evenCurrent.nextNode = oddCurrent.nextNode;
                evenCurrent = evenCurrent.nextNode;
            } else {
                evenCurrent.nextNode = null;
            }
        }
    }
}