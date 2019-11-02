public class MergeSort {

    public static void main(String[] args) {
        int a[] = {10, 1, 2, 3, 48, 62, 65, 32, 5, 4};
        MergeSort mergeSort = new MergeSort();
        a = mergeSort.sort(0, a.length, a);
    }

    private int[] merge(int a[], int b[]) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        int length1 = a.length;
        int length2 = b.length;
        if (length1 == 0)
            return b;
        if (length2 == 0)
            return a;

        int sortedArray[] = new int[length1 + length2];

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while (index1 < length1 && index2 < length2) {
            if (a[index1] >= b[index2]) {
                sortedArray[index3] = a[index1];
                index1++;
            } else {
                sortedArray[index3] = b[index2];
                index2++;

            }
            index3++;
        }

        if (index1 == length1) {
            while (index2 < length2) {
                sortedArray[index3] = b[index2];
                index2++;
                index3++;
            }
        } else {
            while (index1 < length1) {
                sortedArray[index3] = a[index1];
                index1++;
                index3++;
            }
        }
        return sortedArray;
    }

    private int[] sort(int low, int high, int a[]) {
        if (low < high) {
            int mid = (low + high) / 2;
            int[] firstSorted = sort(low, mid, a);
            int[] secondSorted = sort(mid + 1, high, a);

            return merge(firstSorted, secondSorted);
        }

        if (low < a.length && low == high) {
            return new int[]{a[low]};
        }

        return null;
    }
}