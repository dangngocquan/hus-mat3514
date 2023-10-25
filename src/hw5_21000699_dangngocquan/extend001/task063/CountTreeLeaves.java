package hw5_21000699_dangngocquan.extend001.task063;

import java.util.Scanner;

// Link: https://codelearn.io/learning/data-structure-and-algorithms?activityType=12&activityId=1308
public class CountTreeLeaves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        while (n-- > 0) {
            root = addNode(root, scanner.nextInt());
        }
        System.out.println(countLeaves(root));
    }

    public static  int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
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
