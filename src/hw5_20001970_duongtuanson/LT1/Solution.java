package hw5_20001970_duongtuanson.LT1;
import java.util.Scanner;
public class Solution {
    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        Node root = null;
        System.out.println("Enter the nodes: ");
        while (n-- > 0) {
            int data = scanner.nextInt();
            root = insert(root, data);
        }
        scanner.close();
        int height = height(root);
        System.out.println("Height of the tree: " +height);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Solution().new Node();
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
