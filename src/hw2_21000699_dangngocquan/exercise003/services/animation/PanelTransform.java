package hw2_21000699_dangngocquan.exercise003.services.animation;


import hw2_21000699_dangngocquan.exercise003.components.Panel;
import hw2_21000699_dangngocquan.exercise003.components.ViewCard;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class PanelTransform {
    private Timer timer;
    private Panel panel;
    private int translateX;
    private int translateY;
    private int delay;
    private int duration;
    private int zOrder;
    private int x0;
    private int y0;
    private long msStart;
    private double process = 0.0;


    public PanelTransform(Panel panel, int translateX, int translateY, int delay, int duration, int zOrder) {
        this.panel = panel;
        this.translateX = translateX;
        this.translateY = translateY;
        this.delay = delay;
        this.duration = duration;
        this.zOrder = zOrder;
    }

    public void start() {
        timer = new Timer();
        msStart = System.currentTimeMillis() + delay;
        timer.schedule(new TaskAnimation(), delay, 1);
    }

    public void stop() {
        timer.cancel();
        timer.purge();
    }

    private class TaskAnimation extends TimerTask {


        @Override
        public void run() {
            if (Double.compare(process, 0.0) == 0) {
                x0 = panel.getX();
                y0 = panel.getY();
                panel.getParent().setComponentZOrder(panel, zOrder);
            }
            process = (System.currentTimeMillis() - msStart) * 1.0 / duration;
            if (process >= 1f) {
                panel.setXY(x0 + translateX, y0 + translateY);
                stop();
                return;
            }
            double x = x0 + process * translateX;
            double y = y0 + process * translateY;
            panel.setXY(
                    (int) Math.round(x),
                    (int) Math.round(y)
            );
        }
    }
}
