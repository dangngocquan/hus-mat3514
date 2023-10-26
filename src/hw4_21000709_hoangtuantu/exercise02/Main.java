package hw4_21000709_hoangtuantu.exercise02;

import java.util.Iterator;
import java.util.Random;

public class Main {
    public static Stack<Integer> generateStack(boolean array){
        Stack<Integer> result;
        Random         random = new Random();
        final int      SIZE   = random.nextInt((int) Math.pow(10, 4)) + 1;
        if (array){
            result = new ArrayStack<>();
        }else {
            result = new LinkedListStack<>();
        }
        for (int i = 0; i < SIZE ;i++){
            result.push(random.nextInt((int) Math.pow(10, 6)));
        }
        return result;
    }

    public static Stack<Integer> generateStack(boolean array, int size){
        Stack<Integer> result;
        Random random = new Random();
        if (array){
            result = new ArrayStack<>();
        }else {
            result = new LinkedListStack<>();
        }
        for (int i = 0; i < size ;i++){
            result.push(random.nextInt((int) Math.pow(10, 6)));
        }
        return result;
    }

    public static void test(boolean array, int size){
        Stack<Integer> stack = generateStack(array, size);
        System.out.println("Stack: ");
        System.out.println(stack);
        Iterator<Integer> iterator = stack.iterator();

        System.out.println("Using iterator: ");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        System.out.println("Using pop: ");
        for (int i = 0; i < size;i++){
            System.out.print(stack.pop() + ", ");
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
