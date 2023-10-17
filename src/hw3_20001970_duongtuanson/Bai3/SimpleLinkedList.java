package hw3_20001970_duongtuanson.Bai3;

public class SimpleLinkedList<T> {
    class Node{
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;
    public void add(T data){
        Node newNode = new Node();
        newNode.data = data;
        if (top == null){
            top = newNode;
            bot = newNode;
        }
        else{
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    public T get (int i){
        if (i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        Node p = top;
        for (int j = 0; j < i; j++){
            p = p.next;
        }
        return p.data;
    }
    public void set (int i, T data){
        if (i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        Node p = top;
        for (int j = 0; j < i; j++){
            p = p.next;
        }
        p.data = data;
    }
    public boolean isContain (T data){
        Node p = top;
        for (int i = 0; i < n; i++){
            if (p.data == data){
                return true;
            }
            p = p.next;
        }
        return false;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public T removeTop(){
        if (top == null){
            throw new NullPointerException();
        }
        T data = top.data;
        top = top.next;
        n--;
        return data;

    }
    public T removeBot(){
        if (bot == null){
            throw new NullPointerException();
        }
        T data = bot.data;
        Node p = top;
        for (int i = 0; i < n - 2; i++){
            p = p.next;
        }
        p.next = null;
        bot = p;
        n--;
        return data;
    }
    public void remove(T data){
        Node p = top;
        for (int i = 0; i < n; i++){
            if (p.data == data){
                if (i == 0){
                    removeTop();
                    return;
                }
                if (i == n - 1){
                    removeBot();
                    return;
                }
                Node q = top;
                for (int j = 0; j < i - 1; j++){
                    q = q.next;
                }
                q.next = p.next;
                n--;
                return;
            }
            p = p.next;
        }
    }
}
