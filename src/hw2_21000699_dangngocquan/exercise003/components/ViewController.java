package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.App;
import hw2_21000699_dangngocquan.exercise003.services.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController extends Panel {
    private Button buttonShuffle;
    public ViewController(int x, int y, int width, int height, Color backgroundColor, ImageIcon backgroundImage, String text) {
        super(x, y, width, height, backgroundColor, backgroundImage, text);
        addButtons();
    }

    public App getApp() {
        return (App) Service.getFrame(this);
    }

    public void addButtons() {
        if (buttonShuffle == null) {
            buttonShuffle = new Button(
                    100, 40, 150, 40, "Shuffle Cards"
            );
            buttonShuffle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((ViewCards) getApp().getViewCards()).shuffleCards();
                }
            });
            add(buttonShuffle);
        }
    }
}
