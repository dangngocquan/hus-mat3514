package hw1_21000699_dangngocquan.exercise006.p1dot30.components;

import javax.swing.*;

public class BasicButton extends JButton {
    private int x;
    private int y;
    private int width;
    private int height;

    public BasicButton(int x, int y, int width, int height, String text) {
        super(text);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setFocusPainted(false);

        setVisible(true);
    }
}
