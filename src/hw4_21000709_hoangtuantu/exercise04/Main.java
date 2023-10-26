package hw4_21000709_hoangtuantu.exercise04;


import java.util.Iterator;
import java.util.Random;

public class Main {
    public static Queue<Integer> generateQueue(boolean array, int size){
        Queue<Integer> queue;
        if (array ){
            queue = new ArrayQueue<>();
        }
        else{
            queue = new LinkedListQueue<>();
        }
        Random random = new Random();
        for (int i = 0; i < size; i++){
            queue.enqueue(random.nextInt((int) Math.pow(10, 6)));
        }
        return queue;
    }

    public static void test(boolean array, int size){
        Queue<Integer> queue = generateQueue(array, size);
        System.out.println("Stack: ");
        System.out.println(queue);
        Iterator<Integer> iterator = queue.iterator();

        System.out.println("Using iterator: ");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        System.out.println("Using pop: ");
        for (int i = 0; i < size;i++){
            System.out.print(queue.dequeue() + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Test array stack: ");
        final int SIZE = 10;
        test(true, SIZE);

        System.out.println("_________________");

        System.out.println("Test linked stack: ");
        test(false, SIZE);
    }
}
