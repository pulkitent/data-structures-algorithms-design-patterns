public class CountInversions {
    //TODO: To be optimized
    //In case of Decreasing Order Sorted Array, Complexity will be O(n^2)
    public static void main(String[] args) {
        //Expected Output - 3
        int[] inputArray1 = {2, 4, 1, 3, 5};
        System.out.println(count(inputArray1));

        //Expected Output - 6
        int[] inputArray2 = {8, 4, 2, 1};
        System.out.println(count(inputArray2));

        //Expected Output - 1
        int[] inputArray3 = {8, 4};
        System.out.println(count(inputArray3));
    }

    private static ResultCount count(int array[]) {
        ModifiedTreeNode root = new ModifiedTreeNode();
        root.data = array[0];
        ResultCount count = new ResultCount();

        for (int index = 1; index < array.length; index++) {
            modifiedBinarySearchTreeInsertion(array[index], root, count);
        }

        return count;
    }

    private static void modifiedBinarySearchTreeInsertion(int inputData, ModifiedTreeNode root, ResultCount count) {
        if (root == null)
            return;

        if (root.data > inputData) {
            count.data = count.data + root.numberOfNodeInRightSubtree + 1;
            if (root.rightChild != null) {
                modifiedBinarySearchTreeInsertion(inputData, root.rightChild, count);
            } else {
                ModifiedTreeNode modifiedTreeNode = new ModifiedTreeNode();
                modifiedTreeNode.data = inputData;
                root.rightChild = modifiedTreeNode;
            }
        }

        if (root.data < inputData) {
            root.numberOfNodeInRightSubtree++;
            if (root.leftChild != null) {
                modifiedBinarySearchTreeInsertion(inputData, root.leftChild, count);
            } else {
                ModifiedTreeNode modifiedTreeNode = new ModifiedTreeNode();
                modifiedTreeNode.data = inputData;
                root.leftChild = modifiedTreeNode;
            }
        }
    }
}

class ResultCount {
    int data;

    public ResultCount() {
    }

    @Override
    public String toString() {
        return "data = " + data;
    }
}

class ModifiedTreeNode {
    int data;
    int numberOfNodeInRightSubtree;
    ModifiedTreeNode leftChild;
    ModifiedTreeNode rightChild;

    public ModifiedTreeNode(int data, int numberOfNodeInRightSubtree, ModifiedTreeNode leftChild,
                            ModifiedTreeNode rightChild) {
        this.data = data;
        this.numberOfNodeInRightSubtree = numberOfNodeInRightSubtree;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public ModifiedTreeNode() {
    }
}