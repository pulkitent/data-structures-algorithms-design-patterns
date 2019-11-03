public class ConvertBinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {
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

        convertBTToDLL(root);

        TreeNode ptr = eight;

        while (ptr != null) {
            System.out.print(" " + ptr.data);
            ptr = ptr.rightChild;
        }
    }

    private static void convertBTToDLL(TreeNode root) {
        //Base case
        if (root == null)
            return;

        //Convert left subtree
        if (root.leftChild != null)
            convertBTToDLL(root.leftChild);

        //Convert right subtree
        if (root.rightChild != null)
            convertBTToDLL(root.rightChild);

        TreeNode pointerForLeftSubList = root.leftChild;

        //Go rightwise down till leaf node
        while (pointerForLeftSubList != null
                && pointerForLeftSubList.leftChild != null
                && pointerForLeftSubList.rightChild != null) {
            pointerForLeftSubList = pointerForLeftSubList.rightChild;
        }

        if (pointerForLeftSubList != null) {
            pointerForLeftSubList.rightChild = root;
            root.leftChild = pointerForLeftSubList;
        }

        TreeNode pointerForRightSubList = root.rightChild;

        //Go leftwise down till leaf node
        while (pointerForRightSubList != null
                && pointerForRightSubList.leftChild != null
                && pointerForRightSubList.rightChild != null) {
            pointerForRightSubList = pointerForRightSubList.leftChild;
        }

        if (pointerForRightSubList != null) {
            pointerForRightSubList.leftChild = root;
            root.rightChild = pointerForRightSubList;
        }
    }
}