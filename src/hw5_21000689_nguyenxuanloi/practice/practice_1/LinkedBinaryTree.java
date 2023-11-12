package hw5_21000689_nguyenxuanloi.practice.practice_1;

public class LinkedBinaryTree {
    private Node root = null;
    private int size = 0;

    public Node root() {
        return root;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insert(Node p, int value) {
        if (p == null) {
            p = new Node(value, null, null);
            size++;
        } else {
            if (p.value > value) {
                p.setLeft(insert(p.getLeft(), value));
            } else {
                p.setRight(insert(p.getRight(), value));
            }
        }
        return p;
    }

    public int numLeafNodes(Node root) {
        if (root == null) {
            return 0;
        } else if (isLeafNode(root)) {
            return 1;
        } else {
            return numLeafNodes(root.getLeft()) + numLeafNodes(root.getRight());
        }
    }

    boolean isLeafNode(Node p) {
        return p.getLeft() == null && p.getRight() == null;
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }
}
