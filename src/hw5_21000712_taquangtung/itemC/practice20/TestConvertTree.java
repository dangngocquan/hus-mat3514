package hw5_21000712_taquangtung.itemC.practice20;

/* Geeksforgeeks
Tạo (Xây dựng) cây nhị phân từ danh sách liên kết - Make Binary Tree From Linked List
 */

public class TestConvertTree {
    public static void main(String[] args) {
        // Tạo danh sách liên kết
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Gọi hàm convert từ class Gfg để chuyển đổi danh sách liên kết thành cây nhị phân
        Gfg gfg = new Gfg();
        Tree root = gfg.convert(head, null);

        // Gọi hàm inOrder để in ra dãy giá trị của cây theo thứ tự InOrder
        inOrder(root);
    }

    // Hàm inOrder để in ra dãy giá trị của cây theo thứ tự InOrder
    public static void inOrder(Tree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
