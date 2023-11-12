package hw5_21000709_hoangtuantu.practice12;


import java.util.ArrayList;

class Tree {
    static ArrayList<Integer> result = new ArrayList<>();

    static ArrayList<Integer> preorder(Node root) {
        add(root);
        return result;
    }

    static void add(Node node) {
        if (node != null){
            result.add(node.data);
            add(node.left);
            add(node.right);
        }
    }
}