package hw1_21000699_dangngocquan.exercise006.p1dot31;

import hw1_21000699_dangngocquan.exercise006.p1dot31.components.BasicPanel;
import hw1_21000699_dangngocquan.exercise006.p1dot31.components.ControllerView;
import hw1_21000699_dangngocquan.exercise006.p1dot31.components.EcosystemView;

import javax.swing.*;

public class App extends JFrame {
    private BasicPanel controllerView = null;
    private BasicPanel ecosystemView = null;
    public App() {
        super("P1.31");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.ARIAL_BOLD_12);

        addControllerView();
        addEcosystemView();

        setVisible(true);
    }

    public void addControllerView() {
        this.controllerView = new ControllerView(
            0, 0,
            Config.WIDTH_CONTROLLER_VIEW_COMPONENT,
            Config.HEIGHT_CONTROLLER_VIEW_COMPONENT
        );

        this.add(controllerView);
    }

    public void addEcosystemView() {
        this.ecosystemView = new EcosystemView(
                controllerView.getX() + controllerView.getWidth(),
                controllerView.getY(),
                Config.WIDTH_ECOSYSTEM_VIEW_COMPONENT,
                Config.HEIGHT_ECOSYSTEM_VIEW_COMPONENT,
                getEcosystemSize()
        );

        this.add(ecosystemView);
    }

    public int getEcosystemSize() {
        return ((ControllerView) controllerView).getEcosystemSize();
    }
}
