package com.pulkit.datastructures_algorithms.done.stacks;

import java.util.Stack;

public class ReverseAStackWithoutUsingAnotherStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        reverseStack(stack);
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int top = stack.pop();
        reverseStack(stack);
        reverseStackUtil(stack, top);
    }

    static void reverseStackUtil(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        reverseStackUtil(stack, element);
        stack.push(top);
    }
}