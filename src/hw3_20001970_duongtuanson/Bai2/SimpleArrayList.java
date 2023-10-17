package Tuan3.Bai2;
import java.util.Iterator;

public class SimpleArrayList <T> implements ListInterface<T>{
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList(){
        array = (T[]) new Object[defaultSize];
    }
    public void add(T data){
        if (n == array.length){
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n] = data;
        n++;
    }
    public T get (int i){
        if (i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }
    public void set (int i, T data){
        if (i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }
    public void remove (int i){
        if (i < 0 || i >= n){
            throw new IndexOutOfBoundsException();
        }
        for (int j = i; j < n - 1; j++){
            array[j] = array[j + 1];
        }
        n--;
    }
    public void isContain (T data){
        for (int i = 0; i < n; i++){
            if (array[i] == data){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>(){
            private int index = 0;
            public boolean hasNext(){
                return index < n;
            }
            public T next(){
                return array[index++];
            }
        };
    }
}
