package hw5_22001273_nguyenhoangminh.excercise1;

public class TestArrayTree {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        Integer root = tree.root();

        int l = tree.setLeft(root, 2);
        int r = tree.setRight(root, 3);

        int l1 = tree.setLeft(l, 4);
        int l2 = tree.setRight(l, 5);

        int r1 = tree.setLeft(r, 6);
        int r2 = tree.setRight(r, 7);

        tree.print(1, 0);
    }
}
