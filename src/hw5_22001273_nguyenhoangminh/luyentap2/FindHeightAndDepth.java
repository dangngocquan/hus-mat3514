package hw5_22001273_nguyenhoangminh.luyentap2;

class FindHeightAndDepth {
    static int height = -1;

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int element) {
        Node temp = new Node();
        temp.data = element;
        temp.left = temp.right = null;
        return temp;
    }

    static int findDepth(Node root, int element) {
        if (root == null) return -1;

        int depth = -1;

        if ((root.data == element)||(depth = findDepth(root.left, element)) >= 0 ||
                                (depth = findDepth(root.right, element)) >= 0) {
            return depth + 1;
        }
        return depth;
    }

    public static void print(Node root, int space) {
        final int COUNT = 5;
        if (root == null) return;

        space += COUNT;
        print(root.right, space);

        System.out.println();

        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data);

        print(root.left, space);
    }


    public static void main(String []args) {
        // Binary Tree Creation
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.right.right = newNode(6);
        root.right.left = newNode(7);
        root.right.right = newNode(8);

        int k = 6;

        print(root, 0);

        System.out.println("Depth of 6: " + findDepth(root, k));
    }
}

