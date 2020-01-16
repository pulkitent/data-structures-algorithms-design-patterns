package com.pulkit.datastructures.algorithms.done;

public class MergeSortForLinkedList {
    public static void main(String[] args) {
        //19->15->11->9->6-null
        //Expected Output - 6->9->11->15->19
        Node lastNode = new Node(6, null);
        Node head = new Node(19,
                new Node(15,
                        new Node(11,
                                new Node(9,
                                        lastNode))));
        System.out.println(head);
        head = sort(head, lastNode);
        System.out.println(head);
    }

    private static Node sort(Node head, Node end) {
        if (head == end) {
            return head;
        }

        Node mid = findMid(head, end);
        Node midNext = mid.nextNode;
        mid.nextNode = null;

        Node head1 = sort(head, mid);
        Node head2 = sort(midNext, end);

        return mergeTwoSortedLinkedList(head1, head2);
    }

    private static Node findMid(Node start, Node end) {
        if (start == end)
            return start;

        if (start.nextNode == end)
            return start;

        Node fast = start;
        Node slow = start;

        while (fast != null && fast.nextNode != null && fast != end) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }

        return slow;
    }

    private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        Node head, tail;
        Node ptr1, ptr2;

        if (head1.data > head2.data) {
            head = head2;
            tail = head2;
            ptr1 = head2.nextNode;
            ptr2 = head1;

        } else {
            head = head1;
            tail = head1;
            ptr1 = head1.nextNode;
            ptr2 = head2;
        }

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data > ptr2.data) {
                tail.nextNode = ptr2;
                ptr2 = ptr2.nextNode;
                tail = tail.nextNode;
            } else {
                tail.nextNode = ptr1;
                ptr1 = ptr1.nextNode;
                tail = tail.nextNode;
            }
        }

        if (ptr1 == null) {
            tail.nextNode = ptr2;
        }

        if (ptr2 == null) {
            tail.nextNode = ptr1;
        }
        return head;
    }
}