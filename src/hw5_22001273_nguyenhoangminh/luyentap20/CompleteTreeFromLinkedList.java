package hw5_22001273_nguyenhoangminh.luyentap20;

import java.util.LinkedList;
import java.util.Scanner;

public class CompleteTreeFromLinkedList {
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
    public Node completeTree(LinkedList<Integer> list, int index) {
        Node root = null;

        // Base case for recursion
        if (index < list.size()) {
            root = new Node(list.get(index));

            // insert left child
            root.left = completeTree(list, 2 * index + 1);

            // insert right child
            root.right = completeTree(list, 2 * index + 2);
        }
        return root;
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
        LinkedList<Integer> list = new LinkedList<>();
        CompleteTreeFromLinkedList tree = new CompleteTreeFromLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();

        System.out.print("Input elements: ");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        tree.root = tree.completeTree(list, 0);
        tree.print(root, 0);
    }
}
