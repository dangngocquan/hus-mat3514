package hw5_21000709_hoangtuantu.practice12;

public class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }

    public Node(int data , Node left , Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}