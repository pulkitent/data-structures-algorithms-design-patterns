package com.pulkit.datastructures_algorithms.done.stacks;

public class NStackUsingArray {
    public static void main(String[] args) {
        //TODO: Need to add usage example
    }

    private class MultiStack {
        private int[] stackArray;
        private int[] stacksHead;
        private int[] stacksStarting;

        MultiStack(int numberOfStacks, int sizeOfEachSack) {
            stackArray = new int[numberOfStacks * sizeOfEachSack];
            stacksHead = new int[numberOfStacks];
            stacksStarting = new int[numberOfStacks];

            for (int index = 0; index < numberOfStacks; index++) {
                stacksHead[index] = index * sizeOfEachSack;
                stacksStarting[index] = index * sizeOfEachSack;
            }
        }

        //TODO: Need to handle some edge cases also
        //TODO: Also handle case for last stack is full and first stack is empty ie rolling push
        void push(int currentStackNumber, int element) {
            int nextStackNumber = currentStackNumber + 1;

            if (isCurrentStackNotFull(currentStackNumber)) {
                pushElement(currentStackNumber, element);
                return;
            }

            if (isNextStackEmpty(nextStackNumber)) {
                stacksHead[nextStackNumber]++;
                stacksStarting[nextStackNumber]++;
                pushElement(currentStackNumber, element);
                return;
            }

            expandStack(nextStackNumber);
            pushElement(currentStackNumber, element);
        }

        //TODO: Need to implement pop correctly
        Integer pop(int stackNumber) {
            stacksHead[stackNumber]--;
            return stackArray[stacksHead[stackNumber]];
        }

        private void pushElement(int currentStackNumber, int element) {
            int currentStackHead = stacksHead[currentStackNumber];
            stackArray[currentStackHead] = element;
            stacksHead[currentStackNumber]++;
        }

        private void expandStack(int currentStackNumber) throws RuntimeException {
            int totalStacks = stacksHead.length;

            if (currentStackNumber > totalStacks) {
                throw new RuntimeException("All Stacks are full");
            }

            if (isCurrentStackNotFull(currentStackNumber)) {
                shiftCurrentStackElements(currentStackNumber);
                return;
            }

            int nextStackNumber = currentStackNumber + 1;

            expandStack(nextStackNumber);
            shiftCurrentStackElements(currentStackNumber);
        }

        private void shiftCurrentStackElements(int currentStackNumber) {
            int currentStackStart = stacksStarting[currentStackNumber];
            int currentStackHead = stacksHead[currentStackNumber];

            int tempIndex = currentStackHead + 1;
            while (tempIndex > currentStackStart) {
                stackArray[tempIndex] = stackArray[tempIndex - 1];
                tempIndex--;
            }
            stacksHead[currentStackNumber]++;
            stacksStarting[currentStackNumber]++;
        }

        private boolean isNextStackEmpty(int nextStackNumber) {
            return stacksHead[nextStackNumber] == stacksStarting[nextStackNumber];
        }

        private boolean isCurrentStackNotFull(int currentStackNumber) {
            int nextStackNumber = currentStackNumber + 1;
            int currentStackHead = stacksHead[currentStackNumber];
            int nextStackStarting = stacksStarting[nextStackNumber];

            return currentStackHead + 1 < nextStackStarting;
        }
    }
}
