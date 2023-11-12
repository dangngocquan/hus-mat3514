package hw5_21000709_hoangtuantu.practice01;

import java.util.Scanner;

public class Solution {
    public static void Problem62(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }
        Tree tree = new Tree(numbers);
        tree.printInOder(tree.root());
        input.close();
    }
    public static long factorial(int n){
        if (n <= 1){
            return 1;
        }return n * factorial(n - 1);
    }
    public static void Problem52(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(factorial(n));
    }

    public static void main(String[] args) {
        Problem52();
    }
}
