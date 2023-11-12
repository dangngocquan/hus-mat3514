package hw5_21000712_taquangtung.itemC.practice20;

import java.util.LinkedList;
import java.util.Queue;

public class Gfg {
    public static Tree convert(Node head, Tree node) {
        // Kiểm tra phần tử đầu danh sách liên kết
        if (head == null) {
            return null;
        }

        // Tạo Node gốc cho vào Queue
        node = new Tree(head.data);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);

        head = head.next;       // Chuyển tới phần tử tiếp theo

        while (head != null) {
            Tree parent = queue.poll();

            // Tạo con trái và thêm vào Queue
            if (head != null) {
                parent.left = new Tree(head.data);
                queue.add(parent.left);
                head = head.next;
            }

            // Tạo con phải và thêm vào Queue
            if (head != null) {
                parent.right = new Tree(head.data);
                queue.add(parent.right);
                head = head.next;
            }
        }
        return node;
    }
}
