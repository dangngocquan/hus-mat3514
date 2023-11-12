package hw5_20001970_duongtuanson.Bai1;
public class Output {
    public static ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
    public static LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> tree2 = new LinkedBinaryTree<>();
    public static void main(String[] args) {
        tree.setRoot(1);
        tree.setLeft(1, 5);
        tree.setRight(1, 3);
        tree.setLeft(2, 8);
        tree.setRight(2, 6);
        tree.setLeft(3, 2);
        tree.setRight(3, 7);

        tree.printTreeHorizontal();
        System.out.println();


        LinkedBinaryTree.Node<Integer> root = tree2.addRoot(1);
        LinkedBinaryTree.Node<Integer> node1 = tree2.addLeft(root, 5);
        LinkedBinaryTree.Node<Integer> node2 = tree2.addRight(root, 3);
        LinkedBinaryTree.Node<Integer> node3 = tree2.addLeft(node1, 8);
        LinkedBinaryTree.Node<Integer> node4 = tree2.addRight(node1, 6);
        LinkedBinaryTree.Node<Integer> node5 = tree2.addLeft(node2, 2);
        LinkedBinaryTree.Node<Integer> node6 = tree2.addRight(node2, 7);

        tree2.printTreeHorizontal();
        System.out.println();
    }
}
