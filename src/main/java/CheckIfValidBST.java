public class CheckIfValidBST {
    public static void main(String[] args) {
        TreeNode root = createBST();
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode node) {
        if (node == null)
            return true;

        if (node.leftChild == null && node.rightChild == null)
            return true;

        Integer minInRightSubtree = findMin(node.rightChild);
        Integer maxInLeftSubtree = findMax(node.leftChild);

        if (node.data >= minInRightSubtree && node.data <= maxInLeftSubtree) {
            return false;
        }

        return isValidBST(node.leftChild) && isValidBST(node.rightChild);
    }

    private static Integer findMin(TreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;

        if (node.leftChild == null && node.rightChild == null)
            return node.data;

        Integer minInLeftSubtree = findMin(node.leftChild);
        Integer minInRightSubtree = findMin(node.rightChild);

        return Math.min(node.data, Math.min(minInLeftSubtree, minInRightSubtree));
    }

    private static Integer findMax(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        if (node.leftChild == null && node.rightChild == null)
            return node.data;

        Integer maxInLeftSubtree = findMax(node.leftChild);
        Integer maxInRightSubtree = findMax(node.rightChild);

        return Math.max(node.data, Math.max(maxInLeftSubtree, maxInRightSubtree));
    }

    public static TreeNode createBST() {
        TreeNode fourteen = new TreeNode(14, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode one = new TreeNode(1, null, null);

        TreeNode ten = new TreeNode(10, null, fourteen);
        TreeNode three = new TreeNode(3, one, six);

        TreeNode root = new TreeNode(8, three, ten);

        return root;
    }
}
