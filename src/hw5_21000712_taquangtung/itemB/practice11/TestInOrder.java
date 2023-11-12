package hw5_21000712_taquangtung.itemB.practice11;

import java.util.ArrayList;


/* Geeksforgeeks
Duyệt cây theo thứ tự giữa - Inorder Traversal
 */
public class TestInOrder {
    public static void main(String[] args) {
        // Tạo một cây nhị phân
        Solution solution = new Solution();
        Solution.Node root = solution.new Node(1);
        root.left = solution.new Node(2);
        root.right = solution.new Node(3);
        root.left.left = solution.new Node(4);
        root.left.right = solution.new Node(5);

        // Gọi hàm inOrder để lấy danh sách giá trị theo thứ tự trung tâm
        ArrayList<Integer> inOrderList = solution.inOrder(root);

        // In ra danh sách giá trị
        for (int value : inOrderList) {
            System.out.print(value + " ");
        }

    }
}
