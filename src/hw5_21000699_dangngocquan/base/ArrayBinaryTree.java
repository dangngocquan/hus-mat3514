package hw5_21000699_dangngocquan.base;

import java.util.Arrays;

public class ArrayBinaryTree<E> extends AbstractBinaryTree<E, ArrayBinaryTree.ArrayBinaryTreeNode<E>> {
    static class ArrayBinaryTreeNode<E> {
        int index;
        E element;

        @Override
        public String toString() { return element.toString(); }
    }

    private ArrayBinaryTreeNode<E>[] array;
    private int size;
    public static final int DEFAULT_CAPACITY = 64;

    public ArrayBinaryTree() {
        array = (ArrayBinaryTreeNode<E>[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayBinaryTree(int capacity) {
        array = (ArrayBinaryTreeNode<E>[]) new Object[capacity];
    }

    @Override
    public ArrayBinaryTreeNode<E> root() {
        if (1 >= array.length) enlarge();
        return array[1];
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
    public int numberChildren(ArrayBinaryTreeNode<E> p) {
        if (p == null) return 0;
        int count = 0;
        if (left(p) != null) count++;
        if (right(p) != null) count++;
        return count;
    }

    @Override
    public ArrayBinaryTreeNode<E> parent(ArrayBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("Current node is null.");
            return null;
        }
        if (!isValidIndex(p.index / 2)) return null;
        return array[p.index/2];
    }

    @Override
    public ArrayBinaryTreeNode<E> left(ArrayBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("Current node is null.");
            return null;
        }
        if (isValidIndex(p.index * 2)) return array[p.index * 2];
        return null;
    }

    @Override
    public ArrayBinaryTreeNode<E> right(ArrayBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("Current node is null.");
            return null;
        }
        if (isValidIndex(p.index * 2 + 1)) return array[p.index * 2 + 1];
        return null;
    }

    @Override
    public ArrayBinaryTreeNode<E> sibling(ArrayBinaryTreeNode<E> p) {
        if (p == null) {
            System.out.println("Current node is null.");
            return null;
        }
        int siblingIndex = p.index % 2 == 0? p.index + 1 : p.index - 1;
        if (isValidIndex(siblingIndex)) return array[siblingIndex];
        return null;
    }

    public void setRoot(E element) {
        if (1 >= array.length) enlarge();
        if (array[1] == null) {
            array[1] = new ArrayBinaryTreeNode<>();
            array[1].index = 1;
        }
        array[1].element = element;
    }

    public void setLeft(int p, E element) {
        if (array[p] == null) {
            System.out.println("Current node is null.");
            return;
        }
        if (2*p >= array.length) enlarge();
        if (array[2*p] == null) {
            array[2*p] = new ArrayBinaryTreeNode<>();
            array[2*p].index = 2*p;
            size++;
        }
        if (element == null) {
            size--;
            array[2*p] = null;
        } else {
            array[2*p].element = element;
        }
    }

    public void setRight(int p, E element) {
        if (array[p] == null) {
            System.out.println("Current node is null.");
            return;
        }
        if (2*p+1 >= array.length) enlarge();
        if (array[2*p+1] == null) {
            array[2*p+1] = new ArrayBinaryTreeNode<>();
            array[2*p+1].index = 2*p+1;
            size++;
        }
        if (element == null) {
            size--;
            array[2*p+1] = null;
        } else {
            array[2*p+1].element = element;
        }
    }

    private void enlarge() {
        if (array.length * 2 < array.length) throw new IllegalArgumentException("Reached max size.");
        array = Arrays.copyOf(array, array.length * 2);
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index < array.length;
    }
}
