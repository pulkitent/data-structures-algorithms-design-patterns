package com.mckinsey.engage.risk.services.warning;

public class Heap {
    public void main(String[] args) {
        int[] array = new int[];

        int n = array.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    /*

      6
   5      3
 4   2  1

     */

    void maxHeapify(int array[], int index) {
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;

        if (lc >= array.length || rc > array.length)
            return;

        boolean isLcGreater = false;
        boolean isRcGreater = false;

        if (array[index] < array[lc]) {
            int temp = array[index];
            array[index] = array[lc];
            array[lc] = temp;
            isLcGreater = true;
        } else if (array[index] < array[rc]) {
            int temp = array[index];
            array[index] = array[rc];
            array[rc] = temp;
            isRcGreater = true;
        }

        if (isLcGreater)
            maxHeapify(array, lc);

        if (isRcGreater)
            maxHeapify(array, rc);
    }
}
