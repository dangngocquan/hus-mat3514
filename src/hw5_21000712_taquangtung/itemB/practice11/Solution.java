package hw5_21000712_taquangtung.itemB.practice11;

import java.util.ArrayList;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    ArrayList<Integer> inOrder(Node root) {
        // Mảng ArrayList lưu trữ cây
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Kiểm tra Node rỗng không
        if (root != null) {
            arrayList.addAll(inOrder(root.left));
            arrayList.add(root.data);
            arrayList.addAll(inOrder(root.right));
        }
        return arrayList;
    }
}
