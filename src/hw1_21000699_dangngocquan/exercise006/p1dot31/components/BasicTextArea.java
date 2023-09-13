package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BasicTextArea extends JTextArea {
    private int x;
    private int y;
    private int width;
    private int height;
    private int thickness;
    private int arcWidth, arcHeight;

    public BasicTextArea(int x, int y, int width, int height, int thickness, int arcWidth, int arcHeight) {
        super(width, height);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.thickness = thickness;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;

        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setForeground(new Color(75, 255, 0));
        setBorder(new LineBorder(new Color(210, 106, 106), thickness, true));
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(Config.ARIAL_BOLD_12);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRoundRect(thickness - 1, thickness - 1, getWidth() - 2 * thickness, getHeight() - 2 * thickness, arcWidth,
                15);
        super.paintComponent(g);
    }

    public void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getForeground());
        g2.setStroke(new BasicStroke(thickness));
        g.drawRoundRect(thickness - 1, thickness - 1,
                getWidth() - 2 * thickness, getHeight() - 2 * thickness,
                arcWidth, arcHeight);
    }
}
