package hw6_21000699_dangngocquan.exercise006.components.base;

import hw6_21000699_dangngocquan.exercise006.Config;

import javax.swing.*;

public class Button extends JButton {

    public Button(int x, int y, int width, int height, String text) {
        super(text);

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setFocusPainted(false);
        setFont(Config.ARIAL_BOLD_18);

        setVisible(true);
    }
}
