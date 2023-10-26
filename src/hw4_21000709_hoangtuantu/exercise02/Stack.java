package hw4_21000709_hoangtuantu.exercise02;

import java.util.Iterator;

public interface Stack<E> {
    void push ( E element ) ;
    E pop () ;
    boolean isEmpty () ;
    E top () ;
    String toString();
    int size();
    Iterator<E> iterator();
}
