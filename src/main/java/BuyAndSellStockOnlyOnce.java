public class BuyAndSellStockOnlyOnce {
    public static void main(String[] args) {
        //Expected 7 (buy at 5 index and sell at 8 index)
        int a[] = {12, 11, 13, 9, 12, 8, 14, 13, 15}; //12 -1 2 -4 3 -4 6 -1 2 // a,b-a,c-b,d-c,e-d

        //Another Test case
        //Expected 9 (buy at 0 index and sell at 1 index)
        //int a[] = {2, 11, 1, 4, 7};

        //Another Test case
        //Expected 0
        //int a[] = {21, 11, 9, 8, 7};

        System.out.println(calculate(a));
    }

    private static int calculate(int a[]) {
        for (int index = a.length - 1; index > 0; index--) {
            a[index] = a[index] - a[index - 1];
        }

        return findMaxSumSubarray(a);
    }

    private static int findMaxSumSubarray(int a[]) {
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int index = 1; index < a.length; index++) {
            currentSum = currentSum + a[index];

            if (currentSum < 0) {
                currentSum = 0;
            }

            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }

    private static int programCreek(int a[]) {
        if (a == null || a.length <= 1)
            return 0;

        int min = a[0]; // min so far
        int result = 0;

        for (int i = 1; i < a.length; i++) {
            result = Math.max(result, a[i] - min);
            min = Math.min(min, a[i]);
        }

        return result;
    }
}