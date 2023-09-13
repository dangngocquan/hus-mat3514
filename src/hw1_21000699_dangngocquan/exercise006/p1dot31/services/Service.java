package hw1_21000699_dangngocquan.exercise006.p1dot31.services;


import hw1_21000699_dangngocquan.exercise006.p1dot31.App;

import javax.swing.*;
import java.awt.*;

public class Service {
    public static JFrame getFrame(Component theComponent) {
        Component currParent = theComponent;
        JFrame theFrame = null;
        while (currParent != null) {
            if (currParent instanceof JFrame) {
                theFrame = (JFrame) currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return theFrame;
    }
}
