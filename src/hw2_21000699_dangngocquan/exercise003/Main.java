package hw2_21000699_dangngocquan.exercise003;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Config();
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(() -> {
            new App();
        });
    }
}
