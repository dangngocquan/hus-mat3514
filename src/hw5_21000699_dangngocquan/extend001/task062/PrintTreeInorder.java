package hw5_21000699_dangngocquan.extend001.task062;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1307
public class PrintTreeInorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = addNode(root, scanner.nextInt());
        }
        scanner.close();
        showTree(root);
    }

    public static void showTree(Node node) {
        if (node == null) return;
        showTree(node.left);
        System.out.print(node.data + " ");
        showTree(node.right);
    }

    public static Node addNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data <= node.data) {
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
