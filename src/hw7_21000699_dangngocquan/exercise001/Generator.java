package hw7_21000699_dangngocquan.exercise001;

import hw7_21000699_dangngocquan.base.tree.LinkedBinaryTree;
import hw7_21000699_dangngocquan.exercise002.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Generator {
    public static int value;

    // get random integer in [from, to-1]
    public int randomInteger(int from, int to) {
        long range = (long) (to) - (long) (from);
        long random = (long) (Math.floor(Math.random() * range)) + (long) from;
        return (int) random;
    }

    // get an array has length n and value of each element in [from, to-1]
    public Integer[] randomArray(int n, int from, int to) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) array[i] = randomInteger(from, to);
        return array;
    }

    public Integer[] randomUniqueArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) array[i] = i;
        for (int i = 0; i < n; i++) {
            int j = randomInteger(0, n);
            Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public BinarySearchTree<Integer> createUniqueBinarySearchTree(int n) {
        LinkedBinaryTree.Node<Integer> root
                = new LinkedBinaryTree.Node<>(0, null, null, null);
        Queue<LinkedBinaryTree.Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (count < n) {
            LinkedBinaryTree.Node<Integer> node = queue.poll();
            LinkedBinaryTree.Node<Integer> left = new LinkedBinaryTree.Node<>(0, node, null, null);
            node.left = left;
            count++;
            queue.add(left);
            if (count >= n) break;
            LinkedBinaryTree.Node<Integer> right = new LinkedBinaryTree.Node<>(0, node, null, null);
            node.right = right;
            count++;
            queue.add(right);
        }
        value = 0;
        fillDataBinarySearchTree(root);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addRoot(root);
        return tree;
    }

    public void fillDataBinarySearchTree(LinkedBinaryTree.Node<Integer> root) {
        if (root == null) return;
        fillDataBinarySearchTree(root.left);
        root.element= value;
        value++;
        fillDataBinarySearchTree(root.right);
    }
}


