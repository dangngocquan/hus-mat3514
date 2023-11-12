package hw5_21000689_nguyenxuanloi.practice.practice_21;

public class BinaryTreeTest {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.createTreeFromArray(0, 1, 2, 3, 4, 5, 6);
        tree.print();
    }
}
