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
//        com.pulkit.DsAlgo.TreeNodee fifteen = new com.pulkit.DsAlgo.TreeNodee(15, null, null);
//        com.pulkit.DsAlgo.TreeNodee fourteen = new com.pulkit.DsAlgo.TreeNodee(14, null, null);
//        com.pulkit.DsAlgo.TreeNodee thirteen = new com.pulkit.DsAlgo.TreeNodee(13, null, null);
//        com.pulkit.DsAlgo.TreeNodee twelve = new com.pulkit.DsAlgo.TreeNodee(12, null, null);
//        com.pulkit.DsAlgo.TreeNodee eleven = new com.pulkit.DsAlgo.TreeNodee(11, null, null);
//        com.pulkit.DsAlgo.TreeNodee ten = new com.pulkit.DsAlgo.TreeNodee(10, null, null);
//        com.pulkit.DsAlgo.TreeNodee nine = new com.pulkit.DsAlgo.TreeNodee(9, null, null);
//        com.pulkit.DsAlgo.TreeNodee eight = new com.pulkit.DsAlgo.TreeNodee(8, null, null);
//        com.pulkit.DsAlgo.TreeNodee seven = new com.pulkit.DsAlgo.TreeNodee(7, fourteen, fifteen);
//        com.pulkit.DsAlgo.TreeNodee six = new com.pulkit.DsAlgo.TreeNodee(6, twelve, thirteen);
//        com.pulkit.DsAlgo.TreeNodee five = new com.pulkit.DsAlgo.TreeNodee(5, ten, eleven);
//        com.pulkit.DsAlgo.TreeNodee four = new com.pulkit.DsAlgo.TreeNodee(4, eight, nine);
//        com.pulkit.DsAlgo.TreeNodee three = new com.pulkit.DsAlgo.TreeNodee(3, six, seven);
//        com.pulkit.DsAlgo.TreeNodee two = new com.pulkit.DsAlgo.TreeNodee(2, four, five);
//        com.pulkit.DsAlgo.TreeNodee root = new com.pulkit.DsAlgo.TreeNodee(1, two, three);

//        com.pulkit.DsAlgo.TreeNodee three = new com.pulkit.DsAlgo.TreeNodee("3", null, null);
//        com.pulkit.DsAlgo.TreeNodee two = new com.pulkit.DsAlgo.TreeNodee("2", null, null);
//        com.pulkit.DsAlgo.TreeNodee root = new com.pulkit.DsAlgo.TreeNodee("1", two, three);

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

    TreeNodee(Integer data, TreeNodee leftChild, TreeNodee rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}