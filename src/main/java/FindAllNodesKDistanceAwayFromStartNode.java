import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Tree example
/*

               1

      2                 3

   4       5        6         7

 8   9  10   11  12    13  14    15

 */

public class FindAllNodesKDistanceAwayFromStartNode {
    static Map<TreeNode, TreeNode> childToParent = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = createTreeAndChildToParentMap();

        doBFSForParentNodes(root, 2, childToParent);
    }

    private static void doBFSForParentNodes(TreeNode node, int level,
                                            Map<TreeNode, TreeNode> childToParent) {
        if (node == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        node.isVisited = true;

        while (!queue.isEmpty()) {

            TreeNode currentNode = queue.pop();

            if (currentNode != null && currentNode.leftChild != null
                    && !currentNode.leftChild.isVisited) {

                queue.add(currentNode.leftChild);

                currentNode.leftChild.isVisited = true;
                currentNode.leftChild.level = currentNode.level + 1;
            }

            if (currentNode != null && currentNode.rightChild != null
                    && !currentNode.rightChild.isVisited) {

                queue.add(currentNode.rightChild);

                currentNode.rightChild.isVisited = true;
                currentNode.rightChild.level = currentNode.level + 1;
            }

            TreeNode parentOfCurrentNode = childToParent.get(currentNode);

            if (currentNode != null && parentOfCurrentNode != null
                    && !parentOfCurrentNode.isVisited) {

                queue.add(parentOfCurrentNode);

                parentOfCurrentNode.isVisited = true;
                parentOfCurrentNode.level = currentNode.level + 1;
            }

            if (currentNode != null && currentNode.level + 1 == level) {
                if (currentNode.leftChild != null) {
                    System.out.println(currentNode.leftChild.data);
                }

                if (currentNode.rightChild != null) {
                    System.out.println(currentNode.rightChild.data);
                }

                if (parentOfCurrentNode != null) {
                    System.out.println(parentOfCurrentNode.data);
                }
            }
        }
    }

    private static TreeNode createTreeAndChildToParentMap() {
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

        childToParent.put(two, root);
        childToParent.put(three, root);

        childToParent.put(four, two);
        childToParent.put(five, two);

        childToParent.put(six, three);
        childToParent.put(seven, three);

        childToParent.put(eight, four);
        childToParent.put(nine, four);

        childToParent.put(ten, five);
        childToParent.put(eleven, five);

        childToParent.put(twelve, six);
        childToParent.put(thirteen, six);

        childToParent.put(fourteen, seven);
        childToParent.put(fifteen, seven);

        return root;
    }

    private static void doDFSForChildNodes(TreeNode node, int level, int currentLevel) {
        if (node == null)
            return;

        if (currentLevel == level) {
            System.out.println(node.data);
        }

        doDFSForChildNodes(node.leftChild, level, currentLevel + 1);
        doDFSForChildNodes(node.rightChild, level, currentLevel + 1);
    }
}

class TreeNode {
    int data;
    int level = 0;
    TreeNode leftChild;
    TreeNode rightChild;

    boolean isVisited = false;

    TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}