package hw5_21000699_dangngocquan.exercise004.components.base;

import hw5_21000699_dangngocquan.exercise004.services.TransitionColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JButton {
    private TransitionColor tempTransitionColor;
    private final Color backgroundColorEntered;
    private final Color backgroundColorClicked;
    private final Color backgroundColor;
    private boolean isClicked;

    public Button(int x, int y, int width, int height, String text) {
        super(text);
        this.backgroundColor = new Color(210, 210, 210);
        this.backgroundColorEntered = new Color(200, 255, 200);
        this.backgroundColorClicked = new Color(150, 150, 255);
        int borderWidth = 2;
        Color borderColor = Color.BLACK;
        this.isClicked = false;

        setLayout(null);
        setSize(width, height);
        setBounds(x, y, width, height);
        setFocusPainted(false);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        setUI(new BasicButtonUI());
        addMouseListener(new MouseHandler());
        setBackground(new Color(210, 210, 210));
        setBorder(new LineBorder(
                borderColor, borderWidth
        ));
        setVisible(true);
    }

    private Component getInstance() {
        return this;
    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (tempTransitionColor != null) {
                tempTransitionColor.stop();
            }
            if (getInstance().isEnabled()) {
                isClicked = true;
                tempTransitionColor = new TransitionColor(
                        getInstance(),
                        backgroundColorEntered,
                        backgroundColorClicked,
                        0, 300
                );
                tempTransitionColor.start();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (tempTransitionColor != null) {
                tempTransitionColor.stop();
            }
            if (getInstance().isEnabled()) {
                if (isClicked) {
                    getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
                    tempTransitionColor = new TransitionColor(
                            getInstance(),
                            backgroundColor,
                            backgroundColorClicked,
                            0, 300
                    );
                } else {
                    getInstance().setCursor(new Cursor(Cursor.HAND_CURSOR));
                    tempTransitionColor = new TransitionColor(
                            getInstance(),
                            backgroundColor,
                            backgroundColorEntered,
                            0, 300
                    );
                }
                tempTransitionColor.start();
            } else {
                getInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setBackground(backgroundColor);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (tempTransitionColor != null) {
                tempTransitionColor.stop();
            }
            if (getInstance().isEnabled()) {
                if (isClicked) {
                    tempTransitionColor = new TransitionColor(
                            getInstance(),
                            backgroundColorEntered,
                            backgroundColorClicked,
                            0, 300
                    );
                } else {
                    tempTransitionColor = new TransitionColor(
                            getInstance(),
                            backgroundColorEntered,
                            backgroundColor,
                            0, 300
                    );
                }
                tempTransitionColor.start();
            } else {
                setBackground(backgroundColor);
            }

        }
    }
}