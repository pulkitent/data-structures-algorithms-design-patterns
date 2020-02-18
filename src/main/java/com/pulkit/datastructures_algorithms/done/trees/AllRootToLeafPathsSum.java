package com.pulkit.datastructures_algorithms.done.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Test case
           1
    2             3
 4     5      6      7
8 9  10 11  12 13  14 15

expected output for for 23 : 1->3->6->13


Another test case

           1
    3             5
  6            4      10
13 9         12 13   14 7

expected output for for 23 : 1->3->6->13, 1->5->4->13, 1->5->10->7
*/

//TODO: Output in coming but showing every list twice, so needs to be fixed
public class AllRootToLeafPathsSum {
    private static List<List<TreeNode>> paths = new LinkedList<>();
    private static Stack<TreeNode> path = new Stack();

    public static void main(String[] args) {

        /* First test case data

        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode thirteen = new TreeNode(13, null, null);
        TreeNode twelve = new TreeNode(12, null, null);
        TreeNode eleven = new TreeNode(11, null, null);
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, fourteen, fifteen);
        TreeNode six = new TreeNode(6, twelve, thirteen);
        TreeNode five = new TreeNode(5, ten, eleven);
        TreeNode four = new TreeNode(4, eight, nine);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode root = new TreeNode(1, two, three);
        */

        //Another test case data
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode twelve = new TreeNode(12, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode thirteen = new TreeNode(13, null, null);
        TreeNode ten = new TreeNode(10, fourteen, seven);
        TreeNode four = new TreeNode(4, twelve, thirteen);
        TreeNode six = new TreeNode(6, thirteen, nine);
        TreeNode five = new TreeNode(5, four, ten);
        TreeNode three = new TreeNode(3, six, null);
        TreeNode root = new TreeNode(1, three, five);

        findPaths(root, 0, 23);

        for (List currentPath : paths) {
            for (Object node : currentPath) {
                System.out.print(((TreeNode) node).data + " ");
            }
            System.out.println();
        }
    }

    private static void findPaths(TreeNode node, int currentSum, int expectedSum) {
        if (currentSum > expectedSum)
            return;

        if (node == null && currentSum == expectedSum) {
            List temporaryPath = new LinkedList();

            temporaryPath.addAll(path);
            paths.add(temporaryPath);
        }

        if (node == null)
            return;

        path.push(node);

        findPaths(node.leftChild, currentSum + node.data, expectedSum);
        findPaths(node.rightChild, currentSum + node.data, expectedSum);

        if (!path.isEmpty())
            path.pop();
    }
}