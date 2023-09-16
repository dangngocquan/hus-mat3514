package hw1_21000699_dangngocquan.exercise006.p2dot30;

import hw1_21000699_dangngocquan.exercise006.p2dot30.components.*;
import javax.swing.*;

public class App extends JFrame {
    private BasicPanel viewComponent = null;
    private BasicPanel inputComponent = null;
    public App() {
        super("P2.30");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addInputComponent();
        addViewComponent();

        setVisible(true);

    }

    public void addViewComponent() {
        this.viewComponent = new ViewComponent(
                0, 0,
                Config.VIEW_COMPONENT_WIDTH,
                Config.VIEW_COMPONENT_HEIGHT
        );
        this.add(viewComponent);
    }

    public void addInputComponent() {
        this.inputComponent = new InputComponent(
                0, Config.VIEW_COMPONENT_HEIGHT,
                Config.INPUT_COMPONENT_WIDTH,
                Config.INPUT_COMPONENT_HEIGHT
        );
        this.add(inputComponent);
    }

    public void renderBarChart(String text) {
        ((ViewComponent) viewComponent).renderBarChart(text);
    }
}
