package hw4_22001273_nguyenhoangminh.luyentap7;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;

public class QueueUsingTwoStacks<E>{
    LinkedListStack<E> enq, dec;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public QueueUsingTwoStacks() {
        enq = new LinkedListStack<>();
        dec = new LinkedListStack<>();
    }

    public void enqueue(E element) {
        int length = dec.size();
        for (int i = 0; i < length; i++) {
            enq.push(dec.pop());
        }
        enq.push(element);
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        int length = enq.size();
        for (int i = 0; i < length; i++) {
            dec.push(enq.pop());
        }
        size--;
        return dec.pop();
    }

    public E first() {
        int length = enq.size();
        for (int i = 0; i < length; i++) {
            dec.push(enq.pop());
        }
        return dec.top();
    }

    @Override
    public String toString() {
        if (enq.isEmpty()) return dec.toString();
        else return enq.toString();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(11);
        System.out.println(queue);


    }

}
