package com.pulkit.datastructures.algorithms.done;

public class Heap {
//com.pulkit.DsAlgo.Heap Example
    /*

          10
     9         7
  1    5   3      6
 4 8  2

    [3,5,7,9,10,2,6,1,8,4]
    [2,8,6,9,10,3,7,1,4,5]
    [10,9,7,1,5,3,6,4,8,2]
     */

    public static void main(String[] args) {
        int maxHeap[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Heap heap = new Heap();
        heap.createHeap(maxHeap);
    }

    void createHeap(int maxHeap[]) {
        int size = maxHeap.length;
        for (int i = size / 2; i >= 0; i--) {
            heapify(i, maxHeap, size);
        }
    }

    void heapify(int index, int maxHeap[], int n) {
        if (index >= n)
            return;

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int nextIndex = leftChild;

        if (checkEdgeCase(leftChild, n) && maxHeap[index] < maxHeap[leftChild]) {
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[leftChild];
            maxHeap[leftChild] = temp;
            System.out.println();
        }

        if (checkEdgeCase(rightChild, n) && maxHeap[index] <= maxHeap[rightChild]) {
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[rightChild];
            maxHeap[rightChild] = temp;
            nextIndex = rightChild;
            System.out.println();
        }

        heapify(nextIndex, maxHeap, n);
    }

    private boolean checkEdgeCase(int index, int size) {
        return index < size;
    }
}