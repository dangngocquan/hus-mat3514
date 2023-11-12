package hw5_21000117_nguyenquochieu.practice01.exercise63;

public class BinaryTree {
    private int[] data;
    private Node root;
    private int numLeaves = 0;
    public BinaryTree(int[] data) {
        this.data = data;
    }

    class Node {
        private int element;
        private int height = 1;
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
        public int getElement() {
            return element;
        }
        private int max(int a, int b) {
            if (a >= b) return a;
            else return b;
        }

        public static int getHeight(Node node) {
            if (node == null) return 0;
            return node.height;
        }

        private void increaseHeight() {
            this.height = max(getHeight(left), getHeight(right)) + 1;
        }
        public static int getBalance(Node node) {
            if (node == null) return 0;
            return getHeight(node.left) - getHeight(node.right);
        }
    }


    private Node insert(Node node, int element) {
        if (node == null) {
            return new Node(element);
        } else {
            if (element < node.element) node.left = insert(node.left, element);
            else node.right = insert(node.right, element);
            return node;
        }
    }
    public Node construct() {
        for (int i = 0; i < data.length;i++)
            root = insert(root, data[i]);
        return root;
    }
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }




}
