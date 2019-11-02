public class DuplicateInArray {
    public static void main(String[] args) {
        //Another Test case
        //int[] array = {1, 2, 3, 4, 5, 6, 6, 6, 7, 2};

        //Another Test case
        //int[] array = {2,1,2,1};

        int[] array = {5, 2, 1, 4, 3, 6, 5};

        printDuplicates(array);
        printDuplicatesWithFrequency(array);
    }

    private static void printDuplicatesWithFrequency(int[] array) {
        for (int index = 0; index < array.length; index++) {
            array[array[index] % 1000] = array[array[index] % 1000] + 1000;
        }

        for (int index = 0; index < array.length; index++) {
            System.out.println(index + "-> " + array[index] / 1000);
        }
    }


    private static void printDuplicates(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[Math.abs(array[index])] < 0) {
                System.out.println(Math.abs(array[index]));
            }
            array[Math.abs(array[index])] = Math.negateExact(array[Math.abs(array[index])]);
        }
    }
}
