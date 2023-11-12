package hw5_21000709_hoangtuantu.practice01;
import java.util.Scanner;

public class Tree {
    Node root = null;
    public Tree(int[] numbers){
        for (int number : numbers) {
            root = insert(root, number);
        }
    }
    public Node insert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }
        if (x < node.data) {
            node.left = insert(node.left, x);
        } else {
            node.right = insert(node.right, x);
        }
        return node;
    }

    public void printInOder(Node node) {
        if (node != null) {
            printInOder(node.left);
            System.out.print(node.data + " ");
            printInOder(node.right);
        }
    }

    public Node root(){
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        Tree tree = new Tree(numbers);
        tree.printInOder(tree.root());
    }
}