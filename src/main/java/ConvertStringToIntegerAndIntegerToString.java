public class ConvertStringToIntegerAndIntegerToString {
    public static void main(String[] args) {
        //Another Test case
        //String a = "12345";

        //Another Test case
        //String a = "423";
        String a = "0";
        System.out.println(aToI(a));

        Integer i = 123;

        //Another Test case
        //Integer i = 0;

        System.out.println(iToA(i));
    }

    private static int aToI(String a) {
        int size = a.length();
        Character[] charArray = new Character[size];

        int result = 0;
        int power = 0;

        for (int index = 0; index < size; index++) {
            charArray[index] = a.charAt(index);
        }

        for (int index = size - 1; index >= 0; index--) {
            result = result + (charArray[index] - '0') * (int) Math.pow(10, power);
            power++;
        }

        return result;
    }

    private static StringBuilder iToA(int a) {
        StringBuilder result = new StringBuilder("");

        while (a / 10 != 0) {
            int quotient = a / 10;
            result.append(quotient);
            a = a % 10;
        }

        return result.append(a);
    }
}