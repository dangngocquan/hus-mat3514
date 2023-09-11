package hw1_21000699_dangngocquan.exercise006.p1dot30;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public App() {
        super("P1.30");
        setSize(Config.WIDTH, Config.HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addBoxInput();
        addBars();

        setVisible(true);

    }

    public void addBars() {
        this.add(new Bar(0, 0, 100, 300));
    }

    public void addBoxInput() {
        JScrollPane scrollPane = new JScrollPane(
                new BoxInput(
                        200, 400, 100, 300, 1, 5, 5
                )
        );

        this.add(new BoxInput(
                200, 400, 100, 300, 1, 5, 5
        ));
    }
}
