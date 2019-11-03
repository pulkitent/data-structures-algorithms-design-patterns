import java.util.LinkedList;
import java.util.Queue;

//TODO: To be fixed
public class ConnectNodesAtSameLevel {
    private final static TreeNodeWithExtraPointer DELIMITTER = new TreeNodeWithExtraPointer();

    public static void main(String[] args) {
        TreeNodeWithExtraPointer fifteen = new TreeNodeWithExtraPointer(15, null, null);
        TreeNodeWithExtraPointer fourteen = new TreeNodeWithExtraPointer(14, null, null);
        TreeNodeWithExtraPointer thirteen = new TreeNodeWithExtraPointer(13, null, null);
        TreeNodeWithExtraPointer twelve = new TreeNodeWithExtraPointer(12, null, null);
        TreeNodeWithExtraPointer eleven = new TreeNodeWithExtraPointer(11, null, null);
        TreeNodeWithExtraPointer ten = new TreeNodeWithExtraPointer(10, null, null);
        TreeNodeWithExtraPointer nine = new TreeNodeWithExtraPointer(9, null, null);
        TreeNodeWithExtraPointer eight = new TreeNodeWithExtraPointer(8, null, null);
        TreeNodeWithExtraPointer seven = new TreeNodeWithExtraPointer(7, fourteen, fifteen);
        TreeNodeWithExtraPointer six = new TreeNodeWithExtraPointer(6, twelve, thirteen);
        TreeNodeWithExtraPointer five = new TreeNodeWithExtraPointer(5, ten, eleven);
        TreeNodeWithExtraPointer four = new TreeNodeWithExtraPointer(4, eight, nine);
        TreeNodeWithExtraPointer three = new TreeNodeWithExtraPointer(3, six, seven);
        TreeNodeWithExtraPointer two = new TreeNodeWithExtraPointer(2, four, five);
        TreeNodeWithExtraPointer root = new TreeNodeWithExtraPointer(1, two, three);

        connect(root);
    }

    static void connect(TreeNodeWithExtraPointer node) {
        if (node == null)
            return;

        Queue<TreeNodeWithExtraPointer> queue = new LinkedList<>();
        queue.add(node);
        queue.add(DELIMITTER);

        while (!queue.isEmpty()) {
            TreeNodeWithExtraPointer peek = queue.remove();
            TreeNodeWithExtraPointer nextPeek = queue.peek();

            peek.sameLevelSibling = nextPeek;

            if (peek.leftChild != null) {
                queue.add(peek.leftChild);
            }

            if (peek.rightChild != null) {
                queue.add(peek.rightChild);
            }
            queue.add(DELIMITTER);
        }
    }
}

class TreeNodeWithExtraPointer {
    public int data;
    public TreeNodeWithExtraPointer leftChild;
    public TreeNodeWithExtraPointer rightChild;
    public TreeNodeWithExtraPointer sameLevelSibling;

    TreeNodeWithExtraPointer(int data, TreeNodeWithExtraPointer leftChild,
                             TreeNodeWithExtraPointer rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    TreeNodeWithExtraPointer() {
    }
}