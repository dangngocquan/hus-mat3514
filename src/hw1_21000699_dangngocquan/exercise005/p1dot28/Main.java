package hw1_21000699_dangngocquan.exercise005.p1dot28;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        writeOut(100, 8);
    }

    public static void writeOut(int times, int differentTypos) {
        String sentence = "I will never spam my friends again.";
        Set<String> typosSet = new HashSet<>();
        typosSet.add(sentence);
        while (typosSet.size() <= differentTypos) {
            char c = (char) ('a' + (int) (Math.floor(Math.random() * 26)));
            int randomIndex = (int) (Math.floor(Math.random() * sentence.length()));
            String str = sentence.replace(sentence.charAt(randomIndex), c);
            typosSet.add(str);
        }
        Set<Integer> randomIndexes = new TreeSet<>();
        while (randomIndexes.size() <= differentTypos) {
            int randomIndex = (int) (Math.floor(Math.random() * times));
            randomIndexes.add(randomIndex);
        }
        List<String> typos = new LinkedList<>(typosSet);
        List<Integer> indexes = new LinkedList<>(randomIndexes);
        for (int i = 0; i < times; i++) {
            int index = indexes.indexOf(i);
            if (index > -1) {
                System.out.printf("%03d. %s\n", i+1, typos.get(index));
            } else {
                System.out.printf("%03d. %s\n", i+1, sentence);
            }
        }
    }
}
