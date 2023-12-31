package hw6_21000699_dangngocquan.exercise005.components.base;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TextField extends JTextField {
    private final int thickness;
    private final int arcWidth;
    private final int arcHeight;

    public TextField(int x, int y, int width, int height, String initialValue, Color backgroundColor, int thickness, int arcWidth, int arcHeight) {
        super(initialValue, height);

        this.thickness = thickness;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;

        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setBorder(new LineBorder(new Color(114, 114, 114), thickness, true));
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        setDisabledTextColor(Color.BLACK);
        setForeground(Color.BLUE);
        setBackground(backgroundColor);
        setBorder(
                BorderFactory.createCompoundBorder(
                        getBorder(),
                        BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
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
        g2.setColor(new Color(0, 0, 0));
        g2.setStroke(new BasicStroke(thickness));
        g.drawRoundRect(thickness - 1, thickness - 1,
                getWidth() - 2 * thickness, getHeight() - 2 * thickness,
                arcWidth, arcHeight);
    }
}
