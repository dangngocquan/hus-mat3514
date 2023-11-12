package hw5_22001273_nguyenhoangminh.luyentap1.exercise62;

import java.util.Scanner;

public class Tree {
    static Node root;

    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Complete tree creation from left to right
    public Node completeTree(int[] arr, int i) {
        Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);

            // insert left child
            root.left = completeTree(arr, 2 * i + 1);

            // insert right child
            root.right = completeTree(arr, 2 * i + 2);
        }
        return root;
    }

    // Print In-order
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void print(Node root, int space) {
        final int COUNT = 5;
        if (root == null) return;

        space += COUNT;
        print(root.right, space);

        System.out.println();

        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data);

        print(root.left, space);
    }

    public static void main(String args[]) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();

        System.out.print("Input elements: ");
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        tree.root = tree.completeTree(array, 0);
        tree.print(root, 0);
        tree.inOrder(tree.root);
    }
}
