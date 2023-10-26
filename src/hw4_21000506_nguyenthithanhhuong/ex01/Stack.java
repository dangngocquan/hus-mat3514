package hw4_21000506_nguyenthithanhhuong.ex01;

public interface Stack<E> {
    int size();
    public boolean isEmpty();
    public void push(E element);
    public E top();
    public E pop();
}