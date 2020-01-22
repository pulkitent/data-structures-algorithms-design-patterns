package com.pulkit.datastructures_algorithms.done;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStream {
    DoublyLinkedListNode<Integer> head = null;
    DoublyLinkedListNode<Integer> last = null;
    Map<Integer, DoublyLinkedListNode<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        FirstNonRepeatingCharacterInStream client = new FirstNonRepeatingCharacterInStream();

        //Expected Output - 1 1 1 1 1 1 1 1
        //int stream[] = {1, 2, 3, 4, 5, 6, 7, 9};

        //Expected Output - 1 1 1 1 1 1 1 4
        //int stream[] = {1, 2, 3, 4, 3, 6, 2, 1};

        //TODO: Fix it
        int stream[] = {1, 1, 3, 3, 3, 6, 6, 7};
        //TODO: Fix it
        //int stream[] = {1, 2, 1, 3, 3, 2, 6, 7};

        for (Integer element : stream) {
            System.out.print(client.find(element) + " ");
        }
    }

    private Integer find(int streamElement) {
        if (head == null) {
            head = new DoublyLinkedListNode<>(streamElement);
            last = head;

            map.put(streamElement, head);
            return head.data;
        }

        if (map.containsKey(streamElement)) {
            DoublyLinkedListNode<Integer> streamElementNodeInDLL = map.get(streamElement);

            DoublyLinkedListNode<Integer> previousNode = streamElementNodeInDLL.previous;
            DoublyLinkedListNode<Integer> nextNode = streamElementNodeInDLL.next;

            if (previousNode != null) {
                previousNode.next = nextNode;
            }

            if (streamElementNodeInDLL == last) {
                last = previousNode;
            }

            if (streamElementNodeInDLL == head) {
                head = nextNode;
            }

            streamElementNodeInDLL.previous = null;
            streamElementNodeInDLL.next = null;

            if (head != null) {
                return head.data;
            }

            head = new DoublyLinkedListNode<>(streamElement);
            last = head;
            return head.data;
        }

        DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(streamElement);
        last.next = node;
        node.previous = last;
        last = node;

        map.put(streamElement, node);
        return head.data;
    }
}

class DoublyLinkedListNode<T> {
    T data;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> previous;

    public DoublyLinkedListNode(T data) {
        this.data = data;
    }
}