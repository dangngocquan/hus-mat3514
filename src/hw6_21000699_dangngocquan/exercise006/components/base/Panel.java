package hw6_21000699_dangngocquan.exercise006.components.base;

import hw6_21000699_dangngocquan.exercise006.Config;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private String text;
    private final Color backgroundColor;
    private final ImageIcon backgroundImage;

    public Panel(
            int x, int y, int width, int height,
            Color backgroundColor, ImageIcon backgroundImage,
            String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setFont(Config.ARIAL_BOLD_18);
        setIgnoreRepaint(true);
        setBackground(backgroundColor);

        setVisible(true);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setX(int x) {
        this.x = x;
        setBounds(x, y, width, height);
    }

    public void setY(int y) {
        this.y = y;
        setBounds(x, y, width, height);
    }

    public void setText(String text) {
        this.text = text;
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        if (backgroundColor != null) {
            g2d.setColor(backgroundColor);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                    RenderingHints.	VALUE_COLOR_RENDER_QUALITY);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        if (backgroundImage != null) {
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawImage(backgroundImage.getImage(), 1, 1, getWidth()-2, getHeight()-2, null);
        }

        g2d.setColor(Config.COLOR_TEXT);
        g2d.setFont(Config.ARIAL_BOLD_16);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        FontMetrics fontMetric = g2d.getFontMetrics();
        int x0 = (getWidth() - fontMetric.stringWidth(text)) / 2;
        int y0 = ((getHeight() - fontMetric.getHeight()) / 2) + fontMetric.getAscent();
        g2d.drawString(text, x0, y0);
        g2d.dispose();
    }
}
