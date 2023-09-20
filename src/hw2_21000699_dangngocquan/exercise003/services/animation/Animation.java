package hw2_21000699_dangngocquan.exercise003.services.animation;

import hw2_21000699_dangngocquan.exercise003.components.Panel;

import javax.swing.*;

public class Animation {
    public static void translate(
            Panel panel,
            int translateX, int translateY,
            int delay, int duration,
            int zOrder) {
        (new PanelTransform(
                panel,
                translateX, translateY,
                delay, duration, zOrder)
        ).start();
    }
}
