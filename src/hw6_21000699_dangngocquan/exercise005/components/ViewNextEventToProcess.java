package hw6_21000699_dangngocquan.exercise005.components;

import hw6_21000699_dangngocquan.exercise005.Config;
import hw6_21000699_dangngocquan.exercise005.components.base.Panel;

import java.awt.*;

public class ViewNextEventToProcess extends Panel {
    public ViewNextEventToProcess() {
        super(0, Config.HEIGHT - Config.HEIGHT / 5,
                Config.WIDTH, Config.HEIGHT / 5,
                new Color(150, 150, 150),
                null, "No event processing"
        );
    }
}
