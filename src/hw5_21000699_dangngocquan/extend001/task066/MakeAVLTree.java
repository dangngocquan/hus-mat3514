package hw5_21000699_dangngocquan.extend001.task066;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1311
public class MakeAVLTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        while (n-- > 0) {
            root = addNode(root, scanner.nextInt());
        }
        scanner.close();
        root = makeAVLTree(root);
        System.out.println(level(root));
    }

    public static boolean isAVLTree(Node root) {
        if (root == null) return true;
        if (Math.abs(level(root.left) - level(root.right)) > 1) return false;
        return isAVLTree(root.left) && isAVLTree(root.right);
    }

    public static Node makeAVLTree(Node node) {
        if (node == null) return null;
        while (!isAVLTree(node)) {
            int levelL = level(node.left);
            int levelR = level(node.right);
            if (levelL - levelR > 1) {
                int levelLL = level(node.left.left);
                int levelLR = level(node.left.right);
                if (levelLR > levelLL) {
                    node.left = turnLeft(node.left);
                }
                node = turnRight(node);
            } else if (levelR - levelL > 1) {
                int levelRL = level(node.right.left);
                int levelRR = level(node.right.right);
                if (levelRL > levelRR) {
                    node.right = turnRight(node.right);
                }
                node = turnLeft(node);
            } else {
                node.left = makeAVLTree(node.left);
                node.right = makeAVLTree(node.right);
            }
        }
        return node;
    }

    public static Node turnLeft(Node node) {
        if (node == null) return null;
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }

    public static Node turnRight(Node node) {
        if (node == null) return null;
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }

    public static int level(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(level(node.left), level(node.right));
    }

    public static Node addNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data < node.data) {
            node.left = addNode(node.left, data);
        } else {
            node.right = addNode(node.right, data);
        }
        return node;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
