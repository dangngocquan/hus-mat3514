package hw1_21000699_dangngocquan.exercise006.p1dot30.services;

import hw1_21000699_dangngocquan.exercise006.p1dot30.models.AlphabetCharacter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Service {
    public static List<AlphabetCharacter> getListFrequenciesCharacter(String text) {
        text = text.toLowerCase();
        int[] counts = new int[26];
        double[] frequencies = new double[26];
        int totalChars = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                totalChars++;
                counts[c - 'a']++;
            }
        }
        if (totalChars == 0) totalChars = 1;
        for (int i = 0; i < 26; i++) {
            frequencies[i] = counts[i] * 1.0 / totalChars;
        }

        List<AlphabetCharacter> alphabetCharacters = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            AlphabetCharacter alphabetCharacter = new AlphabetCharacter(
                    c, counts[i], frequencies[i]
            );
            alphabetCharacters.add(alphabetCharacter);
        }
        return alphabetCharacters;
    }


    public static JFrame getFrame(Component theComponent) {
        Component currParent = theComponent;
        JFrame theFrame = null;
        while (currParent != null) {
            if (currParent instanceof JFrame) {
                theFrame = (JFrame) currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return theFrame;
    }


    public static String getStringFromFile(String path) {
        StringBuilder sb = new StringBuilder("");
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
