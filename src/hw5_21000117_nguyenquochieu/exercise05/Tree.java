package hw5_21000117_nguyenquochieu.exercise05;

public class Tree {
    private int[] data;
    private Node root;

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
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
    public static int getHeight(Node root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
    public Node getRoot() {
        return root;
    }

//    private void printNode(StringBuilder builder, Node root, int space) {
//        // Base case
//        if (root != null) {
//            // Increase distance between levels
//            space += 10;
//
//            // Process right child first
//            printNode(builder, root.right, space);
//
//            // Print current node after space
//            // count
//            builder.append("\n");
//            for (int i = 10; i < space; i++)
//                builder.append(" ");
//            builder.append(root.data + "\n");
//
//            // Process left child
//            printNode(builder, root.left, space);
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        printNode(builder, root, 10);
//        return builder.toString();
//    }
}
