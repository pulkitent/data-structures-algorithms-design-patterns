package com.pulkit.datastructures_algorithms.todo;/*

Test case
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

expected output - 1248 + 1249 + 12510 + 12511 + 13612 + 13613 + 13714 + 13715 =

*/

/*

Another Test case
           1
         2   3

expected output - 25

*/

/*

Another Test case
           1
        2     3
      4   5 6   7

expected output - 124 + 125 + 136 + 137 = 522

*/

import java.util.HashSet;
import java.util.Set;

public class SumRootToLeafNumbers {
    static Set<String> map = new HashSet<>();

    public static void main(String[] args) {
//        TreeNodee fifteen = new TreeNodee(15, null, null);
//        TreeNodee fourteen = new TreeNodee(14, null, null);
//        TreeNodee thirteen = new TreeNodee(13, null, null);
//        TreeNodee twelve = new TreeNodee(12, null, null);
//        TreeNodee eleven = new TreeNodee(11, null, null);
//        TreeNodee ten = new TreeNodee(10, null, null);
//        TreeNodee nine = new TreeNodee(9, null, null);
//        TreeNodee eight = new TreeNodee(8, null, null);
//        TreeNodee seven = new TreeNodee(7, fourteen, fifteen);
//        TreeNodee six = new TreeNodee(6, twelve, thirteen);
//        TreeNodee five = new TreeNodee(5, ten, eleven);
//        TreeNodee four = new TreeNodee(4, eight, nine);
//        TreeNodee three = new TreeNodee(3, six, seven);
//        TreeNodee two = new TreeNodee(2, four, five);
//        TreeNodee root = new TreeNodee(1, two, three);
//        TreeNodee three = new TreeNodee("3", null, null);
//        TreeNodee two = new TreeNodee("2", null, null);
//        TreeNodee root = new TreeNodee("1", two, three);

        TreeNodee seven = new TreeNodee(7, null, null);
        TreeNodee six = new TreeNodee(6, null, null);
        TreeNodee five = new TreeNodee(5, null, null);
        TreeNodee four = new TreeNodee(4, null, null);
        TreeNodee three = new TreeNodee(3, six, seven);
        TreeNodee two = new TreeNodee(2, four, five);
        TreeNodee root = new TreeNodee(1, two, three);

        System.out.println(calculate(root, root));
    }


    private static Integer calculate(TreeNodee node, TreeNodee root) {
        if (node == null) {
            return 0;
        }

        if (node.leftChild == null && node.rightChild == null)
            return node.data;

        Integer leftSubtreeAppendedDigits = calculate(node.leftChild, node);
        Integer rightSubtreeAppendedDigits = calculate(node.rightChild, node);

        String leftSubtreeAppendedDigitsWithCurrentDigit =
                node.data.toString() + leftSubtreeAppendedDigits.toString();

        String rightSubtreeAppendedDigitsWithCurrentDigit =
                node.data.toString() + rightSubtreeAppendedDigits.toString();

        if (node == root) {
            return Integer.parseInt(leftSubtreeAppendedDigitsWithCurrentDigit)
                    + Integer.parseInt(rightSubtreeAppendedDigitsWithCurrentDigit);
        }

        //TODO: To be removed, Just added for compilation of project
        return 0;
    }
}


class TreeNodee {
    Integer data;

    TreeNodee leftChild;
    TreeNodee rightChild;

    public TreeNodee(Integer data, TreeNodee leftChild, TreeNodee rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}