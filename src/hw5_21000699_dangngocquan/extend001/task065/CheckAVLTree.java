package hw5_21000699_dangngocquan.extend001.task065;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1310
public class CheckAVLTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        while (n-- > 0) {
            root = addNode(root, scanner.nextInt());
        }
        scanner.close();
        assert root != null;
        System.out.println(isAVLTree(root));
    }

    public static boolean isAVLTree(Node root) {
        if (root == null) return true;
        if (Math.abs(level(root.left) - level(root.right)) > 1) return false;
        return isAVLTree(root.left) && isAVLTree(root.right);
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
