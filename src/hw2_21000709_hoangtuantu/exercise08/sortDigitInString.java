package hw2_21000709_hoangtuantu.exercise08;

import java.util.Scanner;

public class sortDigitInString {
    public static String solve(String inputString) {
        StringBuilder result = new StringBuilder(inputString); // Use StringBuilder to store the result
        for (int i = 0; i < result.length(); i++){ // Using selection sort
            int index = i;
            if (Character.isDigit(result.charAt(i))){
                // If character at index i is a digit find smaller digit in string
                for (int j = i + 1; j < result.length(); j++){
                    if (result.charAt(j) < result.charAt(index) && Character.isDigit(result.charAt(j))){
                        // find smallest digit from i in string
                        index = j;
                    }
                }
                if (index != i){
                    // Swap digit in StringBuilder
                    char temp = result.charAt(i);
                    result.setCharAt(i, result.charAt(index));
                    result.setCharAt(index, temp);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a string: ");
        //Input example: http://14.241.121.251/problem/sortnum
        String inputString = input.nextLine();
        input.close();

        System.out.println("String after sort digit in string: " + solve(inputString));
        // Output: http://11.111.222.445/problem/sortnum

    }
}
