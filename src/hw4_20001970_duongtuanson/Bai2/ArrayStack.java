package hw4_20001970_duongtuanson.Bai2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] data;
    private int size;

    public ArrayStack() {
        this.data = (E[]) new Object[10];
        this.size = 0;
    }

    public ArrayStack(int size) {
        this.data = (E[]) new Object[size];
        this.size = 0;
    }

    @Override
    public void push(E data) {
        if (this.size == this.data.length) {
            this.extend();
        }
        this.data[this.size++] = data;
    }

    @Override
    public E pop() {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.data[i] != null) {
                E temp = this.data[i];
                this.data[i] = null;
                this.size--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E top() {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.data[i] != null) {
                return this.data[i];
            }
        }
        return null;
    }
    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.data[i] != null) {
                list.add(this.data[i]);
            }
        }
        return list.iterator();
    }

    public void extend() {
        E[] newData = (E[]) new Object[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
}
