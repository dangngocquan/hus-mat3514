package hw5_21000117_nguyenquochieu.practice01.exercise63;

public class Main {
    public static void main(String[] args) {
        int[] data = {4, 7, 2, 1, 3, 2, 5};
        BinaryTree tree = new BinaryTree(data);
        BinaryTree.Node root = tree.construct();
        System.out.println(tree.countLeaves(root));
    }
}
