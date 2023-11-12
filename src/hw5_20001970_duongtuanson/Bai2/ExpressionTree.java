package hw5_20001970_duongtuanson.Bai2;


public class ExpressionTree<E> extends LinkedBinaryTree {
    private Node<E> left(Node<E> p) {
        return p.getLeft();
    }

    private Node<E> right(Node<E> p) {
        return p.getRight();
    }

    private Node<E> parent(Node<E> p) {
        return p.getParent();
    }

    private boolean isEmpty() {
        int size = 0;
        return size == 0;
    }


    public void preorderPrint(Node<E> p) {
        if (p != null) {
            System.out.print(p.getElement() + " ");
            preorderPrint(left(p));
            preorderPrint(right(p));
        }
    }

    public void inorderPrint(Node<E> p) {
        if (p != null) {
            inorderPrint(left(p));
            System.out.print(p.getElement() + " ");
            inorderPrint(right(p));
        }
    }

    public void postorderPrint(Node<E> p) {
        if (p != null) {
            postorderPrint(left(p));
            postorderPrint(right(p));
            System.out.print(p.getElement() + " ");
        }
    }
}
