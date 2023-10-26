package hw5_21000699_dangngocquan.extend001.task068;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1313
public class RemoveTreeNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        while (n-- > 0) {
            root = addNode(root, scanner.nextInt());
        }
        int x = scanner.nextInt();
        scanner.close();
        root = removeElement(root, x);
        if (root == null) {
            System.out.println("NULL");
        } else {
            printInOrder(root);
        }

    }

    public static Node removeElement(Node node, int x) {
        if (node == null) return null;
        if (node.data == x) return null;
        node.left = removeElement(node.left, x);
        node.right = removeElement(node.right, x);
        return node;
    }

    public static void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
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
