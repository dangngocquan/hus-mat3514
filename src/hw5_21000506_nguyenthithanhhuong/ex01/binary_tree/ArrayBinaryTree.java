package hw5_21000506_nguyenthithanhhuong.ex01.binary_tree;

import java.util.Arrays;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<Integer> {
    private E[] array;
    private int size = 0;
    private int DEFAULT_SIZE = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    public ArrayBinaryTree(int size) {
        array = (E[]) new Object[size];
    }

    // Set element to root of an empty tree (at index 1)
    public void setRoot(E element) {
        if (array.length <= 1) enlarge();
        array[1] = element;
        size++;
    }

    // Set left child of p (at index 2p)
    public void setLeft(int p, E element) {
        if (array[p] == null) {
            System.out.println("Don't set left");
        }
        if (array.length <= 2*p) enlarge();
        array[2*p] = element;
        size++;
    }

    // Set right child of p (at index 2p + 1)
    public void setRight(int p, E element) {
        if (array[p] == null) {
            System.out.println("Don't set right");
        }
        if (array.length <= 2*p + 1) enlarge();
        array[2*p + 1] = element;
        size++;
    }

    @Override
    public Integer root() {
        return 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(Integer p) {
        if (p < 1) return -1;
        int result = 0;
        if (array[2*p] != null) result++;
        if (array[2*p + 1] != null) result++;
        return result;
    }

    @Override
    public Integer parent(Integer p) {
        if (p <= 1) return -1;
        if (isValidIndex(p)) {
            return p/2;
        }
        return -1;
    }

    @Override
    public Integer left(Integer p) {
        if (isValidIndex(2*p)) return 2*p;
        return -1;
    }

    @Override
    public Integer right(Integer p) {
        if (isValidIndex(2*p + 1)) return 2*p + 1;
        return -1;
    }

    @Override
    public Integer sibling(Integer p) {
        if (p <= 1) return -1;
        if (isValidIndex(p)) {
            if (p % 2 == 0) {
                if (isValidIndex(p + 1)) return p + 1;
            } else {
                if (isValidIndex(p - 1)) return p - 1;
            }
        }
        return -1;
    }

    // Enlarge array when full
    private void enlarge() {
        E[] newArray = (E[]) new Object[array.length*2];
        newArray = Arrays.copyOf(array, array.length*2);
        array = newArray;
    }

    // Check an index is valid or not
    private boolean isValidIndex(Integer p) {
        return p > 0 && p <= array.length;
    }

    // Get value of array at index
    private E valueOfArrayAtIndex(Integer p) {
        if (p == null && p < 1) return null;
        if (isValidIndex(p)) return array[p];
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        stringRightParentLeft(sb, maxLengthOfNode(1), root());
        return sb.toString();
    }

    // Convert tree to string with format RightRootLeft
    public void stringRightParentLeft(StringBuilder sb, int width, Integer p) {
        if (valueOfArrayAtIndex(p) != null) {
            if (valueOfArrayAtIndex(right(p)) != null) {
                stringRightParentLeft(sb, width, right(p));
            }

            sb.append(" ".repeat(distanceFromRootToLevel(p)))
                    .append(valueOfArrayAtIndex(p))
                    .append("\n");

            if (valueOfArrayAtIndex(left(p)) != null) {
                stringRightParentLeft(sb, width, left(p));
            }
        }
    }

    // Find the max character of value at a node
    public int maxLengthOfNode(Integer p) {
        if (valueOfArrayAtIndex(p) == null) return 1;
        return Math.max(
                valueOfArrayAtIndex(p).toString().length(),
                Math.max(
                    maxLengthOfNode(right(p)),
                    maxLengthOfNode(left(p))
                )
        );
    }

    // Define the distance from root to a level of tree
    public int distanceFromRootToLevel(Integer p) {
        return maxLengthOfNode(1)*(level(p)-1)*3;
    }

    // Find level
    public int level(Integer p) {
        if (valueOfArrayAtIndex(p) == null) return 0;
        if (p == 1) return 1;
        return 1 + level(parent(p));
    }
}
