package hw6_21000699_dangngocquan.exercise006.components.base;

import javax.swing.*;

public abstract class Dialog {
    protected JDialog dialog;
    private final int x;
    private final int y;
    private final int width;

    public Dialog(int x, int y, int width, int height, String title) {
        this.x = x;
        this.y = y;
        this.width = width;

        JFrame f = new JFrame();
        dialog = new JDialog(f, title, true);
        dialog.setLayout(null);
        dialog.setBounds(
                x, y, width+14, height+32
        );
        dialog.setIconImage(null);
        dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        addComponents();
        dialog.setVisible(true);
    }

    public abstract void addComponents();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidthDialog() {
        return width;
    }
}
