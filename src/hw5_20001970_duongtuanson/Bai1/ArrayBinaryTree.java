package hw5_20001970_duongtuanson.Bai1;
public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    @Override
    public T root() {
        if (isEmpty()) {
            return null;
        }
        return (T) array[1];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public int numChildren(T p) {
        // return number of children of p
        int index = findIndex(p);
        int count = 0;
        if(array[index * 2] != null) {
            count++;
        }
        if(array[index * 2 + 1] != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        // return parent of p
        int index = findIndex(p);
        if(index == 0) {
            return null;
        }
        return (T) array[index / 2];
    }

    @Override
    public T left(T p) {
        // return left child of p(at index 2i)
        return (T) array[findIndex(p) * 2 - 1];
    }

    @Override
    public T right(T p) {
        // return right child of p(at index 2i + 1)
        return (T) array[findIndex(p) * 2];
    }

    @Override
    public T sibling(T p) {
        // return sibling of p
        int index = findIndex(p);
        if(index % 2 == 0) {
            return (T) array[index + 1];
        }
        return (T) array[index - 1];
    }

    public void setRoot(E element) {
        array[0] = element;
        n++;
    }

    public void setLeft(int p, E element) {
        //Set left child of p (at index 2p)
        int index = p * 2 - 1 ;
        if(index >= defaultSize) {
            System.out.println("Out of range");
            return;
        }
        if(array[index] != null) {
            System.out.println("Left child is not null");
            return;
        }
        array[index] = element;
        n++;
    }
    //

    public void setRight(int p, E element) {
        //Set right child of p (at index 2p + 1)
        int index = p * 2;
        if(index >= defaultSize) {
            System.out.println("Out of range");
            return;
        }
        if(array[index] != null) {
            System.out.println("Right child is not null");
            return;
        }
        array[index] = element;
        n++;
    }
    public int findIndex(T p) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }
    public int getHeight() {
        return (int) Math.ceil(Math.log(n + 1) / Math.log(2)) - 1;
    }
    public void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }
    public void printTreeHorizontal() {
        int height = getHeight();
        int space = (int) Math.pow(2, height + 1) - 1;
        int index = 0;
        for (int i = 0; i <= height; i++) {
            printSpace(space);
            for (int j = 0; j < Math.pow(2, i); j++) {
                if (array[index] != null) {
                    System.out.print(array[index]);
                } else {
                    System.out.print(" ");
                }
                printSpace(space * 2 + 1);
                index++;
            }
            space = (space - 1) / 2;
            System.out.println();
        }
    }
}

