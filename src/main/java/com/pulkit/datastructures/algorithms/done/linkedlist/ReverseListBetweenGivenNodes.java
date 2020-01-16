package com.pulkit.datastructures.algorithms.done.linkedlist;

public class ReverseListBetweenGivenNodes {
    public static void main(String[] args) {
        Nodee<Integer> firstList = new Nodee(2,
                new Nodee(5,
                        new Nodee(11,
                                new Nodee(15,
                                        new Nodee(19,
                                                new Nodee(21,
                                                        null))))));
        System.out.println(firstList);
        System.out.println(reverse(firstList, 11, 21));
    }

    //LinkedList example
    //2->5->11->15->19->21
    //2->5  null<-11->15->19->21

    //TODO: Need to be fixed
    private static Nodee<Integer> reverse(Nodee head, Integer start, Integer end) {
        Nodee current = head;
        Nodee previous = null;

        while (current.data != start) {
            previous = current;
            current = current.nextNode;
        }

        Nodee reversePrevious = null;
        Nodee reverseHead = current;
        Nodee next = current;

        while (current.data != end) {
            next = current.nextNode;
            current.nextNode = reversePrevious;
            reversePrevious = current;
            current = next;
        }

        previous.nextNode = current;
        reverseHead.nextNode = next;

        return head;
    }
}

class Nodee<T> {
    T data;
    Nodee<T> nextNode;

    Nodee(T data, Nodee<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data + "->" + nextNode;
    }
}