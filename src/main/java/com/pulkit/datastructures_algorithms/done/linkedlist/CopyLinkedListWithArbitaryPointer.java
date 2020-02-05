package com.pulkit.datastructures_algorithms.done.linkedlist;

/*
  ___________     ________
 |          \|/  |       \|/
100->85->90->55->10->16->12
     |______________ /|\


100->85->90->55->10->16->12

 */

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithArbitaryPointer {
    public static void main(String[] args) {

    }

    LinkedListWithArbitaryPointer doCopy(LinkedListWithArbitaryPointer originalHead) {
        Map<LinkedListWithArbitaryPointer, LinkedListWithArbitaryPointer> map = new HashMap<>();

        LinkedListWithArbitaryPointer copiedHead = new LinkedListWithArbitaryPointer(originalHead.data);

        LinkedListWithArbitaryPointer originalTemp = originalHead.next;
        LinkedListWithArbitaryPointer copiedTemp = copiedHead;

        while (originalTemp != null) {
            LinkedListWithArbitaryPointer copyNode = new LinkedListWithArbitaryPointer(originalTemp.data);

            map.put(originalTemp, copiedTemp);

            copiedTemp.next = copyNode;
            copiedTemp = copyNode;

            originalTemp = originalTemp.next;
        }

        originalTemp = originalHead;
        copiedTemp = copiedHead;

        while (originalTemp != null) {
            LinkedListWithArbitaryPointer orignalRandomNode = originalTemp.randomPointer;
            LinkedListWithArbitaryPointer copiedRandomNode = map.get(orignalRandomNode);

            copiedTemp.randomPointer = copiedRandomNode;

            copiedTemp = copiedTemp.next;
            originalTemp = originalTemp.next;
        }

        return copiedHead;
    }
}

class LinkedListWithArbitaryPointer {
    int data;
    LinkedListWithArbitaryPointer next;
    LinkedListWithArbitaryPointer randomPointer;

    public LinkedListWithArbitaryPointer(int data, LinkedListWithArbitaryPointer next,
                                         LinkedListWithArbitaryPointer randomPointer) {
        this.data = data;
        this.next = next;
        this.randomPointer = randomPointer;
    }

    public LinkedListWithArbitaryPointer(int data) {
        this.data = data;
    }
}