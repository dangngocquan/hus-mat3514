package hw5_21000117_nguyenquochieu.sessionA.practice3;

public class Tree {
    private int[] data;
    private Node root;

    class Node {
        private int element;
        private Node left;
        private Node right;

        public Node(int element) {
            this.element = element;
        }

        public Node(int element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public Tree(int[] data) {
        this.data = data;
        root = construct(0);
    }

    private Node construct(int index) {
        if (index < data.length) {
            Node node = new Node(data[index]);
            node.left = construct(2 * index + 1);
            node.right = construct(2 * index + 2);
            return node;
        } else return null;

    }

    private int countLeaves(Node node) {
        if (node == null) return 0;
        else {
            if (node.left == null && node.right == null) return 1;
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    public int getNumLeaves() {
        int numLeaves = countLeaves(root);
        return numLeaves;
    }

    private void printNode(StringBuilder builder, Node root, int space) {
        // Base case
        if (root != null) {
            // Increase distance between levels
            space += 10;

            // Process right child first
            printNode(builder, root.right, space);

            // Print current node after space
            // count
            builder.append("\n");
            for (int i = 10; i < space; i++)
                builder.append(" ");
            builder.append(root.element + "\n");

            // Process left child
            printNode(builder, root.left, space);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        printNode(builder, root, 10);
        return builder.toString();
    }
}
