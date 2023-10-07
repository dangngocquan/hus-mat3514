package hw2_21000709_hoangtuantu.exercise04;

import java.util.*;

public class IsSquareNumber {
    static Random random = new Random();

    public static boolean isSquare(int number){
        return (int) Math.sqrt(number) * (int) Math.sqrt(number) == number;

    }

    public static int[] solve(int[] numbers){
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (isSquare(number) && ! result.contains(number)){
                result.add(number);
            }
        }

        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            temp[i] = result.get(i);
        }
        return temp;
    }

    public static void printResult(int[] numbers){
        if (numbers.length > 0){
            Arrays.sort(numbers);
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        }else{
            System.out.println("NULL");
        }
    }

    public static int[] inputArray(int size){
        int[]  numbers = new int[size];
        for (int i = 0; i < size; i++){
            numbers[i] = random.nextInt((int) Math.pow(10, 9));
        }
        return numbers;
    }

    public static void main(String[] args) {
        int size = random.nextInt((int) Math.pow(10, 5)) + 1;
        int[] numbers = inputArray(size);
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Answer is: ");
        printResult(solve(numbers));
    }
}
