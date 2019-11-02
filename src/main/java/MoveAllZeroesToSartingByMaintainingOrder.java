public class MoveAllZeroesToSartingByMaintainingOrder {
    public static void main(String[] args) {
        //Another Test case
        //int[] a = {1, 2, 0, 0, 0, 3, 4, 0, 5, 0};

        int[] a = {2, 3, 5, 0, 7, 11, 0, 0, 13};
        calculate(a);
    }

    private static void calculate(int arr[]) {
        int max = arr.length;
        int i;
        int j;

        for (i = 0, j = 0; j < max; j++) {
            if (arr[j] != 0) {
                if (i < j) {
                    swap(arr, i, j);
                }
                i++;
            }

            for (Integer kk : arr) {
                System.out.print(kk + " ");
            }
            System.out.print("<------->i at " + i + " " + "j at " + j);
            System.out.println("");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}