import java.util.LinkedList;

public class LevelOrderTraversalOfTree {
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

        printLevelOrderTraversal(root);
    }

    static void printLevelOrderTraversal(TreeNode node) {
        if (node == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            TreeNode peek = queue.getFirst();
            if (peek != null) {
                System.out.print(" " + peek.data);
                queue.addLast(peek.leftChild);
                queue.addLast(peek.rightChild);
            }
            queue.removeFirst();
        }
    }
}