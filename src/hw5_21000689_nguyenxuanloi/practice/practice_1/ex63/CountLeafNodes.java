package hw5_21000689_nguyenxuanloi.practice.practice_1.ex63;

import hw5_21000689_nguyenxuanloi.practice.practice_1.LinkedBinaryTree;

import java.util.Scanner;

public class CountLeafNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = anyInput(sc);
        sc.close();

        LinkedBinaryTree tree = createTree(values);
        System.out.println(tree.numLeafNodes(tree.root()));
    }

    static int[] stdInput(Scanner sc, int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        return values;
    }
    static int[] anyInput(Scanner sc) {
        sc.nextLine();
        String[] valuesInString = sc.nextLine().split("\\D+");
        int[] values = new int[valuesInString.length];
        for (int i = 0; i < valuesInString.length; i++) {
            values[i] = Integer.parseInt(valuesInString[i]);
        }
        return values;
    }

    static LinkedBinaryTree createTree(int... values) {
        LinkedBinaryTree tree = new LinkedBinaryTree();

        for (int number: values) {
            tree.setRoot(tree.insert(tree.root(), number)); // input values
        }

        return tree;
    }
}
