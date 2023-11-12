package hw5_21000712_taquangtung.itemA.practice02;

/*
Tính chiều cao của cây nhị phân - Height of Binary Tree
 */

public class TestHeight {
    public static void main(String[] args) {
        Solution treeSolution = new Solution();

        // Xây dựng cây nhị phân
        Solution.Node root = treeSolution.new Node(1);
        root.left = treeSolution.new Node(2);
        root.right = treeSolution.new Node(3);
        root.left.left = treeSolution.new Node(4);
        root.left.right = treeSolution.new Node(5);

        // Tính chiều cao của cây
        int treeHeight = treeSolution.height(root);
        System.out.println("Height of Tree is: " + treeHeight);
    }
}
