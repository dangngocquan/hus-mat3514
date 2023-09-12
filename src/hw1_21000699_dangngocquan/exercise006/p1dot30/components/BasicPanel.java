package hw1_21000699_dangngocquan.exercise006.p1dot30.components;

import javax.swing.*;
import java.awt.*;

public class BasicPanel extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;

    public BasicPanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);

        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
