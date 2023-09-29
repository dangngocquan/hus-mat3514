package hw3_21000699_dangngocquan.exercise004;

import hw3_21000699_dangngocquan.exercise004.components.base.Panel;
import hw3_21000699_dangngocquan.exercise004.components.components.ViewController;
import hw3_21000699_dangngocquan.exercise004.components.components.ViewCountWords;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private Panel viewController;
    private Panel viewCountWords;

    public App() {
        super("Homework 3 - Exercise 4");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.ARIAL_BOLD_18);

        addViewController();
        addViewCountWords();

        setVisible(true);
    }

    public void addViewController() {
        viewController = new ViewController(
                0, 0, Config.WIDTH / 2, Config.HEIGHT,
                new Color(90, 62, 122),
                null,
                ""
        );
        add(viewController);
    }

    public void addViewCountWords() {
        viewCountWords = new ViewCountWords(
                Config.WIDTH / 2, 0, Config.WIDTH / 2, Config.HEIGHT,
                new Color(187, 236, 205),
                null,
                ""
        );
        add(viewCountWords);
    }

    public Panel getViewController() {
        return viewController;
    }

    public Panel getViewCountWords() {
        return viewCountWords;
    }
}
