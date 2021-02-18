package com.mckinsey.engage.risk.services;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeaf {
    public void main(String[] args) {
        TreeNode tree = new TreeNode();
        List<String> allNumbersInString = convertRootToLeadDigitsIntoNumber(tree);
        int sum = 0;
        for (String number : allNumbersInString) {
            sum = sum + Integer.parseInt(number);
        }
    }

    public int sumNumbers(TreeNode root) {
        List<String> allNumbersInString = convertRootToLeadDigitsIntoNumber(root);
        int sum = 0;
        for (String number : allNumbersInString) {
            sum = sum + Integer.parseInt(number);
        }

        return sum;
    }

    List<String> convertRootToLeadDigitsIntoNumber(TreeNode root) {
        if (root == null)
            return new LinkedList<>();

        if (root.left == null && root.right == null) {
            LinkedList<String> list = new LinkedList<>();
            list.add(root.val + "");
            return list;
        }

        List<String> rightSubtreeIntegers = convertRootToLeadDigitsIntoNumber(root.left);
        List<String> leftSubtreeIntegers = convertRootToLeadDigitsIntoNumber(root.right);

        List<String> rootList = new LinkedList<>();

        for (String number : rightSubtreeIntegers) {
            rootList.add(root.val + number);
        }

        for (String number : leftSubtreeIntegers) {
            rootList.add(root.val + number);
        }

        return rootList;
    }

    Integer convertRootToLeadDigitsIntoNumber2nd(int sum, TreeNode root, int level) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            sum = root.val;
            return sum;
        }

        int sumTillNow = (int) ((sum * Math.pow(10, level)) + root.val);

        Integer rightSubtreeSum = convertRootToLeadDigitsIntoNumber2nd(sumTillNow, root.left, level + 1);
        Integer leftSubtreeSum = convertRootToLeadDigitsIntoNumber2nd(sumTillNow, root.right, level + 1);

        return rightSubtreeSum + leftSubtreeSum;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
