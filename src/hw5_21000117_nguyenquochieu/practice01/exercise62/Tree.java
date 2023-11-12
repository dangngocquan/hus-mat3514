package hw5_21000117_nguyenquochieu.practice01.exercise62;

public class Tree {
    class Node {
        private int data;
        private int height;
        private Node left;
        private Node right;

        public Node(int d) {
            data = d;
            height = 1;
        }
    }


    private Node root;

    private int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }


    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        Node temp = left.right;

        // Perform rotation
        left.right = node;
        node.left = temp;

        // Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        left.height = max(height(left.left), height(left.right)) + 1;

        // Return new root
        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node temp = right.left;

        // Perform rotation
        right.left = node;
        node.right = temp;

        // Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        right.height = max(height(right.left), height(right.right)) + 1;

        // Return new root
        return right;
    }

    private int balance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    private Node insert(Node node, int value) {

        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(value));

        if (value < node.data)
            node.left = insert(node.left, value);
        else if (value > node.data)
            node.right = insert(node.right, value);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
        int balance = balance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    private void inOrder(StringBuilder builder, Node node) {
        if (node != null) {
            inOrder(builder, node.left);
            builder.append(node.data).append(" ");
            inOrder(builder, node.right);
        }
    }

    public void add(int value) {
        this.root = insert(this.root, value);
    }

    public String inOrderTraversal() {
        StringBuilder builder = new StringBuilder();
        inOrder(builder, this.root);
        return builder.toString();
    }
}



