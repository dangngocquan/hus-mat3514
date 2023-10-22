package hw5_21000699_dangngocquan.extend021;

import java.util.LinkedList;
import java.util.Queue;

// Link: https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1
public class TreeFromInorderAndLevelOrder {
    static class Node {
        int data;
        Node left, right;

        Node (int item) {
            data = item;
            left = right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class GfG {
        // n: length of array
        // Each element in array has value less than n, two elements in array always different
        Node buildTree(int[] inorder, int[] level) {
            if (inorder.length == 0) return null;
            int n = inorder.length;
            int[] indexOfNode = new int[n];
            for (int i = 0; i < n; i++) indexOfNode[inorder[i]] = i;
            Node root = new Node(level[0]);
            Queue<Node> queueNodes = new LinkedList<>();
            Queue<Integer[]> queueLMR = new LinkedList<>();
            queueNodes.add(root);
            queueLMR.add(new Integer[] {0, indexOfNode[root.data], n-1});
            for (int i = 1; i < n; i++) {
                Node newNode = new Node(level[i]);
                while (true) {
                    Node parentNode = queueNodes.peek();
                    Integer[] lmr = queueLMR.peek(); // left-mid-right
                    assert parentNode != null;
                    assert lmr != null;
                    if (indexOfNode[newNode.data] > lmr[2]) {
                        queueNodes.poll();
                        queueLMR.poll();
                        continue;
                    }
                    queueNodes.add(newNode);
                    if (indexOfNode[newNode.data] > lmr[1]) {
                        parentNode.right = newNode;
                        queueLMR.add(new Integer[] {lmr[1]+1, indexOfNode[newNode.data], lmr[2]});
                        queueNodes.poll();
                        queueLMR.poll();
                    } else {
                        parentNode.left = newNode;
                        queueLMR.add(new Integer[] {lmr[0], indexOfNode[newNode.data], lmr[1]-1});
                    }
                    break;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new GfG().buildTree(
                new int[] {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 12, 2, 13, 6, 14},
                new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}
        );
        preOrder(root); // 0 1 3 7 8 4 9 10 2 5 11 12 6 13 14
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
