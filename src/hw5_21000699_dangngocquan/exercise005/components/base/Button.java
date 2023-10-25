package hw5_21000699_dangngocquan.exercise005.components.base;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class Button extends JButton {

    public Button(int x, int y, int width, int height, String text) {
        super(text);
        int borderWidth = 2;
        Color borderColor = Color.BLACK;

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setFocusPainted(false);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        setUI(new BasicButtonUI());
        setBackground(new Color(210, 210, 210));
        setBorder(new LineBorder(
                borderColor, borderWidth
        ));
        setVisible(true);
    }
}