package com.pulkit.datastructures_algorithms.done.linkedlist;

//LinkedList example
/*  2->5->11
    4->7

    2->5->11->15->19
    4->7->13->17
*/
public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        //Another Test case
        //com.pulkit.DsAlgo.Node firstList = new com.pulkit.DsAlgo.Node(2, new com.pulkit.DsAlgo.Node(5, new com.pulkit.DsAlgo.Node(11, null)));
        //com.pulkit.DsAlgo.Node secondList = new com.pulkit.DsAlgo.Node(4, new com.pulkit.DsAlgo.Node(7, null));

        Node firstList = new Node(2, new Node(5, new Node(11, new Node(15,
                new Node(19, null)))));
        Node secondList = new Node(4, new Node(7, new Node(13,
                new Node(17, null))));

        System.out.println(firstList);
        System.out.println(secondList);
        System.out.println(merge(firstList, secondList));
    }

    private static Node merge(Node firstList, Node secondList) {
        Node head = firstList;
        Node firstListCurrent = firstList.nextNode;
        Node secondListCurrent = secondList;
        Node tail = firstList;

        if (firstList.data > secondList.data) {
            head = secondList;
            tail = secondList;
            secondListCurrent = secondList.nextNode;
        }

        while (firstListCurrent != null && secondListCurrent != null) {
            if (firstListCurrent.data > secondListCurrent.data) {
                tail.nextNode = secondListCurrent;
                tail = secondListCurrent;
                secondListCurrent = secondListCurrent.nextNode;

            } else {
                tail.nextNode = firstListCurrent;
                tail = firstListCurrent;
                firstListCurrent = firstListCurrent.nextNode;
            }
        }

        if (firstListCurrent != null) {
            tail.nextNode = firstListCurrent;
        }

        if (secondListCurrent != null) {
            tail.nextNode = secondListCurrent;
        }

        return head;
    }
}

class Node {
    int data;
    Node nextNode;

    Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        //return data + "";
        return data + "->" + nextNode;
    }
}