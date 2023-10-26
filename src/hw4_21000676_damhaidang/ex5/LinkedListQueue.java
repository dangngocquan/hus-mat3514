package hw4_21000676_damhaidang.ex5;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    private SimpleLinkedList<E> list = new SimpleLinkedList<E>();
    @Override
    public void enqueue(E element) {
        list.addBot(element);
    }

    public int size() {
        return list.size();
    }
    @Override
    public E dequeue() {
        return list.removeTop();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E first() {
        return list.get(0);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
