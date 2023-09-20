package hw2_21000699_dangngocquan.exercise003;

import hw2_21000699_dangngocquan.exercise003.components.Panel;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.components.ViewController;

import javax.swing.*;

public class App extends JFrame {
    private Panel viewController;
    private Panel viewCards;

    public App() {
        super("Homework 2 - Exercise 3");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.ARIAL_BOLD_12);

        addViewCards();
        addViewController();


        setVisible(true);
    }

    public void addViewCards() {
        if (viewCards == null) {
            viewCards = new ViewCards(0, 0, Config.WIDTH, Config.HEIGHT_VIEW_CARDS,
                    Config.BACKGROUND_COLOR_APP, null, "");
            add(viewCards);
        }
    }

    public void addViewController() {
        if (viewController == null) {
            viewController = new ViewController(0, Config.HEIGHT_VIEW_CARDS,
                    Config.WIDTH, Config.HEIGHT - Config.HEIGHT_VIEW_CARDS,
                    Config.BACKGROUND_COLOR_VIEW_CONTROLLER, null, "");
            add(viewController);
        }
    }

    public Panel getViewController() {
        return viewController;
    }

    public Panel getViewCards() {
        return viewCards;
    }
}
