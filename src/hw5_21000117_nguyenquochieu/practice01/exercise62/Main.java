package hw5_21000117_nguyenquochieu.practice01.exercise62;

public class Main {
    public static void main(String[] args) {
        int[] data = {3, 2, 1, 5, 4};
        Tree tree = new Tree();
        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }
        System.out.println(tree.inOrderTraversal());
    }
}

